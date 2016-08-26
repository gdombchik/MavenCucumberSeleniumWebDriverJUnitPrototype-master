package com.cucumber.mavenCucumberPrototype;

import cucumber.api.java.en.Given;

public class ParameterHandlingExample2 {
	@Given("^I have (\\d+) cukes in my belly$")
	public void iHaveCukesInMyBelly(int arg1) throws Throwable {
	    System.out.println("cukes in my belly " + arg1);
	}
}
