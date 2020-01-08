package com.test.javaAPI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest extends Frame {
	private final static String imgYdd = "com/test/javaAPI/ydd.jpg";
	private final static String imgBook = "com/test/javaAPI/book.png";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameTest() {
	}
	/**
	 * 启动一个窗口
	 */
	public void launchFrame() {
		setLocation(100, 100);
		setSize(500, 500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
//				super.windowClosing(e);
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.orange);
		g.drawLine(100, 100, 300, 300);
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100, 100, 300, 200);
		Font f = new Font("宋体", Font.BOLD, 40);
//		g.setFont(new Font("宋体", ImageObserver.HEIGHT, Frame.MAXIMIZED_VERT));
		g.setFont(f);
		g.drawString("卫永乐", 200, 200);
		g.drawImage(ImageUtil.getImageByPath(imgBook), 155, 80, null);
		g.setColor(color);
	}

	public static void main(String[] args) {
		FrameTest frame = new FrameTest();
		frame.launchFrame();
	}

}
