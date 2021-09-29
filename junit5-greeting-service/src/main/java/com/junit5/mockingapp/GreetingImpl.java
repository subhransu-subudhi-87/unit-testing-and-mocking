package com.junit5.mockingapp;

public class GreetingImpl implements Greeting {

	private GreetingService service;

	@Override
	public String greet(String name) {
		return service.greet(name);
	}

}
