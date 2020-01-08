package com.test.javaAPI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 根据路径获取图片，例子： ImageUtil.getImageByPath("com/test/javaAPI/ydd.jpg");
 * 路径必须为src下的包名，格式如例子中的
 * 
 * @author Wei
 * @time 2016年9月17日 下午12:41:36
 */
public class ImageUtil {
	/**
	 * 把构造器私有了，防止外部实例化
	 */
	private ImageUtil() {

	}

	/**
	 * 根据路径获取图片，例子： ImageUtil.getImageByPath("com/test/javaAPI/ydd.jpg");
	 * 路径必须为src下的包名，格式如例子中的
	 * 
	 * @author Wei
	 * @time 2016年9月17日 下午12:41:36
	 */
	public static Image getImageByPath(String path) {
		URL url = ImageUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public static void main(String[] args) {
		URL url = ImageUtil.class.getClassLoader().getResource("com/test/javaAPI/ydd.jpg");
		System.out.println(url);
	}
}
