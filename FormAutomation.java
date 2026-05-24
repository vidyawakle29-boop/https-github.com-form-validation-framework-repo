import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormAutomation {

    public static void main(String[] args) throws InterruptedException {

        // Set ChromeDriver Path
        System.setProperty("webdriver.chrome.driver",
                "C:\\chromedriver\\chromedriver.exe");

        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Open Demo Website
        driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Text Field
        driver.findElement(By.id("firstName")).sendKeys("Vidya");

        driver.findElement(By.id("lastName")).sendKeys("Wakle");

        // Email
        driver.findElement(By.id("userEmail"))
                .sendKeys("vidya@gmail.com");

        // Radio Button
        driver.findElement(By.xpath("//label[text()='Female']")).click();

        // Mobile Number
        driver.findElement(By.id("userNumber"))
                .sendKeys("9876543210");

        // Date Picker
        driver.findElement(By.id("dateOfBirthInput")).click();

        // Subject
        driver.findElement(By.id("subjectsInput"))
                .sendKeys("Computer Science");

        // Checkbox
        driver.findElement(By.xpath("//label[text()='Sports']")).click();

        // Upload File
        WebElement upload =
                driver.findElement(By.id("uploadPicture"));

        upload.sendKeys("C:\\Users\\HP\\Pictures\\sample.jpg");

        // Address Text Area
        driver.findElement(By.id("currentAddress"))
                .sendKeys("Mumbai, Maharashtra");

        // State Dropdown
        driver.findElement(By.id("state")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[text()='NCR']")).click();

        // City Dropdown
        driver.findElement(By.id("city")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[text()='Delhi']")).click();

        // Submit Button
        driver.findElement(By.id("submit")).click();

        Thread.sleep(3000);

        System.out.println("Form Submitted Successfully");

        // Close Browser
        driver.quit();
    }
}