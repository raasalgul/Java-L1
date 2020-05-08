
package com.junit.generator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
	/*
	 result variable is the one which is printed to the output file. 
	 injectMockObject variable is the one which have the injectmock object name.
	 function varibale is the one which holds the entire function declaration line.
	 */
	String result="package *com*;\r\n"+
			"import org.junit.runner.RunWith;\r\n" + 
			"import org.mockito.InjectMocks;\r\n" + 
			"import org.mockito.Mock;\r\n" + 
			"import org.mockito.Mockito;\r\n"
			+ "import org.junit.Test;\r\n" + 
			"import org.mockito.Spy;\r\n" + 
			"import org.mockito.runners.MockitoJUnitRunner;\r\n" + 
			"@RunWith(MockitoJUnitRunner.class)\n";
//	String inputFile = "C:\\Sathish\\Personal\\eclipse-workspace\\JunitForDTOGenerator\\src\\com\\junit\\generator\\resources\\input.txt";
//	String outputFile = "C:\\Sathish\\Personal\\eclipse-workspace\\JunitForDTOGenerator\\src\\com\\junit\\generator\\resources\\output.txt";
	String injectMockObject="";
	String function="";
	String functionBody="";
	/*
		The start method is where our projects starts
		1. Autowire replaced to Mock.
		2. Frame test classes.
		3. Frame test methods declaration.
		5. populate the function global variable with function declaration line.
		4. Write to the output file.
	 */
	public void start(String inputFile,String outputFile)
	{
		System.out.println("****************InputFile "+inputFile+"****************");
		String packageName=inputFile.substring(inputFile.indexOf("main\\java\\")+10).replace(".java", ";\n").replace("\\", ".");
		packageName=packageName.substring(0,packageName.lastIndexOf("."));
		result=result.replace("*com*", packageName);
		try {
			List<String> list = Files.lines(Paths.get(inputFile)).collect(Collectors.toList()) ;
			for(int index=0;index<list.size();index++)
			{
				String line=list.get(index);
				if(line.contains("@Autowired"))
				{
					if(line.trim().equals("@Autowired"))
					{
						result+="@Mock\n";
						result+=list.get(index+1)+"\n";
					}
					else
					{
						result+="@Mock\n";
						result+=line.trim().replaceAll("@Autowired", "")+"\n";
					}
				}
				else if(line.contains("public class"))
				{
					String injectMock=line.substring(line.indexOf("class")+6).replaceAll(" (.)*", " ");
					result+="public class "+injectMock.trim()+"Test {\n";	
					injectMockObject=injectMock.replace(injectMock.charAt(0), (char) (injectMock.charAt(0)+32)).trim();
					result+="@InjectMocks\n"+injectMock+injectMockObject+";\n";
//					result+="@Mock\nprivate JdbcTemplate jdbcTemplate;\n"
//							+ "@Mock\nprivate SqlRowSet sqlRowSet;\n";
				}
				else if(line.contains("public")&&line.contains("("))
				{
					String[] decomposedArr=line.trim().split(" ");
					String methodAtTest="";
					int methodAtTestIndex=decomposedArr.length-1;
					try {
						while(!decomposedArr[methodAtTestIndex].contains("("))
							methodAtTestIndex--;
					 methodAtTest=decomposedArr[methodAtTestIndex].trim().replaceAll("\\((.)*", "");
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					function=formulateFunctionDefinition(line,list,index,methodAtTest);
					System.out.println("function "+function);
					result+="\n@Test\npublic void "+methodAtTest.trim()+"Test() {";	
					result+=methodBody(list,index,methodAtTest.trim()+"Test");
					functionBody="";
				}
			}
			result=result+"\n}";
			Files.write(Paths.get(outputFile), result.getBytes());
			result="package *com*;\r\n"+
					"import org.junit.runner.RunWith;\r\n" + 
					"import org.mockito.InjectMocks;\r\n" + 
					"import org.mockito.Mock;\r\n" + 
					"import org.mockito.Mockito;\r\n"
					+ "import org.junit.Test;\r\n" + 
					"import org.mockito.Spy;\r\n" + 
					"import org.mockito.runners.MockitoJUnitRunner;\r\n" + 
					"@RunWith(MockitoJUnitRunner.class)\n";
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	private String formulateFunctionDefinition(String line, List<String> list, int index, String methodAtTest) {
		String functionFormation=line.substring(line.indexOf(methodAtTest)).replace('{', ' ').trim();
		if(line.contains(")"))
			return functionFormation;
		else
		{
			while(!line.contains(")"))
			{
				index++;
				line=list.get(index);
				functionFormation+=line.trim();
			}
			return functionFormation.replace('{', ' ').trim();		
		}
	}
	/*
	The methodBody method is where we iterate through the actual input classes method and frame our output method body.
	innerBody variable consists of the content of the test body to be returned.
	argument variable consists of the content of the injectmock object arguments.
	1. Extract the function arguments and frame them as mock declaration lines in the test method with assignments.
	2. With the function argument frame arguments for the injectmock call to that function.
	3. Close the test function with curly braces.
	 */
	private String methodBody(List<String> list, int index, String methodAtTest) {
		String innerBody="";
		String argument="(";
//		String jdbcThen="sqlRowSet";
//		String jdbcMethod="";
		try {
			innerBody=function.trim().substring(function.indexOf('(')+1, function.indexOf(')')).trim();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		innerBody=innerBody.replaceAll(",\\s",",");
		innerBody=isolateCollections(innerBody);
		String[] splitByDataType=innerBody.trim().split(",");
		System.out.println("inner body "+innerBody);
		//innerBody=innerBody.replace(",", ";\n")+";";
		for(String indv:splitByDataType)
		{
			try {
				indv.replaceAll("\n","");
				indv.trim();

				if(indv.length()<=1)
				{
					break;
				}
				System.out.println("indv "+indv);
				String[] variableTypeSplit=indv.split(" ");
				System.out.println("var 0 "+variableTypeSplit[0]);
				if(variableTypeSplit[0].trim().equals("String"))
				{
					System.out.println("inside "+variableTypeSplit[1]);
					functionBody+="\n"+indv+"="+"\""+variableTypeSplit[1]+"\";";
				}
				else if(variableTypeSplit[0].trim().equals("int") || variableTypeSplit[0].trim().equals("long")|| variableTypeSplit[0].trim().equals("float")|| variableTypeSplit[0].trim().equals("double"))
				{
					System.out.println("elseif "+variableTypeSplit[1]);
					functionBody+="\n"+indv+"="+1+";";
				}
				else if(variableTypeSplit[0].trim().startsWith("List"))
				{
					functionBody+="\n"+indv+"="+"new ArrayList<>();";
				}
				else if(variableTypeSplit[0].trim().equals("Map"))
				{
					functionBody+="\n"+indv+"="+"new HashMap<>();";
				}
				else if(variableTypeSplit[0].trim().equals("Date")||variableTypeSplit[0].trim().equals("Integer")||variableTypeSplit[0].trim().equals("Long")||variableTypeSplit[0].trim().equals("Double"))
				{
					functionBody+="\n"+indv+"="+"new "+variableTypeSplit[0]+"(32213);";
				}
				else if(variableTypeSplit[0].trim().equals("boolean"))
				{
					functionBody+="\n"+indv+"=true;";
				}
				else
				{
					System.out.println("else "+variableTypeSplit[1]);
					functionBody+="\n"+indv+"="+"new "+variableTypeSplit[0]+"();";
				}

				System.out.println("var 1 "+variableTypeSplit[1]);
				argument+=variableTypeSplit[1]+",";
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(argument.length()>1)
			argument=argument.substring(0, argument.length()-1);
		argument+=")";
		for(int i=index+1;i<list.size();i++)
		{
			String actualFunctionLine=list.get(i);
			if(actualFunctionLine.contains("public")||actualFunctionLine.contains("private")||actualFunctionLine.contains("protected"))
				break;
			if(actualFunctionLine.startsWith("get"))
			{
				actualFunctionLine=actualFunctionLine.substring(actualFunctionLine.indexOf("get"));
				actualFunctionLine.replace(")(.)*", ")");
				functionBody+="\n"+injectMockObject+"."+actualFunctionLine;
			}
		}
		return functionBody+"\n"+injectMockObject+"."+methodAtTest.replace("Test", "")+argument+";\n}\n";
	}
	private String isolateCollections(String innerBody) {
		for(String collection:Constants.collections)
		{
			if(innerBody.contains(""+collection+"<"))
			{
				int firstOccurance=innerBody.indexOf(collection);
				int lastOccurance=innerBody.lastIndexOf(collection);
				String subAngle=innerBody.substring(innerBody.indexOf("<"),innerBody.indexOf(">")+1);
				String remainingSub=innerBody.substring(innerBody.indexOf(collection)).replace(collection+subAngle, "").replaceAll(",(.)*","");
				String collectionFormed=collection+subAngle+remainingSub;
				String createObject="";
				if(collection.equals("Map"))
				{
					createObject="= new HashMap<>()";
				}
				functionBody+="\n"+collectionFormed+createObject+";";
				System.out.println(collectionFormed);
				innerBody=innerBody.replace(collectionFormed, "");
				innerBody.trim();
				innerBody=innerBody.replace(",", "");
				if(firstOccurance==lastOccurance)
					return innerBody;
				else
					return isolateCollections(innerBody);
			}
		}
		return innerBody;
	}
}
