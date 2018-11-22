package com.cg.project.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SignUpUserStepDefinition {

	private WebDriver driver;

	@Given("^User is on Google HomePage$")
	public void user_is_on_Google_HomePage() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"D:\\159938_Pankush_Kapoor\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
	}

	@When("^User search for 'Agile Methodology'$")
	public void user_search_for_Agile_Methodology() throws Throwable {
		By by = By.name("q");
		WebElement searchTxt = driver.findElement(by);
		searchTxt.sendKeys("Agile Methodology");
		searchTxt.submit();
	}

	@Then("^All links should display with 'Agile Methodology'$")
	public void all_links_should_display_with_Agile_Methodology() throws Throwable {
		String actualTitle = driver.getTitle();
		String expectedTitle="Agile Methodology - Google Search";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	
	/*@Given("^User is on login Page$")
	public void user_is_on_login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"D:\\159938_Pankush_Kapoor\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://github.com/login");
	}

	@When("^User enters their correct credentials$")
	public void user_enters_their_correct_credentials() throws Throwable {
		By by1 = By.name("login");
		By by2 = By.name("password");
		WebElement usernameTxt = driver.findElement(by1);
		WebElement passwordTxt = driver.findElement(by2);
		usernameTxt.sendKeys("pankushkapoor");
		passwordTxt.sendKeys("pankush1234");
		passwordTxt.submit(); 
	}

	@Then("^User gets access to their Account$")
	public void user_gets_access_to_their_Account() throws Throwable {
		String actualTitle = driver.getTitle();
		String expectedTitle="GitHub";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}*/
	
}
