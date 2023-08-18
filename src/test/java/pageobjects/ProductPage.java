package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    By addToCartButtonForBackpack = By.xpath("//div[text()='Sauce Labs Backpack']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-".concat(wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonForBackpack)).getText().toLowerCase().replace(" ", "-"))))).click();
    }

    public boolean isProductInCart() {
        String elementName = "remove-".concat(driver.findElement(addToCartButtonForBackpack).getText().toLowerCase().replace(" ", "-"));
        return !driver.findElements(By.id(elementName)).isEmpty() && driver.findElement(By.id(elementName)).getText().equals("Remove");
    }
}