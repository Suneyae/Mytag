package com.log.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 上传文件用
 * 
 * @author Wei
 * @time 2016年9月20日 下午10:04:16
 */
public class MyUpload extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7135365951488650730L;
	private String userName;
	/**
	 * 1 文件域的name属性
	 */
	private File baobiao;

	private String baobiaoFileName;

	private String baobiaoContentType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public File getBaobiao() {
		return baobiao;
	}

	public void setBaobiao(File baobiao) {
		this.baobiao = baobiao;
	}

	public String getBaobiaoFileName() {
		return baobiaoFileName;
	}

	public void setBaobiaoFileName(String baobiaoFileName) {
		this.baobiaoFileName = baobiaoFileName;
	}

	public String getBaobiaoContentType() {
		return baobiaoContentType;
	}

	public void setBaobiaoContentType(String baobiaoContentType) {
		this.baobiaoContentType = baobiaoContentType;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("MyUpload.java:"+baobiaoFileName);
		//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(baobiao);  
          
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext()  
                .getRealPath("/upload");  
          
        // 设置目标文件  
//        File toFile = new File(uploadPath, this.getBaobiaoFileName());  这个路径可能会出现找不到路径的报错
        File toFile = new File("C:\\Users\\Wei\\Desktop\\", this.getBaobiaoFileName()); 
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile);  
  
        //设置缓存  
        byte[] buffer = new byte[1024];  
  
        int length = 0;  
  
        //读取myFile文件输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        System.out.println("上传用户"+userName);  
        System.out.println("上传文件名"+baobiaoFileName);  
        System.out.println("上传文件类型"+baobiaoContentType);  
        //关闭输入流  
        is.close();  
          
        //关闭输出流  
        os.close();  
		
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		System.out.println("this.userName:" + userName);
		
		return SUCCESS;

	}
		

}
