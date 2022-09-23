import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebAppTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("web-driver.chrome.driver", "resources/chromedriver.exe");

        //. Open your Chrome browser
        driver = new ChromeDriver();

    }

    @Test(priority = 0)
    public void pageUrl() throws InterruptedException {
        //1. Input Konga Page URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("Correct Webpage ");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(3000);

    }

    @Test(priority = 1)
    public void browser() throws InterruptedException {
        //2. Maximize the browser
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void Page() throws InterruptedException {
        //3. Get page title
        System.out.println("Page title is : " + driver.getTitle());
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void Login() throws InterruptedException {
        //4. Click on the sign-in/ log in button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);
        //5. Input your email address
        driver.findElement(By.id("username")).sendKeys("yv*******");
        Thread.sleep(3000);
        //6. Input your password
        driver.findElement(By.id("password")).sendKeys("Ad*****");
        Thread.sleep(3000);
        //7. click on the log-in button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void clickaccount() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        String expectedUrl = "https://www.konga.com/account";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage ");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void logout() {
        //11. click on logout
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage ");
        else
            //fail
            System.out.println("Wrong Webpage");
    }

    @AfterTest
    public void closeBrowser() {
        // Quit the browser
        driver.quit();
    }
}
