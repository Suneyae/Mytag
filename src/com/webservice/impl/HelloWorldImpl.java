package com.webservice.impl;

import javax.jws.WebService;

import com.webservice.HelloWorld;

@WebService
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String say(String str) {
		// TODO Auto-generated method stub
		return "I am the server,Hello:" + str;
	}

	@Override
	public void sayHi(String str) {
		// TODO Auto-generated method stub
		System.out.println("Hi," + str);
	}

}
