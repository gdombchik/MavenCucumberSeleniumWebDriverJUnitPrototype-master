package com.cucumber.mavenCucumberPrototype;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/*
 * Scenario Outline Data Tables
 */
public class ScenarioOutline extends AbstractPageStepDefinition{
	
	WebDriver driver = getWebdriver();
	
	//@Before //Cucumber Scenario Hooks (Tutorial 7)
	public void setUpTest(){
		System.out.println("in setUpTest");
		//driver = new FirefoxDriver();
	}
	
	//@After //Cucumber Scenario Hooks (Tutorial 8)
	public void afterTest(){
		System.out.println("in afterTest");
		//driver.close();
	}
	
	@Before("@tagForScenarioOutline")  //Cucumber Scenario Hooks (Tutorial 7)
	public void setUpTestForTag(){
		System.out.println("in setUpTestForTag");
		//driver = new FirefoxDriver();
	}
	
	@After("@tagForScenarioOutline")  //Cucumber Scenario Hooks (Tutorial 8)
	public void afterTestForTag(){
		System.out.println("in afterTestForTag");
		//driver.close();
	}

	@Given("^I navigate to the ([^\"]*) page$")
	public void navigateToPage(String link) throws Throwable {
		driver.navigate().to("http://localhost/cucumber/" + link);
	}

	@Then("^I should be on the ([^\"]*) page$")
	public void validateTitleOfPage(String value) throws Throwable {
		Assert.assertTrue("Title is Home", driver.getTitle().equals(value));
	}
	
}
