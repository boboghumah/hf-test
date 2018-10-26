package com.hellofreshchallenge.stepFiles;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hellofreshchallenge.baseSetupClass.BaseTestSetup;

public class LoginTest extends BaseTestSetup {

	@Before
	public void setup() {
		this.baseSetup();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) takeScreenshot(scenario);
		baseTearDown();
		
	}

	@Given("^User goes to the website$")
	public void user_goes_to_the_website() throws Throwable {
		driver.get(baseUrl);

	}

	@And("^User navigates to the login page by clicking the sign in button on the homepage$")
	public void user_navigates_to_the_login_page_by_clicking_the_sign_in_button_on_the_homepage() throws Throwable {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
		System.out.println("User clicks on the sign in button");
		driver.findElement(By.className("login")).click();
	}

	@And("^User enters a valid email address on the log in form$")
	public void user_enters_a_valid_email_address() throws Throwable {

		driver.findElement(By.id("email")).sendKeys(existingUserEmail);

	}

	@And("^User enters a valid password on the log in form$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.id("passwd")).sendKeys(existingUserPassword);
	}

	@When("^User clicks on the sign in button$")
	public void user_clicks_on_the_sign_in_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitLogin")));
		driver.findElement(By.id("SubmitLogin")).click();

	}

	@Then("^User should be signed in and taken to the homepage successfully$")
	public void user_should_be_signed_in_and_taken_to_the_homepage_successfully() throws Throwable {

		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

		assertEquals(heading.getText(), "MY ACCOUNT");
		assertEquals(fullName, driver.findElement(By.className("account")).getText());
		assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
		assertTrue(driver.findElement(By.className("logout")).isDisplayed());
		assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
	}

}
