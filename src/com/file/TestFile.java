/*package com.file;

public class TestFile {
	//1.创建文件夹
	//import java.io.*;
	public void createFileDirs(){
		File myFolderPath = new File("xxx");
		new 
		try {
			if (!myFolderPath.exists()) {
				myFolderPath.mkdir();
			}
		}
		catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
		} 
	}

	//2.创建文件
	public void createFile(){
		//import java.io.*;
		File myFilePath = new File("templates");
		try {
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			myFile.println(%%2);
			myFile.flush();
			resultFile.close();
		}
		catch (Exception e) {
			System.out.println("新建文件操作出错");
			e.printStackTrace();
		} 
	}

	//3.删除文件
	public void deleteFile(){
		//import java.io.*;
		File myDelFile = new File("templates");
		try {
			myDelFile.delete();
		}
		catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		} 

	}
	
	//4.删除文件夹
	
	 import java.io.*;
		import java.util.*;
		
	public void deleteDirs(){
		
		LinkedList folderList = new LinkedList<String>();
		folderList.add("templates");
		while (folderList.size() > 0) {
			File file = new File(folderList.poll());
			File[] files = file.listFiles();
			ArrayList<File> fileList = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					folderList.add(files[i].getPath());
				} else {
					fileList.add(files[i]);
				}
			}
			for (File f : fileList) {
				f.delete();
			}
		}
		folderList = new LinkedList<String>();
		folderList.add("templates");
		while (folderList.size() > 0) {
			File file = new File(folderList.getLast());
			if (file.delete()) {
				folderList.removeLast();
			} else {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					folderList.add(files[i].getPath());
				}
			}
		}
	}
	

	//5.删除一个文件下夹所有的文件夹
	
	import java.io.*;
	private static LinkedList<String> folderList=null;
	
	public void deleteAllDirs(){
		File delfile=new File("templates");
		File[] files=delfile.listFiles();
		for(int i=0;i<files.length;i++){
			if(files[i].isDirectory()){
				if(!files[i].delete()){
					folderList = new LinkedList<String>();
					folderList.add(files[i]);
					while (folderList.size() > 0) {
						File file = new File(folderList.poll());
						File[] files = file.listFiles();
						ArrayList<File> fileList = new ArrayList<File>();
						for (int i = 0; i < files.length; i++) {
							if (files[i].isDirectory()) {
								folderList.add(files[i].getPath());
							} else {
								fileList.add(files[i]);
							}
						}
						for (File f : fileList) {
							f.delete();
						}
					}
					folderList = new LinkedList<String>();
					folderList.add(files[i]);
					while (folderList.size() > 0) {
						File file = new File(folderList.getLast());
						if (file.delete()) {
							folderList.removeLast();
						} else {
							File[] files = file.listFiles();
							for (int i = 0; i < files.length; i++) {
								folderList.add(files[i].getPath());
							}
						}
					}
				}
			}
		} 
	}

	//6.清空文件夹
	//import java.io.*;
	public void clearDirs(){
		File delfilefolder=new File("templates");
		try {
			if (!delfilefolder.exists() && !delfilefolder.delete()){
				LinkedList folderList = new LinkedList<String>();
				folderList.add(delfilefolder);
				while (folderList.size() > 0) {
					File file = new File(folderList.poll());
					File[] files = file.listFiles();
					ArrayList<File> fileList = new ArrayList<File>();
					for (int i = 0; i < files.length; i++) {
						if (files[i].isDirectory()) {
							folderList.add(files[i].getPath());
						} else {
							fileList.add(files[i]);
						}
					}
					for (File f : fileList) {
						f.delete();
					}
				}
				folderList = new LinkedList<String>();
				folderList.add(delfilefolder);
				while (folderList.size() > 0) {
					File file = new File(folderList.getLast());
					if (file.delete()) {
						folderList.removeLast();
					} else {
						File[] files = file.listFiles();
						for (int i = 0; i < files.length; i++) {
							folderList.add(files[i].getPath());
						}
					}
				}
			}
			delfilefolder.mkdir();
		}
		catch (Exception e) {
			System.out.println("清空目录操作出错");
			e.printStackTrace();
		} 
	}
	

	//7.读取文件
	//import java.io.*;
	// 逐行读取数据
	
	public void writeallFiles(){
		File file = new File("xxx");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String xxx = br.readLine();
		while (xxx != null) {
			xxx = br.readLine();
		}
		br.close();
		fr.close(); 
	}

	// 8.写入文件
	//import java.io.*;
	// 将数据写入文件
	public void writeToFile(){
		
		FileWriter fw = new FileWriter(new File("xxx"));
		fw.write("34ijsdijfsoaj");
		fw.flush();
		fw.close();
	}

	//9.写入随机文件
	//import java.io.*;
	try {
		RandomAcessFile logFile=new RandomAcessFile("templates","rw");
		long lg=logFile.length();
		logFile.seek(%%2);
		logFile.writeByte(%%3);
	}catch(IOException ioe){
		System.out.println("无法写入文件："+ioe.getMessage());
	} 

	10.读取文件属性
	//import java.io.*;
	// 文件属性的取得
	File af = new File("templates");
	if (af.exists()) {
		System.out.println(f.getName() + "的属性如下： 文件长度为：" + f.length());
		System.out.println(f.isFile() ? "是文件" : "不是文件");
		System.out.println(f.isDirectory() ? "是目录" : "不是目录");
		System.out.println(f.canRead() ? "可读取" : "不");
		System.out.println(f.canWrite() ? "是隐藏文件" : "");
		System.out.println("文件夹的最后修改日期为：" + new Date(f.lastModified()));
	} else {
		System.out.println(f.getName() + "的属性如下：");
		System.out.println(f.isFile() ? "是文件" : "不是文件");
		System.out.println(f.isDirectory() ? "是目录" : "不是目录");
		System.out.println(f.canRead() ? "可读取" : "不");
		System.out.println(f.canWrite() ? "是隐藏文件" : "");
		System.out.println("文件的最后修改日期为：" + new Date(f.lastModified()));
	}
	if(f.canRead()){
		%%2
	}
	if(f.canWrite()){
		%%3
	} 

	11.写入属性
	//import java.io.*;
	File filereadonly=new File("templates");
	try {
		boolean b=filereadonly.setReadOnly();
	}
	catch (Exception e) {
		System.out.println("拒绝写访问："+e.printStackTrace());
	} 

	12.枚举一个文件夹中的所有文件
	
	import java.io.*;
	import java.util.*;
	
	LinkedList<String> folderList = new LinkedList<String>();
	folderList.add("templates");
	while (folderList.size() > 0) {
		File file = new File(folderList.poll());
		File[] files = file.listFiles();
		List<File> fileList = new ArrayList<File>();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				folderList.add(files[i].getPath());
			} else {
				fileList.add(files[i]);
			}
		}
		for (File f : fileList) {
			%%2=f.getAbsoluteFile();
			%%3
		}
	}

	13.复制文件夹 
	
	import java.io.*;
	import java.util.*;
	
	LinkedList<String> folderList = new LinkedList<String>();
	folderList.add("templates");
	LinkedList<String> folderList2 = new LinkedList<String>();
	folderList2.add(%%2+ "templates".substring("templates".lastIndexOf("\\")));
	while (folderList.size() > 0) {
		(new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹
		File folders = new File(folderList.peek());
		String[] file = folders.list();
		File temp = null;
		try {
			for (int i = 0; i < file.length; i++) {
				if (folderList.peek().endsWith(File.separator)) {
					temp = new File(folderList.peek() + File.separator
						+ file[i]);
				} else {
					temp = new File(folderList.peek() + File.separator
						+ file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(
						folderList2.peek() + File.separator
						+ (temp.getName()).toString());
					byte[] b = new byte[5120];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					for (File f : temp.listFiles()) {
						if (f.isDirectory()) {
							folderList.add(f.getPath());
							folderList2.add(folderList2.peek()
								+ File.separator + f.getName());
						}
					}
				}
			}
		} catch (Exception e) {
			//System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();
		}
		folderList.removeFirst();
		folderList2.removeFirst();
	}

	14.复制一个目录下所有的文件夹到另一个文件夹下
	
	import java.io.*;
	import java.util.*;
	
	File copyfolders=new File("templates");
	File[] copyfoldersList=copyfolders.listFiles();
	for(int k=0;k<copyfoldersList.length;k++){
		if(copyfoldersList[k].isDirectory()){
			List<String>folderList=new ArrayList<String>();
			folderList.add(copyfoldersList[k].getPath());
			List<String>folderList2=new ArrayList<String>();
			folderList2.add(%%2+"/"+copyfoldersList[k].getName());
			for(int j=0;j<folderList.size();j++){
				(new File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹
				File folders=new File(folderList.get(j));
				String[] file=folders.list();
				File temp=null;
				try {
					for (int i = 0; i < file.length; i++) {
						if(folderList.get(j).endsWith(File.separator)){
							temp=new File(folderList.get(j)+File.separator+file[i]);
						}
						else{
							temp=new File(folderList.get(j)+File.separator+file[i]);
						}
						FileInputStream input = new FileInputStream(temp);
						if(temp.isFile()){
							FileOutputStream output = new FileOutputStream(folderList2.get(j) + File.separator +
								(temp.getName()).toString());
							byte[] b = new byte[5120];
							int len;
							while ( (len = input.read(b)) != -1) {
								output.write(b, 0, len);
							}
							output.flush();
							output.close();
							input.close();
						}
						if(temp.isDirectory()){//如果是子文件夹
							folderList.add(folderList.get(j)+"/"+file[i]);
							folderList2.add(folderList2.get(j)+"/"+file[i]);
						}
					}
				}
				catch (Exception e) {
					System.out.println("复制整个文件夹内容操作出错");
					e.printStackTrace();
				}
			}
		}
	}

	15.移动文件夹
	
	import java.io.*;
	import java.util.*;
	
	LinkedList<String> folderList = new LinkedList<String>();
	folderList.add("templates");
	LinkedList<String> folderList2 = new LinkedList<String>();
	folderList2.add(%%2	+ "templates".substring("templates".lastIndexOf("\\")));
	while (folderList.size() > 0) {
		(new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹
		File folders = new File(folderList.peek());
		String[] file = folders.list();
		File temp = null;
		try {
			for (int i = 0; i < file.length; i++) {
				if (folderList.peek().endsWith(File.separator)) {
					temp = new File(folderList.peek() + File.separator
						+ file[i]);
				} else {
					temp = new File(folderList.peek() + File.separator
						+ file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(
						folderList2.peek() + File.separator
						+ (temp.getName()).toString());
					byte[] b = new byte[5120];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
					if (!temp.delete())
						//删除单个文件操作出错
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					for (File f : temp.listFiles()) {
						if (f.isDirectory()) {
							folderList.add(f.getPath());
							folderList2.add(folderList2.peek()
								+ File.separator + f.getName());
						}
					}
				}
			}
		} catch (Exception e) {
			//复制整个文件夹内容操作出错
			e.printStackTrace();
		}
		folderList.removeFirst();
		folderList2.removeFirst();

	}
	File f = new File("templates");
	if (!f.delete()) {
		for (File file : f.listFiles()) {
			if (file.list().length == 0) {
				System.out.println(file.getPath());
				file.delete();
			}
		}
	}

	16.移动一个目录下所有的文件夹到另一个目录下
	
	import java.io.*;
	import java.util.*;
	
	File movefolders=new File("templates");
	File[] movefoldersList=movefolders.listFiles();
	for(int k=0;k<movefoldersList.length;k++){
		if(movefoldersList[k].isDirectory()){
			List<String>folderList=new ArrayList<String>();
			folderList.add(movefoldersList[k].getPath());
			List<String>folderList2=new ArrayList<String>();
			folderList2.add(%%2+"/"+movefoldersList[k].getName());
			for(int j=0;j<folderList.size();j++){
				(new File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹
				File folders=new File(folderList.get(j));
				String[] file=folders.list();
				File temp=null;
				try {
					for (int i = 0; i < file.length; i++) {
						if(folderList.get(j).endsWith(File.separator)){
							temp=new File(folderList.get(j)+File.separator+file[i]);
						}
						else{
							temp=new File(folderList.get(j)+File.separator+file[i]);
						}
						FileInputStream input = new FileInputStream(temp);
						if(temp.isFile()){
							FileInputStream input = new FileInputStream(temp);
							FileOutputStream output = new FileOutputStream(folderList2.get(j) + "/" +
								(temp.getName()).toString());
							byte[] b = new byte[5120];
							int len;
							while ( (len = input.read(b)) != -1) {
								output.write(b, 0, len);
							}
							output.flush();
							output.close();
							input.close();
							temp.delete();
						}
						if(temp.isDirectory()){//如果是子文件夹
							folderList.add(folderList.get(j)+"/"+file[i]);
							folderList2.add(folderList2.get(j)+"/"+file[i]);
						}
					}
				}
				catch (Exception e) {
					//复制整个文件夹内容操作出错
					e.printStackTrace();
				}
			}
			movefoldersList[k].delete();
		}
	}

	17.以一个文件夹的框架在另一个目录创建文件夹和空文件
	
	import java.io.*;
	import java.util.*;
	
	boolean b=false;//不创建空文件
	List<String>folderList=new ArrayList<String>();
	folderList.add("templates");
	List<String>folderList2=new ArrayList<String>();
	folderList2.add(%%2);
	for(int j=0;j<folderList.size();j++){
		(new File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹
		File folders=new File(folderList.get(j));
		String[] file=folders.list();
		File temp=null;
		try {
			for (int i = 0; i < file.length; i++) {
				if(folderList.get(j).endsWith(File.separator)){
					temp=new File(folderList.get(j)+File.separator+file[i]);
				}
				else{
					temp=new File(folderList.get(j)+File.separator+file[i]);
				}
				if(temp.isFile()){
					if (b) temp.createNewFile();
				}
				if(temp.isDirectory()){//如果是子文件夹
					folderList.add(folderList.get(j)+"/"+file[i]);
					folderList2.add(folderList2.get(j)+"/"+file[i]);
				}
			}
		}
		catch (Exception e) {
			//复制整个文件夹内容操作出错
			e.printStackTrace();
		}
	}

	18.复制文件
	//import java.io.*;
	int bytesum = 0;
	int byteread = 0;
	File oldfile = new File("templates");
	try {
		if (oldfile.exists()) { //文件存在时
			FileInputStream inStream = new FileInputStream(oldfile); //读入原文件
			FileOutputStream fs = new FileOutputStream(new File(%%2,oldfile.getName()));
			byte[] buffer = new byte[5120];
			while ( (byteread = inStream.read(buffer)) != -1) {
				bytesum += byteread; //字节数 文件大小
				fs.write(buffer, 0, byteread);
			}
			inStream.close();
		}
	}
	catch (Exception e) {
		//复制单个文件操作出错
		e.printStackTrace();
	} 

	19.复制一个目录下所有的文件到另一个目录
	//import java.io.*;
	File copyfiles=new File("templates");
	File[] files=copyfiles.listFiles();
	for(int i=0;i<files.length;i++){
		if(files[i].isFile()){
			int bytesum = 0;
			int byteread = 0;
			try {
				InputStream inStream = new FileInputStream(files[i]); //读入原文件
				FileOutputStream fs = new FileOutputStream(new File(%%2,files[i].getName());
				byte[] buffer = new byte[5120];
				while ( (byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; //字节数 文件大小
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			} catch (Exception e) {
				//复制单个文件操作出错
				e.printStackTrace();
			}
		}
	} 

	20.提取扩展名
	String %%2="templates".substring("templates".lastIndexOf("."));

	21.提取文件名
	String %%2="templates".substring("templates".lastIndexOf("\\")+1);

	22.提取文件路径
	String %%2="templates".substring(0,"templates".lastIndexOf("\\")); 

	23.替换扩展名
	//import java.io.*;
	File replaceExt=new File("templates");
	replaceExt.renameTo(replaceExt.getName().split(".")[0]+"."+%%2); 

	24.追加路径
	final String path="templates".endsWith("\\")?"templates":"templates"+"\\";
	%%3=path+%%2;

	25.移动文件
	//import java.io.*;
	int bytesum = 0;
	int byteread = 0;
	File oldfile = new File("templates");
	try {
		if (oldfile.exists()) { //文件存在时
			InputStream inStream = new FileInputStream(oldfile); //读入原文件
			FileOutputStream fs = new FileOutputStream(new File(%%2,oldfile.getName()));
			byte[] buffer = new byte[5120];
			while ( (byteread = inStream.read(buffer)) != -1) {
				bytesum += byteread; //字节数 文件大小
				fs.write(buffer, 0, byteread);
			}
			inStream.close();
			oldfile.delete();
		}
	}
	catch (Exception e) {
		//复制单个文件操作出错
		e.printStackTrace();
	} 

	26.移动一个目录下所有文件到另一个目录
	//import java.io.*;
	File movefile=new File("templates");
	File[] movefiles=movefile.listFiles();
	for(int i=0;i<movefiles.length;i++){
		if(movefiles[i].isFile()){
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(movefiles[i]);
			try {
				if (oldfile.exists()) { //文件存在时
					InputStream inStream = new FileInputStream(oldfile); //读入原文件
					FileOutputStream fs = new FileOutputStream(new File(%%2,oldfile.getName()));
					byte[] buffer = new byte[5120];
					while ( (byteread = inStream.read(buffer)) != -1) {
						bytesum += byteread; //字节数 文件大小
						fs.write(buffer, 0, byteread);
					}
					inStream.close();
					oldfile.delete();
				}
			}
			catch (Exception e) {
				//复制单个文件操作出错
				e.printStackTrace();
			}
		}
	} 

	27.指定目录下搜索文件
	//import java.io.*;
	private static final String filter="templates"; //"*.*"
	private static void doSearch(String path){
		File file = new File(path);
		if(file.exists()) {
			if(file.isDirectory()) {
				File[] fileArray = file.listFiles();
				for(File f:fileArray) {
					if(f.isDirectory()) {
						doSearch(f.getPath());
					} else {
						if(f.getName().indexOf(filter) >= 0) {
							//f.getPath()
						}
					}
					//f.getPath()
				}
				//"The numbers of files had been found:" + countFiles
			} else {
				//"Couldn't open the path!"
			}
		} else {
			System.out.println("The path had been apointed was not Exist!");
		}
	}
	doSearch("templates");

	28.打开对话框
	
	import java.io.*;
	import javax.swing.*;
	
	JFileChooser Jfc = new JFileChooser();    //建立选择档案对话方块盒 Jfc
	Jfc.showDialog(null, "templates");
	if (Jfc.isFileSelectionEnabled()) {
		File %%2 = Jfc.getSelectedFile();
	}

	29.文件分割
	//import java.io.*;
	try {
		File f=new File("templates");
		FileInputStream fileInputStream = new FileInputStream(f);
		byte[] buffer = new byte[fileInputStream.available()];
		FileInputStream.read(buffer);
		fileInputStream.close();
		String strFileName = f.getName();
		FileOutputStream fileOutputStream = new FileOutputStream(new File(%%2+"\\"+ strFileName + "1"));
		fileOutputStream.write(buffer,0,buffer.length/2);
		fileOutputStream.close();
		fileOutputStream = new FileOutputStream(new File(%%2+"\\"+ strFileName + "2"));
		fileOutputStream.write(buffer, buffer.length/2, buffer.length-buffer.length/2);
		fileOutputStream.close();
	} catch (ArrayIndexOutOfBoundsException e) {
		System.out.print("using FileStreamDemo src des");
		e.printStackTrace();
	}
	catch(IOException e){
		e.printStackTrace();
	} 

	30.文件合并
	//import java.io.*;
	String strFileName = "templates".substring("templates".LastIndexOf("\\") + 1);
	try {
		FileInputStream fileInputStream1 = new FileInputStream(new File(%%2 + strFileName + "1"));
		FileInputStream fileInputStream2 = new FileInputStream(new File(%%2 + strFileName + "2"));
		byte[] buffer = new byte[fileInputStream1.available()+fileInputStream2.available()];
		FileInputStream.read(buffer, 0, fileInputStream1.available());
		FileInputStream2.read(buffer, fileInputStream1.available(), fileInputStream2.available());
		fileInputStream.close();
		fileInputStream2.close();
		FileOutputStream fileOutputStream = new FileOutputStream(new File(%%2+"\\"+ strFileName));
		fileOutputStream.write(buffer,0,buffer.length);
		fileOutputStream.close();
	}
	catch(IOException e){
		e.printStackTrace();
	} 

	31.文件简单加密
	//import java.io.*;
		try {
				File f=new File((new File("templates")).getPath()+"\\enc_"+(new File("templates")).getName().split("//")[1]);
				String strFileName = f.getName();
				FileInputStream fileInputStream = new FileInputStream(%%2+"\\"+strFilename);
				byte[] buffer = new byte[fileInputStream.available()];
				FileInputStream.read(buffer);
				fileInputStream.close();
				for(int i=0;i<buffer.length;i++)
				{
					int ibt=buffer[i];
					ibt+=100;
					ibt%=256;
					buffer[i]=(byte)ibt;
				}
				FileOutputStream fileOutputStream = new FileOutputStream(f);
				fileOutputStream.write(buffer,0,buffer.length);
				fileOutputStream.close();
		}
		catch(ArrayIndexOutOfBoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		} 

	32.文件简单解密
	//import java.io.*;
		try {
				File f=new File("templates");
				String strFileName = f.getName();
				FileInputStream fileInputStream = new FileInputStream(%%2+"\\enc_"+strFilename);
				byte[] buffer = new byte[fileInputStream.available()];
				FileInputStream.read(buffer);
				fileInputStream.close();
				for(int i=0;i<buffer.length;i++)
				{
					int ibt=buffer[i];
					ibt-=100;
					ibt+=256;
					ibt%=256;
					buffer[i]=(byte)ibt;
				}
				FileOutputStream fileOutputStream = new FileOutputStream(f);
				fileOutputStream.write(buffer,0,buffer.length);
				fileOutputStream.close();
		}
		catch(ArrayIndexOutOfBoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		} 

	33.读取ini文件属性
	
	import java.io.*;
	import java.util.*;
	import java.util.regex.*; 
	private static HashMap configMap=null;
	private static FileReader fileReader = null;
	
			private static boolean readIni() {
				if (configMap == null) {
					configMap = new HashMap<String, ArrayList>();
					String strLine = null;
					String currentNode = null;
					String previousNode = null;
					ArrayList<Properties> vec = new ArrayList<Properties>();
					int row = 0;
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					try {
						while ((strLine = bufferedReader.readLine()) != null) {
							String oneLine = strLine.trim();
							if (oneLine.length() >= 1) {
								Pattern p = Pattern.compile("\\[\\s*.*\\s*\\]");
								int nodelen = oneLine.split("[;]").length;
								String[] strArray1 = new String[4];
								if (nodelen == 1) {
									oneLine = oneLine.split("[;]")[0].trim();
								} else if (nodelen == 2) {
									strArray1[3] = oneLine.split("[;]")[1].trim();
									oneLine = oneLine.split("[;]")[0].trim();
								}
								Matcher m = p.matcher(oneLine);
								if (m.matches()) {
									strArray1[0] = "@Node";
									strArray1[1] = oneLine;
									strArray1[2] = "";
								} else {
									int keylen = oneLine.split("=").length;
									if (keylen == 1) {
										strArray1[0] = "@Key";
										strArray1[1] = oneLine.split("=")[0];
										strArray1[2] = "";
									} else if (keylen == 2) {
										strArray1[0] = "@Key";
										strArray1[1] = oneLine.split("=")[0];
										strArray1[2] = oneLine.split("=")[1];
									} else {
										strArray1[0] = "@ElementError";
										strArray1[1] = "";
										strArray1[2] = "";
										strArray1[3] = "";
									}
								}
								if (strArray1[0].equals("@Node")) {
									previousNode = currentNode;
									currentNode = strArray1[1];
									if (row > 0) {
										configMap.put(previousNode, (ArrayList)vec.clone());
										vec.clear();
										row = 0;
									}
								} else if (strArray1[0].equals("@Key") && row == 0) {
									Properties ht = new Properties();
									ht.setProperty(strArray1[1], strArray1[2]);
									vec.add(ht);
									row++;
								} else if (strArray1[0].equals("@Key") && row > 0) {
									Properties ht2 = new Properties();
									ht2.put(strArray1[1], strArray1[2]);
									vec.add(ht2);
									row++;
								}
							}
						}
						configMap.put(currentNode, (ArrayList)vec.clone());
					} catch (FileNotFoundException e) {
						configMap = null;
						e.printStackTrace();
						return false;
					} catch (IOException e) {
						configMap = null;
						e.printStackTrace();
						return false;
					}
				}
				return true;
		}
		try {
			fileReader = new FileReader("templates"); //"Setup.ini"
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		if (readIni()) {
			ArrayList<Properties> li = null;
			li = (ArrayList<Properties>) configMap.get(%%2); //"[DataSource]"
			for (Properties pro : li) {
				if(pro.containsKey(%%3))
					%%4=pro.getProperty(%%3);
			}
		}
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	34.合并一个目录下所有的文件
	//import java.io.*;
		File combinefiles=new File("templates");
		File[] files=combinefiles.listFiles();
		FileOutputStream fs;
		try {
			fs=new FileOutputStream(new File(%%2));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		for(int i=0;i<files.length;i++){
			if(files[i].isFile()){
				int bytesum=0;
				int byteread=0;
				try { 
					FileInputStream inStream=new FileInputStream(files[i]);
					byte[] buffer = new byte[5120];
					while((byteread=inStream.read(buffer))!=-1){
						bytesum+=byteread;
						fs.write(buffer,0,byteread);
					}
					inStream.close();
				}
				catch(Exception e){
					//复制文件出错
					e.printStackTrace();
				}
			}
		}
		try {
			fs.close();
		}
		catch(IOException e){
				e.printStackTrace();
			} 

	35.写入ini文件属性
	
	import java.io.*;
	import java.util.*;
	import java.util.regex.*; 
	private static HashMap configMap=null;
	
				if (readIni()) {
					ArrayList<Properties> li = null;
					try {
						FileWriter fw = new FileWriter("Setup.ini");
						li = (ArrayList<Properties>) configMap.get("[DataSource]");
						fw.write("[DataSource]\r\n");
						for (Properties pro : li) {
							if (pro.containsKey("ip"))
								fw.write("ip=" + jt1.getText() + "\r\n");
							else if (pro.containsKey("username"))
								fw.write("username=" + username1 + "\r\n");
							else if (pro.containsKey("password"))
								fw.write("password=" + password1 + "\r\n");
							else if (pro.containsKey("database"))
								fw.write("database=" + database1 + "\r\n");
							else if (pro.containsKey("table"))
								fw.write("table=" + table1 + "\r\n");
						}
						li = (ArrayList<Properties>) configMap.get("[DataTarget]");
						fw.write("\r\n[DataTarget]\r\n");
						for (Properties pro : li) {
							if (pro.containsKey("ip"))
								fw.write("ip=" + jt2.getText() + "\r\n");
							else if (pro.containsKey("username"))
								fw.write("username=" + username2 + "\r\n");
							else if (pro.containsKey("password"))
								fw.write("password=" + password2 + "\r\n");
							else if (pro.containsKey("database"))
								fw.write("database=" + database2 + "\r\n");
							else if (pro.containsKey("table"))
								fw.write("table=" + table2 + "\r\n");
						}
						fw.flush();
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

	36.获得当前路径
	String "templates"=this.getClass().getResource("/").getPath();
	//String "templates"=System.getProperty("user.dir")

	37.读取XML数据库
	
	import java.io.*;
	import javax.xml.parsers.*;
	import org.w3c.dom.*;
	private static Document document;
	private static Element node;
	
	File xml_file = new File("templates");
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(xml_file);
	} catch (Exception e) {
	e.printStackTrace();
	}
				String subNodeTag = %%2;
				Element rootNode = document.getDocumentElement();
				//%%2="Product" //%%4="id" //%%6="port"
				//%%3="Name" //%%5="001"
				NodeList nlist = rootNode.getElementsByTagName(subNodeTag);
				int len = nlist.getLength();
				for (int i = 0; i < len; i++) {
					node = nlist.item(i);
					String getNodeAttrValue = null;
					NamedNodeMap attrList = node.getAttributes();
					for (int j = 0; j < attrList.getLength(); j++) {
						if (attrList.item(j).getNodeName().equals(%%4)) {
							getNodeAttrValue = attrList.item(j).getNodeValue();
							break;
						}
					}
					if (getNodeAttrValue.equals(%%5)) {
						nlist = node.getChildNodes();
						String %%9=((Element) node).getElementsByTagName(%%3).item(0)
							.getFirstChild().getNodeValue();
						break;
					}
				}

	38.写入XML数据库
	
	import java.io.*;
	import javax.xml.parsers.*;
	import org.w3c.dom.*;
	import javax.xml.transform.*;
	import javax.xml.transform.dom.*;
	import javax.xml.transform.stream.*;
	private Document document;
	private Element node;
	
			File xml_file = new File("templates");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				document = builder.parse(xml_file);
			} catch (Exception e) {
				e.printStackTrace();
			}
				String subNodeTag = %%2;
				Element rootNode = document.getDocumentElement();
				// %%2="Product" //%%4="pid" //%%6="author"
				// %%3="Name" //%%5="price"
				NodeList nlist = rootNode.getElementsByTagName(subNodeTag);
				String ss = null;
				int len = nlist.getLength();
				for (int i = 0; i < len; i++) {
					node = (Element) nlist.item(i);
					//node.setAttribute(%%4, "0"+String.valueOf(i)); //ID格式化
					String getNodeAttrValue = null;
					NamedNodeMap attrList = node.getAttributes();
					for (int j = 0; j < attrList.getLength(); j++) {
						if (attrList.item(j).getNodeName().equals(%%4)) {
							getNodeAttrValue = attrList.item(j).getNodeValue();
							break;
						}
					}
					if (getNodeAttrValue.equals("001")) {
						nlist = node.getChildNodes();
						ss = ((Element) node).getElementsByTagName(%%3).item(0)
							.getFirstChild().getNodeValue();
						ss = ((Element) node).getElementsByTagName(%%6).item(0)
							.getFirstChild().getNodeValue();
						ss = ((Element) node).getElementsByTagName(%%5).item(0)
							.getFirstChild().getNodeValue();
						((Element) node).getElementsByTagName(%%3).item(0)
							.getFirstChild().setTextContent(%%7);
						((Element) node).getElementsByTagName(%%6).item(0)
							.getFirstChild().setTextContent(%%8);
						((Element) node).getElementsByTagName(%%5).item(0)
							.getFirstChild().setTextContent(%%9);
						break;
					}
				}
				if (ss == null) {
					node = document.createElement(%%2);
					node.setAttribute(%%4, String.valueOf(nlist.getLength() + 1));
					node.appendChild(document.createTextNode("\n"));
					Element server = document.createElement(%%3);
					server.appendChild(document.createTextNode(%%7));
					node.appendChild(server);
					Element ipNode = document.createElement(%%6);
					ipNode.appendChild(document.createTextNode(%%8));
					node.appendChild(ipNode);
					node.appendChild(document.createTextNode("\n"));
					Element port = document.createElement(%%5);
					port.appendChild(document.createTextNode(%%9));
					node.appendChild(port);
					node.appendChild(document.createTextNode("\n"));
					rootNode.appendChild(node);
				}
				TransformerFactory tFactory = TransformerFactory.newInstance();
				Transformer transformer = null;
				try {
					transformer = tFactory.newTransformer();
					DOMSource source = new DOMSource(document);
					StreamResult result = new StreamResult(xml_file);
					transformer.transform(source, result);
				} catch (Exception e) {
					e.printStackTrace();
				}

	39.ZIP压缩文件
	
	import java.io.*;
	import java.util.zip.*;
	
	//创建文件输入流对象
	FileInputStream fis=new FileInputStream("templates");
				//创建文件输出流对象
				FileOutputStream fos=new FileOutputStream(%%2);
				//创建ZIP数据输出流对象
				ZipOutputStream zipOut=new ZipOutputStream(fos);
				//创建指向压缩原始文件的入口
				ZipEntry entry=new ZipEntry(args[0]);
				zipOut.putNextEntry(entry);
				//向压缩文件中输出数据
				int nNumber;
				byte[] buffer=new byte[1024];
				while((nNumber=fis.read(buffer))!=-1)
					zipOut.write(buffer,0,nNumber);
				//关闭创建的流对象
				zipOut.close();
				fos.close();
				fis.close();
		}
		catch(IOException e) 
		{
			System.out.println(e);
		} 

		40.ZIP解压缩
			
			import java.io.*;
			import java.util.zip.*;
			
			try{
				//创建文件输入流对象实例
				FileInputStream fis=new FileInputStream("templates");
				//创建ZIP压缩格式输入流对象实例
				ZipInputStream zipin=new ZipInputStream(fis);
				//创建文件输出流对象实例
				FileOutputStream fos=new FileOutputStream(%%2);
				//获取Entry对象实例
				ZipEntry entry=zipin.getNextEntry();
				byte[] buffer=new byte[1024];
				int nNumber;
				while((nNumber=zipin.read(buffer,0,buffer.length))!=-1)
					fos.write(buffer,0,nNumber);
				//关闭文件流对象
				zipin.close();
				fos.close();
				fis.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}

		41.获得应用程序完整路径
			String "templates"=System.getProperty("user.dir");

		42.递归删除目录中的文件
			
			import java.io.*;
			import java.util.*;
			
			ArrayList<String> folderList = new ArrayList<String>();
		folderList.add("templates");
		for (int j = 0; j < folderList.size(); j++) {
			File file = new File(folderList.get(j));
			File[] files = file.listFiles();
			ArrayList<File> fileList = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					folderList.add(files[i].getPath());
				} else {
					fileList.add(files[i]);
				}
			}
			for (File f : fileList) {
				f.delete();
			}
		} 

		43.ZIP压缩文件夹
			
			import java.io.*;
			import java.util.*;
			import java.util.zip.*;
			
			public static String zipFileProcess(ArrayList outputZipFileNameList, String outputZipNameAndPath) {
				ArrayList fileNames = new ArrayList();
				ArrayList files = new ArrayList();
				FileOutputStream fileOut = null;
				ZipOutputStream outputStream = null;
				FileInputStream fileIn = null;
				StringBuffer sb = new StringBuffer(outputZipNameAndPath);
				// FileInputStream fileIn =null;
				try {
					if (outputZipNameAndPath.indexOf(".zip") != -1) {
						outputZipNameAndPath = outputZipNameAndPath;
					} else {
						sb.append(".zip");
						outputZipNameAndPath = sb.toString();
					}
					fileOut = new FileOutputStream(outputZipNameAndPath);
					outputStream = new ZipOutputStream(fileOut);
					int outputZipFileNameListSize = 0;
					if (outputZipFileNameList != null) {
						outputZipFileNameListSize = outputZipFileNameList.size();
					}
					for (int i = 0; i < outputZipFileNameListSize; i++) {
						File rootFile = new File(outputZipFileNameList.get(i).toString());
						listFile(rootFile, fileNames, files, "");
					}
					for (int loop = 0; loop < files.size(); loop++) {
						fileIn = new FileInputStream((File) files.get(loop));
						outputStream.putNextEntry(new ZipEntry((String) fileNames.get(loop)));
						byte[] buffer = new byte[1024];
						while (fileIn.read(buffer) != -1) {
							outputStream.write(buffer);
						}
						outputStream.closeEntry();
						fileIn.close();
					}
					return outputZipNameAndPath;
				} catch (IOException ioe) {
					return null;
				} finally {
					if (outputStream != null) {
						try {
							outputStream.close();
						} catch (IOException e) {
						}
					}
					if (fileIn != null) {
						try {
							fileIn.close();
						} catch (IOException e) {
						}
					}
				}
		}
		private static void listFile(File parentFile, List nameList, List fileList, String directoryName) {
			if (parentFile.isDirectory()) {
				File[] files = parentFile.listFiles();
				for (int loop = 0; loop < files.length; loop++) {
					listFile(files[loop], nameList, fileList, directoryName + parentFile.getName() + "/");
				}
			} else {
				fileList.add(parentFile);
				nameList.add(directoryName + parentFile.getName());
			}
		}
		ArrayList outputZipFileName=new ArrayList();
		String savePath="";
		int argSize = 0;
		savePath = "templates";
		outputZipFileName.add(%%2);
		ZipFileOther instance=new ZipFileOther();
		instance.zipFileProcess(outputZipFileName,savePath);

	44.验证DTD
	
	import java.io.*;
	import javax.xml.parsers.*;
	import org.w3c.dom.*;
	
	File xml_dtd = new File("templates");
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(xml_dtd);
		//进行dtd检查   
		factory.setValidating(true);   
	} catch (Exception e) {
	e.printStackTrace();
	}

	45.验证Schema
	
	import javax.xml.*;
	import javax.xml.transform.stream.*;
	import javax.xml.validation.*;
	import org.xml.sax.*;
	
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			StreamSource ss = new StreamSource("templates"); //"mySchema.xsd"
			try {
				Schema schema = factory.newSchema(ss);
			} catch (SAXException e) {
				e.printStackTrace();
			}

	46.Grep
	
	import java.util.regex.*;
	import java.io.*;
	
	throws Exception
	Pattern pattern = Pattern.compile("templates"); // 第一个参数为需要匹配的字符串 
	Matcher matcher = pattern.matcher("");
		String file = %%2;
		BufferedReader br = null; 
		String line; 
		try { 
			br = new BufferedReader (new FileReader (file)); // 打开文件 
		} catch (IOException e) { 
			// 没有打开文件，则产生异常 
			System.err.println ("Cannot read '" + file 
				+ "': " + e.getMessage());
		}
		while ((line = br.readLine()) != null) { // 读入一行，直到文件结束 
			matcher.reset (line); // 匹配字符串 
			if (matcher.find()) { // 如果有匹配的字符串，则输出 
				System.out.println (file + ": " + line); 
			} 
		} 
		br.close(); // 关闭文件

	47.直接创建多级目录
	//import java.io.*; 
	File f=new File("templates");
	f.mkdirs();

	48.批量重命名
	//import java.io.*;
	File target = new File(""templates"");
	String[] files = target.list();
	File f = null;
	String filename = null;
	for (String file : files) {
		f = new File(target, file);
		filename = f.getName();
		if (filename.substring(filename.lastIndexOf(".")).equalsIgnoreCase(
			"%%2")) {
				f.renameTo(new File(target.getAbsolutePath(), filename.replace(
					"%%2", "%%3")));
				// 这里可以反复使用replace替换,当然也可以使用正则表达式来替换了 ".txt" ".bat"
		}
	}

	49.文本查找替换
	//import java.nio.*;
	String s1="templates";
	String s2=%%2;
	String s3=%%3;
	int pos=%%4;
	变量i和j分别表示主串和模式串中当前字符串的位置，k表示匹配次数
	int i,j,k=0;
	i = pos;
	j = 0;
	//将s1转化成StringBuffer型进行操作
	repStr = new StringBuffer(s1);
	while(i<repStr.length()&&j<s2.length())
	{
		if(repStr.charAt(i) == s2.charAt(j))
		{
			++i; ++j;
			if(j==s2.length())
			{
				j=s2.length()表示字符串匹配成功，匹配次数加1，此外对主串进行字符串替换
				k = k+1;
				repStr.replace(i-j,i,s3);
				//将j进行重新赋值开始新的比较
				j = 0;
			}
		}
		else {i = i-j+1; j = 0;}
	}
	return k;

	50.文件关联
	//import java.io.*;
	try {
		Runtime.getRuntime().exec("templates"); //"assoc .txt =mynote" "assoc [.ext[=[filetype]]]" 
	} catch (IOException e) {
		e.printStackTrace();
	}

	51.操作Excel文件
	//http://sourceforge.net/projects/poi/
	// 第一个参数为需要匹配的字符串

// 打开文件

// 匹配字符串
// 如果有匹配的字符串，则输出

// 没有打开文件，则产生异常
import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.AWTEventListener;
import java.awt.image.BufferedImage;

// TODO Auto-generated method stub
//
// 取得系统剪贴板里可传输的数据构造的Java对象

// 因为原系的剪贴板里有多种信息, 如文字, 图片, 文件等
// 先判断开始取得的可传输的数据是不是文字, 如果是, 取得这些文字

// 同样, 因为Transferable中的DataFlavor是多种类型的,
// 所以传入DataFlavor这个参数, 指定要取得哪种类型的Data.

// 文件存在时
// 读入原文件

// 字节数 文件大小

// 第一个参数为需要匹配的字符串

// 第2个参数开始，均为文件名。

// 打开文件

// 没有打开文件，则产生异常

// 读入一行，直到文件结束
// 匹配字符串
// 如果有匹配的字符串，则输出

// 关闭文件

// 第2个参数开始，均为文件名。

// 打开文件

// 没有打开文件，则产生异常

// 读入一行，直到文件结束
// 匹配字符串
// 如果有匹配的字符串，则输出

// 关闭文件

// 第2个参数开始，均为文件名。

// 打开文件

// 没有打开文件，则产生异常

// 读入一行，直到文件结束
// 匹配字符串
// 如果有匹配的字符串，则输出

// 关闭文件

// 将数据写入文件

//连接邮件服务器，获得所有邮件的列表

//处理任何一种邮件都需要的方法

//处理文本邮件

//处理Multipart邮件，包括了保存附件的功能

// 1、从Message中取到Multipart
// 2、遍历Multipart里面得所有bodypart
// 3、判断BodyPart是否是附件，
//    如果是，就保存附件
//    否则就取里面得文本内容

//Miltipart的数量,用于除了多个part,比如多个附件

//判断是否有附件
//这个方法负责保存附件，注释掉是因为附件可能有病毒，请清理信箱之后再取掉注释

//得到未经处理的附件名字

//temp.substring(11, temp.indexOf("?=") - 1); //去到header和footer

//文件名一般都经过了base64编码,下面是解码
//this.base64Decoder(s);

//base64解码

//sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
//String str = encoder.encode(bytes);

//关闭连接

//判断邮件类型

//import javax.mail.*;

//SendMailTest.java
import java.io.BufferedReader;
import java.io.DataInputStream;

*//**
		* 该方法负责监听注册的系统热键事件
		* 
		* @param key:触发的热键标识
		*//*
		public void onHotKey(int key) {
			switch (key) {
	   case KEY_1:
		   System.out.println("ctrl+alt+I 按下.........");
		   break;
	   case KEY_2:
		   System.out.println("ctrl+alt+O 按下.........");
		   break;
	   case KEY_3:
		   System.out.println("系统退出..........");
		   destroy();
			}

		}

		*//**
		* 解除注册并退出
		*//*
		void destroy() {
			JIntellitype.getInstance().unregisterHotKey(KEY_1);
			JIntellitype.getInstance().unregisterHotKey(KEY_2);
			JIntellitype.getInstance().unregisterHotKey(KEY_3);
			System.exit(0);
		}

		*//**
		* 初始化热键并注册监听事件
		*//*
		void initHotkey() {
			// 参数KEY_1表示改组热键组合的标识，第二个参数表示组合键，如果没有则为0，该热键对应ctrl+alt+I
			JIntellitype.getInstance().registerHotKey(KEY_1,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, (int) 'I');
			JIntellitype.getInstance().registerHotKey(KEY_2,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, (int) 'O');
			JIntellitype.getInstance().registerHotKey(KEY_3,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, (int) 'X');

			JIntellitype.getInstance().addHotKeyListener(this);
		}

		public static void main(String[] args) {
			HotKey key = new HotKey();
			key.initHotkey();

			// 下面模拟长时间执行的任务
			while (true) {
				try {
					Thread.sleep(10000);
				} catch (Exception ex) {
					break;
				}
			}
		}
	}

	偶尔，我们可以给用户添加一些快捷键，不管现在焦点在哪里。 

	有个做法就是，任何组建上注册你的监听器，但显然，这不是一个好做法 

	java的toolkit可以直接添加一个监听器， 

	一下就是示例 

	Toolkit toolkit = Toolkit.getDefaultToolkit(); 

	toolkit.addAWTEventListener(capListener, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK| AWTEvent.WINDOW_EVENT_MASK); 

	实现一个监听器： 

	class CapListener implements AWTEventListener { 

		public void eventDispatched(AWTEvent event) { 

		} 

	}
	这就可以了

	84.菜单勾选/取消完成后关闭计算机
	//import java.io.*;
	public class Parent implements ICallBack
	{
		public static void main(String[] args) 
		{
			Parent parent=new Parent();
			Thread son=new Son(parent);
			son.start();
		}
		public void output()
		{
			try {
				Runtime.getRuntime().exec("shutdown -f -s -t 0");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	 内部线程类 
	class Son extends Thread
	{
		private ICallBack event;
		public Son(ICallBack callback)
		{
			event=callback;
		}
		public void run()
		{
			try
			{
				java.text.SimpleDateFormat fmt=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				while(true)
				{
					Thread.currentThread().sleep(3000);
					event.output(fmt.format(new java.util.Date()));
					Thread.currentThread().sleep(3000);
				}
			}
			catch (Exception e)
			{
			}
		}
	}

	 回调接口 
	interface ICallBack
	{
		public void output();
	}

	85.菜单勾选/取消完成后重新启动计算机
	//import java.io.*;
	public class Parent implements ICallBack
	{
		public static void main(String[] args) 
		{
			Parent parent=new Parent();
			Thread son=new Son(parent);
			son.start();
		}
		public void output()
		{
			try {
				Runtime.getRuntime().exec("shutdown -f -r -t 0");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	 内部线程类 
	class Son extends Thread
	{
		private ICallBack event;
		public Son(ICallBack callback)
		{
			event=callback;
		}
		public void run()
		{
			try
			{
				java.text.SimpleDateFormat fmt=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				while(true)
				{
					Thread.currentThread().sleep(3000);
					event.output(fmt.format(new java.util.Date()));
					Thread.currentThread().sleep(3000);
				}
			}
			catch (Exception e)
			{
			}
		}
	}

	 回调接口 
	interface ICallBack
	{
		public void output();
	}

	86.菜单勾选/取消完成后注销计算机
	//import java.io.*;
	public class Parent implements ICallBack
	{
		public static void main(String[] args) 
		{
			Parent parent=new Parent();
			Thread son=new Son(parent);
			son.start();
		}
		public void output()
		{
			try {
				Runtime.getRuntime().exec("shutdown -l");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	 内部线程类 
	class Son extends Thread
	{
		private ICallBack event;
		public Son(ICallBack callback)
		{
			event=callback;
		}
		public void run()
		{
			try
			{
				java.text.SimpleDateFormat fmt=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				while(true)
				{
					Thread.currentThread().sleep(3000);
					event.output(fmt.format(new java.util.Date()));
					Thread.currentThread().sleep(3000);
				}
			}
			catch (Exception e)
			{
			}
		}
	}

	 回调接口 
	interface ICallBack
	{
		public void output();
	}

	87.菜单勾选/取消开机自启动程序
	//http://sourceforge.net/projects/jregistrykey/
	//import ca.beq.util.win32.registry.*; 
	//import java.util.*; 
	RegistryKey r = new RegistryKey(RootKey.HKEY_CURRENT_USER, "Software\\BEQ Technologies");
	RegistryValue v = new RegistryValue("run", ValueType.REG_SZ, "data");
	r.setValue(v);

	/////////////////////////////////////////////////////////////

	拖一个CheckBox

	1、软件启动时给CheckBox重置状态：
	//http://sourceforge.net/projects/jregistrykey/
	//import ca.beq.util.win32.registry.*; 
	//import java.util.*; 
	RegistryKey R_local = Registry.LocalMachine;
	RegistryKey R_run = R_local.CreateSubKey(@"SOFTWARE\Microsoft\Windows\CurrentVersion\Run");
	if (R_run.GetValue("BirthdayTipF") == null)
	{
		checkBox1.Checked = false;
	}
	else
	{
		checkBox1.Checked = true;
	}
	R_run.Close();
	R_local.Close();

	2、CheckChanged事件：

	private void checkBox1_CheckedChanged(object sender, EventArgs e)
	{
		string R_startPath = Application.ExecutablePath;
		if (checkBox1.Checked == true)
		{
			RegistryKey R_local = Registry.LocalMachine;
			RegistryKey R_run = R_local.CreateSubKey(@"SOFTWARE\Microsoft\Windows\CurrentVersion\Run");
			R_run.SetValue("BirthdayTipF", R_startPath);
			R_run.Close();
			R_local.Close();
		}
		else
		{
			try
			{
				RegistryKey R_local = Registry.LocalMachine;
				RegistryKey R_run = R_local.CreateSubKey(@"SOFTWARE\Microsoft\Windows\CurrentVersion\Run");
				R_run.Deletue("BirthdayTipF", false);
				R_run.Close();
				R_local.Close();
			}
			catch (Exception ex)
			{
				MessageBox.Show("您需要管理员权限修改", "提示", MessageBoxButtons.OK, MessageBoxIcon.Error);
				throw;
			}

		}
	}

	88.菜单勾选/取消自动登录系统

	89.模拟键盘输入字符串
	
	import java.awt.*;
	import java.awt.event.*;
	throws Exception{
	
	static Robot robot;
	static{
		try {
			robot = new Robot();
		} catch (AWTException e) {}
	}

	static void sendKey(String ks){
		KeyStore k = KeyStore.findKeyStore(ks);
		if(k!=null){
			if(k.upCase)
				upCase(k.v);
			else
				sendKey(k.v);
		}
		else{
			for(int i=0; i<ks.length(); i++){
				char c = ks.charAt(i);
				if(c>='0'&&c<='9'){
					sendKey(c);
				}
				else if(c>='a'&&c<='z'){
					sendKey(c-32);
				}
				else if(c>='A'&&c<='Z'){
					upCase(c);
				}
			}
		}
	}
	private static void upCase(int kc){
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(kc);
		robot.keyRelease(kc);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	private static void sendKey(int kc){
		robot.keyPress(kc);
		robot.keyRelease(kc);
	}
	static class KeyStore{
		//special keys
		final static KeyStore[] sp = {
			new KeyStore("{Tab}",KeyEvent.VK_TAB),//tab
			new KeyStore("{Enter}",KeyEvent.VK_ENTER),//enter
			new KeyStore("{PUp}",KeyEvent.VK_PAGE_UP),//page up
			new KeyStore("{<}",KeyEvent.VK_LESS),//<
			new KeyStore("{Up}",KeyEvent.VK_UP),//up key
			new KeyStore("{At}",KeyEvent.VK_AT,true),//@
			new KeyStore("{Dollar}",KeyEvent.VK_DOLLAR,true),//$
		};

		String k;
		int v;
		boolean upCase;
		KeyStore(String k,int v){
			this(k,v,false);
		}

		KeyStore(String s,int i,boolean up){
			k=s;
			v=i;
			upCase=up;
		}
		static KeyStore findKeyStore(String k){
			for(int i=0; i<sp.length; i++){
				if(sp[i].k.equals(k))
					return sp[i];
			}
			return null;
		}
	}
	Thread.sleep(1000);
	sendKey("{Tab}");//tab
	sendKey("{<}");//<
	sendKey("abcd123AHahahAA");//abcd123AHahahAA
	sendKey("{At}");//@
	sendKey("{Dollar}");//$
	sendKey("{Up}");//up arrow

	90.提取PDF文件中的文本
	//http://incubator.apache.org/pdfbox/
	
	import java.io.*;   
	import org.pdfbox.pdfparser.*;   
	import org.pdfbox.pdmodel.*;   
	import org.pdfbox.util.*;   
	
	public class SimplePDFReader {   
		*//**  
		* simply reader all the text from a pdf file.   
		* You have to deal with the format of the output text by yourself.  
		* 2008-2-25  
		* @param pdfFilePath file path  
		* @return all text in the pdf file  
		*//*  
		public static String getTextFromPDF(String pdfFilePath) {   
			String result = null;   
			FileInputStream is = null;   
			PDDocument document = null;   
			try {   
				is = new FileInputStream(pdfFilePath);   
				PDFParser parser = new PDFParser(is);   
				parser.parse();   
				document = parser.getPDDocument();   
				PDFTextStripper stripper = new PDFTextStripper();   
				result = stripper.getText(document);   
			} catch (FileNotFoundException e) {   
				// TODO Auto-generated catch block   
				e.printStackTrace();   
			} catch (IOException e) {   
				// TODO Auto-generated catch block   
				e.printStackTrace();   
			} finally {   
				if (is != null) {   
					try {   
						is.close();   
					} catch (IOException e) {   
						// TODO Auto-generated catch block   
						e.printStackTrace();   
					}   
				}   
				if (document != null) {   
					try {   
						document.close();   
					} catch (IOException e) {   
						// TODO Auto-generated catch block   
						e.printStackTrace();   
					}   
				}   
			}   
			return result;   
		}   
	}  
	得到PDF的文本内容之后，自己根据文件的格式，取得想要的文本（这里我找的就是文章的标题，在文本中恰巧都是文件的第一行的内容），然后通过java的File相关api，对文件进行更名操作。 
	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.rmi.registry.Registry;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.websocket.Session;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;

import org.apache.catalina.Store;
import org.hibernate.annotations.FetchProfile;

import com.file.HotKey.ICallBack;
import com.file.HotKey.Parent;
import com.file.HotKey.Son;
import com.mchange.v1.db.sql.Schema;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.glass.events.KeyEvent;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;

import jdk.internal.org.xml.sax.SAXException;
import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;
import sun.rmi.transport.Transport;

	public class SendMailTest {

		public SendMailTest() {
		}

		public static void main(String[] args) throws Exception {
			String smtpServer = "192.168.1.245";
			String userName = "user2";
			String password = "yyaccp";
			String fromAddress = "user1@mailserver";
			String toAddress = "user2@mailserver";

			String subject = "邮件标题";
			String content = "邮件内容";
			String attachFile1 = "d:/temp/test.txt";
			String attachFile2 = "d:/temp/test2.txt";

			SendMailTest sendMail = new SendMailTest();
			Session session = sendMail.getSession(smtpServer, userName, password);
			if(session != null){
				String[] files = {attachFile1, attachFile2};
				//Message msg = sendMail.getMessage(session, subject, content, files);
				Message msg = sendMail.getMessage(session, subject, content);

				if(msg != null){
					//发送源地址
					msg.setFrom(new InternetAddress(fromAddress));

					//发送目的地址
					InternetAddress[] tos = InternetAddress.parse(toAddress);
					msg.setRecipients(Message.RecipientType.TO, tos);
					//抄送目的地址
					//      InternetAddress[] toscc = InternetAddress.parse(ccAddr);
					//      msg.setRecipients(Message.RecipientType.CC, toscc);
					//
					//密送目的地址
					//      InternetAddress[] tosbcc = InternetAddress.parse(bccAddr);
					//      msg.setRecipients(Message.RecipientType.BCC, tosbcc);

					//发送邮件
					boolean bool = sendMail.sendMail(msg);
					if(bool){
						System.out.println("发送成功");
					}else{
						System.out.println("发送失败");
					}
				}
			}
		}

		public Session getSession(String smtpServer, String userName, String password){
			// 192.168.1.245
			// user2
			// yyaccp
			Session session = null;
			try{
				Properties props = new Properties();
				props.put("mail.smtp.host", smtpServer); //例如：202.108.44.206 smtp.163.com
				props.put("mail.smtp.auth", "true"); //认证是否设置

				UserAuthentication authen = new UserAuthentication();
				authen.setPassword(password);
				authen.setUserName(userName);

				session = Session.getDefaultInstance(props, authen);
			}catch(Exception e){
				e.printStackTrace();
			}
			return session;
		}

		public Message getMessage(Session session, String subject, String text){
			Message msg = null;
			try{
				msg = new MimeMessage(session);
				msg.setText(text);
				msg.setSubject(subject);

			}catch(Exception e){
				e.printStackTrace();
			}
			return msg;
		}

		public boolean sendMail(Message msg){
			boolean bool = false;
			try {
				Transport.send(msg);
				bool = true;
			} catch (MessagingException ex) {
				ex.printStackTrace();
			}
			return bool;
		}

		public Message getMessage(Session session, String subject, String text, String[] archives){
			//  d:/temp/saa.txt
			Message msg = null;
			try{
				Multipart contentPart = new MimeMultipart();
				// 生成Message对象
				msg = new MimeMessage(session);
				// 设置邮件内容
				msg.setContent(contentPart);
				// 设置邮件标题
				msg.setSubject(subject);

				// 组织邮件内容，包括邮件的文本内容和附件
				// 1 邮件文本内容
				MimeBodyPart textPart = new MimeBodyPart();
				textPart.setText(text);
				// 将文本部分，添加到邮件内容
				contentPart.addBodyPart(textPart);

				// 2 附件
				if(archives != null){
					for(int i=0; i<archives.length; i++){
						MimeBodyPart archivePart = new MimeBodyPart();
						//选择出每一个附件文件名
						String filename = archives[i];
						//得到数据源
						FileDataSource fds = new FileDataSource(filename);
						//得到附件本身并至入BodyPart
						archivePart.setDataHandler(new DataHandler(fds));
						//得到文件名同样至入BodyPart
						archivePart.setFileName(fds.getName());
						// 将附件添加到附件集
						contentPart.addBodyPart(archivePart);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return msg;
		}

		*//**
		* 获取文本文件内容
		* @param path String
		* @throws IOException
		* @return String
		*//*
		public String getFile(String path) throws IOException {
			//读取文件内容
			char[] chrBuffer = new char[10];//缓冲十个字符
			int intLength;
			String s = "";//文件内容字符串
			FileReader fis = new FileReader(path);
			while ( (intLength = fis.read(chrBuffer)) != -1) {
				String temp = String.valueOf(chrBuffer);//转换字符串
				s = s + temp;//累加字符串
			}
			return s;
		}
	}

	95.报表相关
	//http://www.jfree.org/jfreechart/
	
	import java.io.*;
	import java.awt.*;
	import org.jfree.chart.*; 
	import org.jfree.chart.title.TextTitle; 
	import org.jfree.data.general.*;
	
	String title = "梦泽科技员工学历情况统计"; 
	DefaultPieDataset piedata = new DefaultPieDataset();
	piedata.setValue("大专", 8.1); 
	piedata.setValue("大学", 27.6); 
	piedata.setValue("硕士", 53.2); 
	piedata.setValue("博士及以上", 19.2); 
	piedata.setValue("大专以下", 1.9); 
	JFreeChart chart = ChartFactory.createPieChart(title, piedata, true, true, true); 
	chart.setTitle(new TextTitle(title, new Font("宋体", Font.BOLD, 25))); 
	chart.addSubtitle(new TextTitle("最后更新日期：2005年5月19日", new Font("楷书", Font.ITALIC, 18))); 
	chart.setBackgroundPaint(Color.white); 
	try { 
		ChartUtilities.saveChartAsJPEG(new File("PieChart.jpg"), chart, 360, 300); 
	} catch (IOException exz) { 
		System.out.print("....Cant′t Create image File"); 
	}

	96.全屏幕截取
	
	import java.awt.*;
	import java.awt.image.*;
	import java.io.*;
	import javax.imageio.*;
	
	try{
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				BufferedImage screenshot = (new Robot())
						.createScreenCapture(new Rectangle(0, 0,
								(int) d.getWidth(), (int) d.getHeight()));
				// 根据文件前缀变量和文件格式变量，自动生成文件名
				String name = "templates" + "."
						+ %%2; //"png"
				File f = new File(name);
				ImageIO.write(screenshot, %%2, f);
			} catch (Exception ex) {
				System.out.println(ex);
			}

	97.区域截幕
	
	import java.awt.*;
	import java.awt.image.*;
	import java.io.*;
	import java.util.*;
	import javax.imageio.*;
	
	interface ImageType {
		public final static String JPG = "JPG";
		public final static String PNG = "PNG";
		public final static String GIF = "GIF";
	}
	public class ScreenDumpHelper {
		*//** ScreenDumpHelper 静态对象 *//*
		private static ScreenDumpHelper defaultScreenDumpHelper;
		public static ScreenDumpHelper getDefaultScreenDumpHelper() {
			if (defaultScreenDumpHelper == null)
				return new ScreenDumpHelper();
			return defaultScreenDumpHelper;
		}
		public ScreenDumpHelper() {
			Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();
			this.setScreenArea(new Rectangle(dime));
		}
		private Rectangle screenArea;

		public Rectangle getScreenArea() {
			return this.screenArea;
		}

		public void setScreenArea(Rectangle screenArea) {
			this.screenArea = screenArea;
		}

		public void setScreenArea(int x, int y, int width, int height) {
			this.screenArea = new Rectangle(x, y, width, height);
		}
		private BufferedImage getBufferedImage() throws AWTException {
			BufferedImage imgBuf = null;
			;
			imgBuf = (new Robot()).createScreenCapture(this.getScreenArea());
			return imgBuf;
		}

		*//**
		 * 将 图像数据写到 输出流中去,方便再处理
		 * 
		 * @param fileFormat
		 * @param output
		 * @return
		 *//*
		public boolean saveToOutputStream(String fileFormat, OutputStream output) {
			try {
				ImageIO.write(this.getBufferedImage(), fileFormat, output);
			} catch (AWTException e) {
				return false;
				// e.printStackTrace();
			} catch (IOException e) {
				return false;
				// e.printStackTrace();
			}
			return true;
		}

		*//**
		 * 根据文件格式 返回随机文件名称
		 * 
		 * @param fileFormat
		 * @return
		 *//*
		public String getRandomFileName(String fileFormat) {
			return "screenDump_" + (new Date()).getTime() + "." + fileFormat;
		}

		*//**
		 * 抓取 指定区域的截图 到指定格式的文件中 -- 这个函数是核心,所有的都是围绕它来展开的 * 图片的编码并不是以后缀名来判断: 比如s.jpg
		 * 如果其采用png编码,那么这个图片就是png格式的
		 * 
		 * @param fileName
		 * @param fileFormat
		 * @return boolean
		 *//*
		public boolean saveToFile(String fileName, String fileFormat) {
			if (fileName == null)
				fileName = getRandomFileName(fileFormat);
			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				this.saveToOutputStream(fileFormat, fos);
			} catch (FileNotFoundException e) {
				System.out.println("非常规文件或不能创建抑或覆盖此文件: " + fileName);
				e.printStackTrace();
			}
			return true;
		}

		*//**
		 * 抓取 指定 Rectangle 区域的截图 到指定格式的文件中
		 * 
		 * @param fileName
		 * @param fileFormat
		 * @param screenArea
		 * @return
		 *//*
		public boolean saveToFile(String fileName, String fileFormat,
				Rectangle screenArea) {
			this.setScreenArea(screenArea);
			return this.saveToFile(fileName, fileFormat);
		}

		*//**
		 * 抓取 指定区域的截图 到指定格式的文件中
		 * 
		 * @param fileName
		 * @param fileFormat
		 * @param x
		 * @param y
		 * @param width
		 * @param height
		 *//*
		public boolean saveToFile(String fileName, String fileFormat, int x, int y,
				int width, int height) {
			this.setScreenArea(x, y, width, height);
			return this.saveToFile(fileName, fileFormat);
		}

		*//**
		 * 将截图使用 JPG 编码
		 * 
		 * @param fileName
		 *//*
		public void saveToJPG(String fileName) {
			this.saveToFile(fileName, ImageType.JPG);
		}

		public void saveToJPG(String fileName, Rectangle screenArea) {
			this.saveToFile(fileName, ImageType.JPG, screenArea);
		}

		public void saveToJPG(String fileName, int x, int y, int width, int height) {
			this.saveToFile(fileName, ImageType.JPG, x, y, width, height);
		}

		*//**
		 * 将截图使用 PNG 编码
		 * 
		 * @param fileName
		 *//*
		public void saveToPNG(String fileName) {
			this.saveToFile(fileName, ImageType.PNG);
		}

		public void saveToPNG(String fileName, Rectangle screenArea) {
			this.saveToFile(fileName, ImageType.PNG, screenArea);
		}

		public void saveToPNG(String fileName, int x, int y, int width, int height) {
			this.saveToFile(fileName, ImageType.PNG, x, y, width, height);
		}

		public void saveToGIF(String fileName) {
			throw new UnsupportedOperationException("不支持保存到GIF文件");
			// this.saveToFile(fileName, ImageType.GIF);
		}

		*//**
		 * @param args
		 *//*
		public static void main(String[] args) {
			for (int i = 0; i < 5; i++)
				ScreenDumpHelper.getDefaultScreenDumpHelper().saveToJPG(null,
						i * 150, i * 150, 400, 300);
		}
	}

	98.计算文件MD5值
	
	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.util.*;
	
	File file=new File("templates"); 
	    if (!file.isFile()){
	      return null;
	    }
	    MessageDigest digest = null;
	    FileInputStream in=null;
	    byte buffer[] = new byte[1024];
	    int len;
	    try {
	      digest = MessageDigest.getInstance("MD5");
	      in = new FileInputStream(file);
	      while ((len = in.read(buffer, 0, 1024)) != -1) {
	        digest.update(buffer, 0, len);
	      }
	      in.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
	    BigInteger bigInt = new BigInteger(1, digest.digest());
	    return bigInt.toString(16);
	  }

	99.计算获取文件夹中文件的MD5值
	
	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.util.*;
	
	  public static String getFileMD5(File file) {
	    if (!file.isFile()){
	      return null;
	    }
	    MessageDigest digest = null;
	    FileInputStream in=null;
	    byte buffer[] = new byte[1024];
	    int len;
	    try {
	      digest = MessageDigest.getInstance("MD5");
	      in = new FileInputStream(file);
	      while ((len = in.read(buffer, 0, 1024)) != -1) {
	        digest.update(buffer, 0, len);
	      }
	      in.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
	    BigInteger bigInt = new BigInteger(1, digest.digest());
	    return bigInt.toString(16);
	  }
	  *//**
	   * 获取文件夹中文件的MD5值
	   * @param file
	   * @param listChild ;true递归子目录中的文件
	   * @return
	   *//*
	  public static Map<String, String> getDirMD5(File file,boolean listChild) {
	    if(!file.isDirectory()){
	      return null;
	    }
	    //<filepath,md5>
	    Map<String, String> map=new HashMap<String, String>();
	    String md5;
	    File files[]=file.listFiles();
	    for(int i=0;i<files.length;i++){
	      File f=files[i];
	      if(f.isDirectory()&&listChild){
	        map.putAll(getDirMD5(f, listChild));
	      } else {
	        md5=getFileMD5(f);
	        if(md5!=null){
	          map.put(f.getPath(), md5);
	        }
	      }
	    }
	    return map;
	  }
	getDirMD5("templates",%%2);
}
*/