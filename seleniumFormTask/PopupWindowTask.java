import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class PopupWindowTask {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Task 4 Started");

        // ALERT TEST SITE
        driver.get("https://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("//button[contains(text(),'click the button to display an alert box')]")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();

        // MULTIPLE WINDOW
        driver.navigate().to("https://demo.automationtesting.in/Windows.html");

        String parent = driver.getWindowHandle();

        driver.findElement(By.xpath("//button[contains(text(),'click')]")).click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String win : allWindows) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
                System.out.println("Child Title: " + driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(parent);
        System.out.println("Parent Title: " + driver.getTitle());

        driver.quit();

        System.out.println("Task Executed Successfully");
    }
}
