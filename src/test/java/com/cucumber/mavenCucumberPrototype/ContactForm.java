package com.cucumber.mavenCucumberPrototype;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*
 * Tutorial 5 - Scenario Data Tables
 */
public class ContactForm extends AbstractPageStepDefinition{
	
	WebDriver driver = getWebdriver();

	@Given("^I navigate to the cucumber website$")
	public void navigateToTheCucumberWebsite() throws Throwable {
		
		driver.navigate().to("http://localhost/cucumber/");
		
	}

	@When("^I fill out the form$")
	public void fillOutTheForm(DataTable table) throws Throwable {
		
		List<List<String>> tableList = table.raw();
		
		//List 1 == "row"
		//List 2 == "column"
		
		driver.findElement(By.name("name")).sendKeys(tableList.get(1).get(1)); //Gregory Dombchik
		driver.findElement(By.name("email")).sendKeys(tableList.get(2).get(1)); //greg@gregorydombchik.com
		driver.findElement(By.id("submit_contact")).click();
	}

	@Then("^I should be on the welcome page for contact form$")
	public void shouldBeOnTheWelcomePage() throws Throwable {
		Assert.assertFalse("Title is not Welcome", driver.getTitle().equals("Welcome!"));
		Assert.assertTrue("Title is not Welcome", driver.getTitle().equals("Welcome"));
	}

	@And("^I close browser$")
	public void closeBrowser() throws Throwable {
	    driver.quit();
	}
	
}
