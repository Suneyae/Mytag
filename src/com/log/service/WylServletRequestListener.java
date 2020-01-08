package com.log.service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.util.UtilPrint;

public class WylServletRequestListener implements ServletRequestListener {
	
	public WylServletRequestListener() {
		System.out.println("com.log.service.WylServletRequestListener()实例化,");

	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		UtilPrint.printWithSeparatorAndClass(
				"com.log.service.WylServletRequestListener.requestDestroyed(ServletRequestEvent sre),",
				WylServletRequestListener.class);

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("com.log.service.WylServletRequestListener.requestInitialized(ServletRequestEvent sre),");

		ServletRequest req = sre.getServletRequest();
		String charencoding = req.getCharacterEncoding();
		String serverName = req.getServerName();
		UtilPrint.printWithSeparatorAndClass("-----serverName:" + serverName + ",charencoding:" + charencoding,
				WylServletRequestListener.class);

	}

}
