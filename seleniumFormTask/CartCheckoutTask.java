import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartCheckoutTask {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<String> products = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"
        );

        // Add products to cart
        for (String product : products) {

            WebElement item = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[text()='" + product + "']")));

            item.click();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Add to cart')]")))
                    .click();

            driver.navigate().back();
        }

        // Open cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Verify products added
        int cartItems = driver.findElements(By.className("cart_item")).size();

        if (cartItems == products.size()) {
            System.out.println("All products added successfully.");
        } else {
            System.out.println("Product verification failed.");
        }

        // Checkout
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Vidya");
        driver.findElement(By.id("last-name")).sendKeys("Wakle");
        driver.findElement(By.id("postal-code")).sendKeys("441001");

        driver.findElement(By.id("continue")).click();

        System.out.println("Checkout process started successfully.");

        driver.quit();
    }
}