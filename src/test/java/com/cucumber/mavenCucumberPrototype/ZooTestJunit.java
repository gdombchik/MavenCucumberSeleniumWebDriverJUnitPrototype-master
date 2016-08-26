package com.cucumber.mavenCucumberPrototype;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.pageObjectZoo.ContactConfirmationPage;
import com.cucumber.pageObjectZoo.ContactPage;
import com.cucumber.pageObjectZoo.LandingPage;

public class ZooTestJunit {
	
	WebDriver driver;

	@Before
	public void testSetUp(){
		//driver = new FirefoxDriver();
		//driver = new SafariDriver();
		driver = new ChromeDriver();
	}
	
	@After
	public void testShutDown(){
		driver.quit();
	}
	
	@Test
	public void shouldSendContactMessage(){
		LandingPage landingPage = new LandingPage(driver).navigateToWebApp();
		ContactPage contactPage = landingPage.navigateToContactPage("Contact");
		contactPage.setNameField("name").setAddressField("address").setPostCode("postcode").setEmailField("email");
		ContactConfirmationPage contactConfirmationPage = contactPage.submitForm();
		Assert.assertEquals("We have your message", contactConfirmationPage.getPageTitle());
	}
	
}
