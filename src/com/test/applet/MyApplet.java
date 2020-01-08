package com.test.applet;

import java.applet.Applet;
import java.awt.Graphics;

public class MyApplet extends Applet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void paint(Graphics g) {
		 g.drawString ("Hello World", 25, 50);
	}
}
