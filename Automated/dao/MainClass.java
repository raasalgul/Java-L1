
package com.junit.generator;

import java.io.IOException;
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
	String result="import org.junit.runner.RunWith;\r\n" + 
			"import org.mockito.InjectMocks;\r\n" + 
			"import org.mockito.Mock;\r\n" + 
			"import org.mockito.Mockito;\r\n"
			+ "import org.junit.Test;\r\n" + 
			"import org.mockito.Spy;\r\n" + 
			"import org.mockito.runners.MockitoJUnitRunner;\r\n" + 
			"import org.springframework.jdbc.core.JdbcTemplate;\r\n" + 
			"import org.springframework.jdbc.support.rowset.SqlRowSet;\r\n\n" +
			"@RunWith(MockitoJUnitRunner.class)\n";
	//	String inputFile = "C:\\Sathish\\Personal\\eclipse-workspace\\JunitForDAOGenerator\\src\\com\\junit\\generator\\resources\\input.txt";
	//	String outputFile = "C:\\Sathish\\Personal\\eclipse-workspace\\JunitForDAOGenerator\\src\\com\\junit\\generator\\resources\\output.txt";
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
		try {
			List<String> list = Files.lines(Paths.get(inputFile)).collect(Collectors.toList()) ;
			for(int index=0;index<list.size();index++)
			{
				String line=list.get(index);
				if(line.startsWith("/*")||line.startsWith("//")||line.endsWith("/*")||line.contains("Logger"))
					continue;
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
				// Check for class
				else if(line.contains("public class"))
				{
					String injectMock=line.substring(line.indexOf("class")+6).replaceAll(" (.)*", " ");
					result+="public class "+injectMock.trim()+"Test {\n";	
					injectMockObject=injectMock.replace(injectMock.charAt(0), (char) (injectMock.charAt(0)+32)).trim();
					result+="@InjectMocks\n"+injectMock+injectMockObject+";\n";
					result+="@Mock\nprivate JdbcTemplate jdbcTemplate;\n"
							+ "@Mock\nprivate SqlRowSet sqlRowSet;\n";
				}
				// Check for method
				else if(line.contains("public")&&line.contains("("))
				{
					String[] decomposedArr=line.trim().split(" ");
					String methodAtTest=decomposedArr[2].trim().replaceAll("\\((.)*", "");
					//Function definition formation
					function=formulateFunctionDefinition(line,list,index,methodAtTest);
					System.out.println("function "+function);
					result+="\n@Test\npublic void "+methodAtTest.trim()+"Test() {";	
					//Function Body formation
					result+=methodBody(list,index,methodAtTest.trim()+"Test");
					functionBody="";
				}
			}
			result=result+"\n}";
			Files.write(Paths.get(outputFile), result.getBytes());
			System.out.println("---------------Output "+outputFile+"--------------");
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
	private String formulateFunctionInvoke(String line, List<String> list, int index, String methodAtTest) {
		String functionFormation=line.substring(line.indexOf(methodAtTest)).replace('{', ' ').trim();
		if(line.contains(");"))
			return functionFormation;
		else
		{
			while(!line.contains(");"))
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
		String jdbcThen="sqlRowSet";
		String jdbcMethod="";
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
				else if(variableTypeSplit[0].trim().equals("int"))
				{
					System.out.println("elseif "+variableTypeSplit[1]);
					functionBody+="\n"+indv+"="+1+";";
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
			String arguments="";
			if(actualFunctionLine.contains("public")||actualFunctionLine.contains("private")||actualFunctionLine.contains("protected"))
				break;
			// Framing for jdbc Mock
			for(String jdbcMockito:Constants.jdbcMockitoList)
			{
				if(actualFunctionLine.contains(jdbcMockito))
				{
					//String line, List<String> list, int index, String methodAtTest
					actualFunctionLine=formulateFunctionInvoke(actualFunctionLine,list,i,jdbcMockito);
					arguments=actualFunctionLine.substring(actualFunctionLine.indexOf(jdbcMockito));
					arguments=arguments.substring(arguments.indexOf("(")+1,arguments.lastIndexOf(")"));
					if(arguments.charAt(0)=='"')
					{
						arguments=arguments.replace(arguments.subSequence(0, arguments.lastIndexOf('"')+1), "Mockito.anyString()");
					}
					String[] argumentSplit=arguments.split(",");
					for(int in=0;in<argumentSplit.length;in++)
					{
						if(in==0)
							arguments=arguments.replace(argumentSplit[0], "Mockito.anyString()");
						else if(in==argumentSplit.length-1 && Constants.jdbcReturnList.contains(argumentSplit[in].trim()))
						{
							arguments=arguments.replace(argumentSplit[in], "Mockito.eq("+argumentSplit[in]+")");	
							functionBody+="\n String resultString=\"{\\\"test\\\":\\\"test\\\"}\";";	
							functionBody+="\n Integer resultInt=1;";
							jdbcThen=argumentSplit[in].replace(".class","");
							if(argumentSplit[in].contains("Integer"))
								jdbcThen="resultInt";	
							else if(argumentSplit[in].contains("String"))
								jdbcThen="resultString";
						}
						else
						{
							arguments=arguments.replace(argumentSplit[in], "Mockito.any()");	
							jdbcThen="sqlRowSet";
						}

					}
					functionBody=functionBody.concat("\nMockito.when(jdbcTemplate."+jdbcMockito+"("+arguments+")).thenReturn("+jdbcThen+");");
					System.out.println("arguments "+arguments);	
				}
			}

			//Framing while loop
			if(actualFunctionLine.contains("while")&&actualFunctionLine.contains(".next()"))
			{
				functionBody=functionBody.concat("\nMockito.when(sqlRowSet.next()).thenReturn(true,false);");
			}

			//Framing if for sqlRowSet
			if(actualFunctionLine.contains("if")&&actualFunctionLine.contains(".next()"))
			{
				functionBody=functionBody.concat("\nMockito.when(sqlRowSet.next()).thenReturn(true);");
			}
		}
		return functionBody+"\n"+injectMockObject+"."+methodAtTest.replace("Test", "")+argument+";\n}\n";
	}
	private String isolateCollections(String innerBody) {
		for(String collection:Constants.collections)
		{
			if(innerBody.contains(""+collection))
			{
				int firstOccurance=innerBody.indexOf(collection);
				int lastOccurance=innerBody.lastIndexOf(collection);
				String subAngle=innerBody.substring(innerBody.indexOf("<"),innerBody.indexOf(">")+1);
				String remainingSub=innerBody.substring(innerBody.indexOf(collection)).replace(collection+subAngle, "").replaceAll(",(.)*","");
				String collectionFormed=collection+subAngle+remainingSub;
				functionBody+=collectionFormed+";\n";
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
