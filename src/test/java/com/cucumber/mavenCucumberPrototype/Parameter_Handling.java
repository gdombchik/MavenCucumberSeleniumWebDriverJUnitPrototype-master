package com.cucumber.mavenCucumberPrototype;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*
 * Tutorial 4 - Parameter Handling
 */
public class Parameter_Handling extends AbstractPageStepDefinition{
	
	WebDriver driver = getWebdriver();
	
	@Given("^I navigate to the \"([^\"]*)\" on the cucumber website$")
	public void navigateToTheCucumberWebsite(String arg1) throws Throwable {
		driver.navigate().to("http://localhost/cucumber/" + arg1);
	}
	
	/*@When("^I say \"([^\"]*)\"$")
	public void i_say_hi() throws Throwable {
	    System.out.println("I say hi");
	}*/
	
	@When("^I say \"([^\"]*)\"$")
	public void i_say(String arg1) throws Throwable {
	    System.out.println("I am saying " + arg1);
	}

	
	@Then("^I close parameter handling browser$")
	public void closeParamterHandlingBrowser() throws Throwable {
	    driver.quit();
	}
}
