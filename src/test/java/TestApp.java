import Pages.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.MyProperties;


public class TestApp {

    public WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sonne\\IdeaProjects\\TestRenaissance\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MyProperties.getInstance().getProperty("url"));
    }
    @Test
    public void simpleTest() {
        BasePage basePage = new BasePage();
        driver.findElement(By.xpath("//span[contains(text(),'Открыть вклад')]//..")).click();

    }
    @After
    public void close(){
       //driver.quit();
    }
}
