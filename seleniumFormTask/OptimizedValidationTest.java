public import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class OptimizedValidationTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Optimized implicit wait
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void invalidLoginTest() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username"))
                .sendKeys("wronguser");

        driver.findElement(By.id("password"))
                .sendKeys("wrongpass");

        driver.findElement(By.id("submit"))
                .click();

        String error =
                driver.findElement(By.id("error"))
                        .getText();

        Assert.assertTrue(
                error.contains("Your username is invalid!"));

        System.out.println("Invalid login validation passed");
    }

    @Test(priority = 2)
    public void emptyFieldValidation() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("submit"))
                .click();

        Assert.assertTrue(driver.getCurrentUrl()
                .contains("practice-test-login"));
    }

    @AfterClass
    public void closeBrowser() {

        driver.quit();
    }
} {
    
}
