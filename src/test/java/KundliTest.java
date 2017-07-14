import apackage.dummy.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by chandank on 14/07/2017.
 */
public class KundliTest {

    WebDriver driver;
    String name,gender,date,time,place;
    BasePage page;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/chandank/Development/apps/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/Users/chandank/Library/Application Support/Google/Chrome/Default");
        driver =  new ChromeDriver(options);
        page = new BasePage(driver);
    }

    @Test
    public void cc(){
        driver.get("http://www.astrosage.com/cloud/login.asp");

        findElement(By.id("txtUserID")).sendKeys("chndnbhrdwj");
        findElement(By.id("txtPassword")).sendKeys("solution");
        findElement(By.xpath("//input[@name='submit']")).click();

        String newChart = "//a[text()='New Chart']";
        waitForElement(By.xpath(newChart),60).click();

        name= "Chandan";
        gender= "male";
        date = "09,11,1982";
        time = "14,40,00";
        place = "Nangal Dam";

        findElement(By.xpath("//input[@id='Name']")).sendKeys(name);

        Select select = new Select(findElement(By.xpath("//select[@id='sex']")));
        select.selectByValue(gender);

        sendKeys(findElement(By.xpath("//input[@id='Day']")),date.split(",")[0]);
        sendKeys(findElement(By.xpath("//input[@id='Month']")),date.split(",")[1]);
        sendKeys(findElement(By.xpath("//input[@id='Year']")),date.split(",")[2]);

        sendKeys(findElement(By.xpath("//input[@id='Hrs']")),time.split(",")[0]);
        sendKeys(findElement(By.xpath("//input[@id='Min']")),time.split(",")[1]);
        sendKeys(findElement(By.xpath("//input[@id='Sec']")),time.split(",")[2]);

        sendKeys(findElement(By.xpath("//input[@id='place']")),place);;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        page.getTextElement(place).click();

        findElement(By.xpath("//input[@name='newchartdone']")).click();

        findElement(By.xpath("//b[text()='Work Sheet']")).click();
    }


    public WebElement waitForElement(By by,int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    public void sendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
}
