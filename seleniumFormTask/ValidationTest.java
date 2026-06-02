public import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidationTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void invalidLoginTest() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username"))
                .sendKeys("wronguser");

        driver.findElement(By.id("password"))
                .sendKeys("wrongpass");

        driver.findElement(By.id("submit"))
                .click();

        String errorMessage =
                driver.findElement(By.id("error"))
                      .getText();

        Assert.assertTrue(
                errorMessage.contains("Your username is invalid!"));

        System.out.println("Error message verified successfully.");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
} {
    
}
