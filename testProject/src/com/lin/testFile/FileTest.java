package com.lin.testFile;

import java.io.File;

public class FileTest {
	public static final String path = "F:/1/2/3/" ;
	public static final String path2 = "F:/1/2/4/" ;
	public static final String path3 = "F:/1/2/5/" ;
//	public static void main(String[] args) {
//		File file = new File(path) ;
//		if(!file.exists()){
//			System.out.println(file.mkdirs()); 
//		}
//		file = new File(path2) ;
//		if(!file.exists()){
//			System.out.println(file.mkdirs()); 
//		}
//		file = new File(path3) ;
//		if(!file.exists()){
//			System.out.println(file.mkdirs()); 
//		}
//		
//		File f = new File("F:/1/2") ;
//		if(f.isDirectory())
//	
	public static void main(String[] args) {
		File file = new File("E:\\CrackCaptcha.log") ;
		
	    new FileTest().clearFiles("F:/1/2");
	   }

	//删除文件和目录
	private void clearFiles(String workspaceRootPath){
	     File file = new File(workspaceRootPath);
	     if(file.exists()){
	          deleteFile(file);
	     }
	}
	private void deleteFile(File file){
	     if(file.isDirectory()){
	          File[] files = file.listFiles();
	          for(int i=0; i<files.length; i++){
	               deleteFile(files[i]);
	          }
	     }
	     file.delete();
	}
//	}
}
