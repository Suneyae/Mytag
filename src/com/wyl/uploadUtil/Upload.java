package com.wyl.uploadUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 转自：http://xiaotao-2010.iteye.com/blog/1059818
 * @author Wei
 *
 */
public class Upload extends ActionSupport {
	private File fileTest; // 接收这个上传的文件
	private String fileTestFileName; // Struts2提供的格式，在文件名后+FileName就是上传文件的名字

	public File getFileTest() {
		return fileTest;
	}

	public void setFileTest(File fileTest) {
		this.fileTest = fileTest;
	}

	public String getFileTestFileName() {
		return fileTestFileName;
	}

	public void setFileTestFileName(String fileTestFileName) {
		this.fileTestFileName = fileTestFileName;
	}

	@Override
	public String execute() throws Exception {
		String[] str = { ".jpg", ".jpeg", ".bmp", ".gif" };
		// 限定文件大小是4MB
		if (fileTest == null || fileTest.length() > 4194304) {
			return "imageError";
		}
		for (String s : str) {
			if (fileTestFileName.endsWith(s)) {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/images");// 实际路径
				File saveFile = new File(new File(realPath), fileTestFileName); // 在该实际路径下实例化一个文件
				// 判断父目录是否存在
				if (!saveFile.getParentFile().exists()) {
					saveFile.getParentFile().mkdirs();
				}
				try {
					// 执行文件上传
					// FileUtils 类名 org.apache.commons.io.FileUtils;
					// 是commons-io包中的，commons-fileupload 必须依赖
					// commons-io包实现文件上次，实际上就是将一个文件转换成流文件进行读写
					FileUtils.copyFile(fileTest, saveFile);

				} catch (IOException e) {
					return "imageError";
				}
			}
		}
		return "imageSuccess";
	}

}