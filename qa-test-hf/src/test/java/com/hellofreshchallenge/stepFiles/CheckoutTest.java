package com.hellofreshchallenge.stepFiles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hellofreshchallenge.baseSetupClass.BaseTestSetup;

public class CheckoutTest extends BaseTestSetup {


	@Before
	public void setup() {
		this.baseSetup();
	}

	@After
	public void tearDown() {
		this.baseTearDown();
	}

	@Given("^User navigates to the website\\.$")
	public void user_navigates_to_the_website() throws Throwable {
		driver.get(baseUrl);
	}

	@And("^User clicks on the sign in button on the homepage\\.$")
	public void user_clicks_on_the_sign_in_button_on_the_homepage() throws Throwable {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
		System.out.println("User clicks on the sign in button");
		driver.findElement(By.className("login")).click();
	}

	@And("^User enters a valid email address on the log in form\\.$")
	public void user_enters_a_valid_email_address_on_the_log_in_form() throws Throwable {
		driver.findElement(By.id("email")).sendKeys(existingUserEmail);
	}

	@And("^User enters a valid password on the log in form\\.$")
	public void user_enters_a_valid_password_on_the_log_in_form() throws Throwable {
		driver.findElement(By.id("passwd")).sendKeys(existingUserPassword);
	}

	@And("^User clicks on the sign in buttonon the login form$")
	public void user_clicks_on_the_sign_in_buttonon_the_login_form() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitLogin")));
		driver.findElement(By.id("SubmitLogin")).click();
	}

	@And("^User selects a product$")
	public void user_selects_a_product() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
		driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
		driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
	}

	@And("^User clicks on the Add to cart button$")
	public void user_clicks_on_the_Add_to_cart_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
	}

	@And("^User click on the Proceed to checkout button$")
	public void user_click_on_the_Proceed_to_checkout_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
	}

	@And("^User click on the Proceed to checkout button on the Cart Summary page$")
	public void user_click_on_the_Proceed_to_checkout_button_on_the_Cart_Summary_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
	}

	@And("^User click on the Proceed to checkout button on the Address page$")
	public void user_click_on_the_Proceed_to_checkout_button_on_the_Address_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
	}

	@And("^User checks the Terms Of Service checkbox$")
	public void user_checks_the_Terms_Of_Service_checkbox() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
	}

	@And("^User click on the Proceed to checkout button on the Shipping page$")
	public void user_click_on_the_Proceed_to_checkout_button_on_the_Shipping_page() throws Throwable {
		driver.findElement(By.name("processCarrier")).click();
	}

	@And("^User selects Pay by bank wire payment method$")
	public void user_selects_Pay_by_bank_wire_payment_method() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
	}

	@When("^User clicks on the I confirm my order button$")
	public void user_clicks_on_the_I_confirm_my_order_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button")))
				.click();

	}

	@Then("^User should be redirected an Order Confirmation page successfully$")
	public void user_should_be_redirected_an_Order_Confirmation_page_successfully() throws Throwable {
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		assertEquals("ORDER CONFIRMATION", heading.getText());
		assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText()
				.contains("Your order on My Store is complete."));
		assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
	}

}
