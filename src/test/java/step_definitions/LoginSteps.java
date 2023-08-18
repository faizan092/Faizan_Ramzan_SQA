package step_definitions;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;

public class LoginSteps {

  public WebDriver driver;
  LoginPage loginPage;

  public LoginSteps() {
    driver = Hooks.driver;
    loginPage = new LoginPage(driver);
  }

  @Given("^I am on the SauceDemo login page$")
  public void i_open_automationpractice_website() throws Throwable {
    driver.get("https://www.saucedemo.com/");
  }

  @When("I login with username {string} and password {string}")
  public void i_login_with_username_and_password(
    String username,
    String password
  ) {
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLogin();
  }

  @Then("I should be redirected to the inventory page")
  public void i_should_be_redirected_to_the_inventory_page() {
    assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    driver.quit();
  }

  @Then("I should see an error message")
  public void i_should_see_an_error_message() {
    assertTrue(loginPage.isErrorVisible());
    driver.quit();
  }
}
