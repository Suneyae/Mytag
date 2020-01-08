package com.test.javaAPI.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * io相关的操作
 * @author Wei
 * @time  2016年10月8日 下午4:27:43
 */
public class IOTest {
	static String filepath =    "C:\\Users\\Wei\\Desktop\\ydd.log";
	static String newFilePath = "‪D:/weiyongle/ydd";
	@SuppressWarnings("all")
	public static void main(String[] args) throws IOException {
		/*String filepath = "C:\\Users\\Wei\\Desktop\\testio.log";
		filepath = "C:\\Users\\Wei\\Desktop\\abc.xml";
//		filepath = "C:\\Users\\Wei\\Desktop\\error.log";
		FileReader reader = new FileReader(filepath);
		byte[] b = new byte[1024];
		char[] c = new char[1024];
		StringBuffer sbf = new StringBuffer();
		while(reader.read(c, 0, c.length)!=-1){
			sbf.append(c);
		}
		System.out.println(sbf.toString());
		System.out.println("---------分割线:"+sbf.length());*/
		
//		testxxx();
		
//		read3();
//		read2();
//		read0();
//		read1();
		write();
		
	}
	
	@SuppressWarnings({ "all" })
	public static void testFile(){
		FileInputStream fis = null;
		byte[] bytes = null;
		try {
			fis = new FileInputStream(new File("C:\\Users\\Wei\\Desktop\\testio.log"));
			bytes = new byte[1024];
			fis.read(bytes);
			System.out.println("fis:"+fis.toString());
			FileInputStream fildps = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * System.in是InputStream static final的，包含了多态,叫同步式或者阻塞式
	 * 读取ASCII和二进制文件(图片)，而字母就是ASCII字符(个人理解)。
	 */
	public static void testxxx(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);//有readline
		String s = null;
		try {
			s = br.readLine();
			while(s!=null) {
				if(s.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println(s.toUpperCase());
				s = br.readLine();
			}
			br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 字符流测试，
	 * 就是那些以Stream结尾的都是字节流
	 */
	public void bytesStreamTest(){
		InputStream ips = null;
		BufferedInputStream bfips = new BufferedInputStream(ips);
		FilterInputStream ftips = null;
	}
	
	
	/**
	 * 字节输入流的读取方式三：每次读取指定大小的字节,
	 * 这种方法不好，因为指定的byte的长度不一定，导致
	 * 每次读取的内容可能不能完全读完
	 */
	@SuppressWarnings("all")
	public static void read3(){
		File f =new File(filepath);
		InputStream ips = null;
		StringBuffer sbf = new StringBuffer();
		try {
			ips = new FileInputStream(f);
			
			byte[] bytes = new byte[1];
			int len = -1;
			while((len=ips.read(bytes,0,bytes.length))!=-1){
				sbf.append(new String(bytes));
			};
			
			ips.close();
			System.out.println(sbf.toString());
			System.out.println("-------------分割线--------------");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 字节输入流的读取方式0：一次性读取N个字节
	 */
	public static void read0(){
		try {
			FileInputStream fips = new FileInputStream(new File(filepath));
			byte[] b = new byte[(int) new File(filepath).length()];
			StringBuffer sb = new StringBuffer();
			fips.read(b,0,b.length);
			sb.append(new String(b));
			System.out.println("我是read0()方法，\n"+sb.toString());
			//关闭流
			fips.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	  /**
     * 字节输入流的读取方式一：每次读取一个字节
     * 一个字节一个字节地读取，有中文的话会出现乱码
     */
    public static void read1(){
        
        try {
            //构造一个字节输入流对象
            InputStream in = new FileInputStream(filepath);
            int len = -1;//定义一个字节，－1表示没有数据
            while((len=in.read())!=-1){
                System.out.print((char)len);
            }
            //关闭
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	 /**
     * 字节输入流的读取方式二：一次性读取所有字节
     */    
    public static void read2(){
        try {
            File f = new File(filepath);
            //构造一个字节输入流对象
            InputStream in = new FileInputStream(f);
            //根据文件的大小构造字节数组
            byte[] bytes = new byte[(int)f.length()];
            int len = in.read(bytes);
            System.out.println(new String(bytes));
            System.out.println("len="+len);
            //关闭
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
	/**
	 * 字符流测试,
	 * 实际上就是那些Reader以及Writer是字符流
	 */
	public void characterStreamTest(){
		
	}
	
	
	/**
	 * 输出流测试
	 */
	public static void write(){
		
		
		try {
			File tmp = new File("D:\\weiyongle");
			if(!tmp.exists()){
//				tmp.createNewFile();
				tmp.mkdir();
			}
			
			for(int i=0;i<100;i++){
				String path = newFilePath+i+".txt";
				File file = new File(path);
				if(!file.exists()){
					file.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(file);
				String msg = "xxxxxxxxxx"+i*i;
				byte[] b = msg.getBytes();
				fos.write(b, 0, b.length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
