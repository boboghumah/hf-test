package com.hellofreshchallenge.stepFiles;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hellofreshchallenge.baseSetupClass.BaseTestSetup;

public class SignUpTest extends BaseTestSetup {

	int counter = 0;

	@Before
	public void setup() {
		this.baseSetup();
	}

	@After
	public void tearDown() {
		this.baseTearDown();
	}

	@Given("^User navigates to the website$")
	public void user_navigates_to_the_website() throws Throwable {
		driver.get(baseUrl);

	}

	@And("^User clicks on the sign in button on the homepage$")
	public void user_clicks_on_the_sign_in_button_on_the_homepage() throws Throwable {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
		System.out.println("User clicks on the sign in button");
		driver.findElement(By.className("login")).click();
	}

	@And("^User enters a valid email address$")
	public void user_enters_a_valid_email_address() throws Throwable {
		driver.findElement(By.id("email_create")).sendKeys(email);
	}

	@And("^User clicks the create an account button$")
	public void user_clicks_the_create_an_account_button() throws Throwable {
		driver.findElement(By.id("SubmitCreate")).click();
	}

	@And("^User selects title$")
	public void user_selects_title() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();

	}

	@And("^User enters firstname$")
	public void user_enters_firstname() throws Throwable {
		driver.findElement(By.id("customer_firstname")).sendKeys(name);
	}

	@And("^User enters lastname$")
	public void user_enters_lastname() throws Throwable {
		driver.findElement(By.id("customer_lastname")).sendKeys(surname);
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.id("passwd")).sendKeys("Qwerty");
	}

	@And("^User selects date of birth$")
	public void user_selects_date_of_birth() throws Throwable {
		Select select = new Select(driver.findElement(By.id("days")));
		select.selectByValue("1");
		select = new Select(driver.findElement(By.id("months")));
		select.selectByValue("1");
		select = new Select(driver.findElement(By.id("years")));
		select.selectByValue("2000");
	}

	@And("^User enters company name$")
	public void user_enters_company_name() throws Throwable {
		driver.findElement(By.id("company")).sendKeys("Company");
	}

	@And("^User enters company address$")
	public void user_enters_company_address() throws Throwable {
		driver.findElement(By.id("address1")).sendKeys("Qwerty, 123");
		driver.findElement(By.id("address2")).sendKeys("zxcvb");
	}

	@And("^User enters city$")
	public void user_enters_city() throws Throwable {
		driver.findElement(By.id("city")).sendKeys("Qwerty");
	}

	@And("^User selects state$")
	public void user_selects_state() throws Throwable {
		Select select = new Select(driver.findElement(By.id("id_state")));
		select.selectByVisibleText("Colorado");
	}

	@And("^User enters postcode$")
	public void user_enters_postcode() throws Throwable {
		driver.findElement(By.id("postcode")).sendKeys("12345");
	}

	@And("^User enters additional information$")
	public void user_enters_additional_information() throws Throwable {
		driver.findElement(By.id("other")).sendKeys("Qwerty");

	}

	@And("^User enters phonenumber$")
	public void user_enters_phonenumber() throws Throwable {
		driver.findElement(By.id("phone")).sendKeys("12345123123");
		driver.findElement(By.id("phone_mobile")).sendKeys("12345123123");

	}

	@And("^User enters an address alias$")
	public void user_enters_an_address_alias() throws Throwable {
		driver.findElement(By.id("alias")).sendKeys("hf");
	}

	@When("^User clicks on the register button$")
	public void user_clicks_on_the_register_button() throws Throwable {
		driver.findElement(By.id("submitAccount")).click();
	}

	@Then("^User should be redirected to the homepage successfully$")
	public void user_should_be_redirected_to_the_homepage_successfully() throws Throwable {
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

		assertEquals(heading.getText(), "MY ACCOUNT");
		assertEquals(driver.findElement(By.className("account")).getText(), name + " " + surname);
		assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
		assertTrue(driver.findElement(By.className("logout")).isDisplayed());
		assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
	}

}
