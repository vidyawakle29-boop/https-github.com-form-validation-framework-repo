import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTask {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open Website
        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Product List
        List<String> products = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"
        );

        // Add Products to Cart
        for (String product : products) {

            WebElement item = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[text()='" + product + "']")));

            item.click();

            WebElement addToCart = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Add to cart')]")));

            addToCart.click();

            driver.navigate().back();
        }

        // Go to Cart
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.className("shopping_cart_link")))
                .click();

        // Checkout
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("checkout")))
                .click();

        System.out.println("Products added and checkout started successfully.");

        driver.quit();
    }
}