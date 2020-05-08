package com.junit.generator;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

public class CreatingStructure {
	public static String test_dir;
	public static void main(String[] args) {
		String path="C:\\Sathish\\Personal\\UnitCaseGeneratorDto\\main\\java";
		//Creating test directory
		test_dir=path.substring(0,path.indexOf("main"))+"test"+"\\"+"java Automated Testcase";
		System.out.println(test_dir);
		File folder = new File(path);
		String dir=test_dir;
		File testDir=new File(dir);

		try {
			testDir.mkdirs();
		} catch (SecurityException Se) {
			System.out.println("Error while creating directory in Java:" + Se);
		}
		System.out.println("test folder created");
		CreatingStructure creatingStructure=new CreatingStructure();
		creatingStructure.createFiles(folder,path,dir);
		System.out.println("Created test files inside test directory");
	}
	public void createFiles(File folder,String path,String dir) {
		File[] listOfFiles = folder.listFiles();
		MainClass main=new MainClass();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().matches(".*\\.java")) {
				String []names=listOfFiles[i].getName().split("\\.");			  		 
				String temp_path=StringUtils.difference(path,listOfFiles[i].getAbsolutePath());			 
				String destination=test_dir+temp_path.substring(0, temp_path.indexOf(listOfFiles[i].getName()))+names[0]+"Test"+"."+names[1];
				// System.out.println(testFile);
				//Start the Main class for creating test files
				main.start(listOfFiles[i].toString(),destination);
			}
			else if (listOfFiles[i].isDirectory()) {
				dir=test_dir+StringUtils.difference( path, listOfFiles[i].getAbsolutePath());
				File testDir=new File(dir);
				try {
					testDir.mkdir();
				} catch (SecurityException Se) {
					System.out.println("Error while creating directory in Java:" + Se);
				}
				String file_path=listOfFiles[i].getAbsolutePath();
				File folder1=new File(file_path);
				createFiles(folder1,path,dir);
			}
		}
	}

}
