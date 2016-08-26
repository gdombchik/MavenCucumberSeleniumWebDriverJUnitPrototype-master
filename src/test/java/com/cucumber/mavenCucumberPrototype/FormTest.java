package com.cucumber.mavenCucumberPrototype;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FormTest extends AbstractPageStepDefinition{
	
	WebDriver webdriver = getWebdriver();
	
	@Given("^I navigate to the \"([^\"]*)\" page$")
	public void navigateToTheCucumberWebsite(String arg1) throws Throwable {
		webdriver.navigate().to("http://localhost/cucumber/" + arg1);
	}
	
	@Then("^I populate the from$")
	public void populateForm() throws Throwable {
		Select dropdown = new Select(webdriver.findElement(By.name("langs")));
		dropdown.selectByIndex(2); //multi select (<select multiple name)
		dropdown.selectByIndex(3); //multi select (<select multiple name)
		Assert.assertEquals("Spanish",dropdown.getAllSelectedOptions().get(1).getText()); //second index of the items that are selected
		List<WebElement>  oRadioButton = webdriver.findElements(By.name("strgth")); //radio button
		oRadioButton.get(1).click(); //http://toolsqa.com/selenium-webdriver/checkbox-radio-button-operations/
		System.out.println(oRadioButton.get(1).getAttribute("value"));
		Assert.assertTrue("Selected Radio Button value is not returned.","Backend".equals(oRadioButton.get(1).getAttribute("value")));
		List<WebElement>  oCheckBoxes = webdriver.findElements(By.name("proglangs[]")); //check boxes
		oCheckBoxes.get(2).click();
		Assert.assertTrue("Selected Check Box value is not returned.","HTML".equals(oCheckBoxes.get(2).getAttribute("value")));
		System.out.println(oCheckBoxes.get(2).getAttribute("value"));
	}
	
	@And("^I close form handling browser$")
	public void closeParamterHandlingBrowser() throws Throwable {
	    webdriver.quit();
	}
}
