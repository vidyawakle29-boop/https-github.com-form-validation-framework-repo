public class FinalFrameworkReviewTest {
    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FinalFrameworkReviewTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void verifyValidLogin() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username"))
                .sendKeys("student");

        driver.findElement(By.id("password"))
                .sendKeys("Password123");

        driver.findElement(By.id("submit")).click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("logged-in-successfully"));

        System.out.println("Valid Login Test Passed");
    }

    @Test(priority = 2)
    public void verifyInvalidLogin() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username"))
                .sendKeys("wronguser");

        driver.findElement(By.id("password"))
                .sendKeys("wrongpass");

        driver.findElement(By.id("submit")).click();

        String error =
                driver.findElement(By.id("error")).getText();

        Assert.assertTrue(error.contains("invalid"));

        System.out.println("Invalid Login Test Passed");
    }

    @Test(priority = 3)
    public void verifyPageTitle() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        String title = driver.getTitle();

        Assert.assertFalse(title.isEmpty());

        System.out.println("Page Title Verification Passed");
    }

    @AfterClass
    public void tearDown() {

        System.out.println("--------------------------------");
        System.out.println("Framework Review Completed");
        System.out.println("All Critical Tests Executed");
        System.out.println("--------------------------------");

        driver.quit();
    }
}
}
