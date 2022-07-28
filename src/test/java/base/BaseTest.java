package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdWait;

    public Select dropdown;
    public static Actions actions;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        driver.get("https://www.ctshop.rs/customer/account/create");
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() {
        // TODO odkomentarisi ovo kada testovi budu gotovi
    //   driver.quit();
    }

}
