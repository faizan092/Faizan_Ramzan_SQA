package step_definitions;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.ProductPage;
import io.cucumber.java.en.*;

import static org.junit.Assert.*;

public class ProductSteps {

    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;

    @Given("I am logged in as {string} with password {string}")
    public void i_am_logged_in_as_with_password(String username, String password) {
        driver = Hooks.driver;
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        productPage = new ProductPage(driver);
    }

    @When("I add the product {string} to the cart")
    public void i_add_the_product_to_the_cart(String productName) {
        productPage.addProductToCart();
    }

    @Then("The product {string} should be in my cart")
    public void the_product_should_be_in_my_cart(String productName) {
        assertTrue(productPage.isProductInCart());
        driver.quit();
    }
}