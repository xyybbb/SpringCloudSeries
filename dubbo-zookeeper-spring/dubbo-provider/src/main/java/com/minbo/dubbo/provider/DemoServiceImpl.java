package com.minbo.dubbo.provider;

public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		System.out.println("Welcome to Use Dubbo 1111(Provider1), Hello " + name);
		return "Welcome to Use Dubbo 1111(Provider1), Hello " + name;
	}

	public String sayHello2(String name) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Use Dubbo 2222(Provider1), Hello " + name);
		return "Welcome to Use Dubbo 2222(Provider1), Hello " + name;
	}

}
