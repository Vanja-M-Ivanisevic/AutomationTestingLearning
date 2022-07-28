import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class BaseTest {

    // Ovde smo deklarisali nasu promenljivu driver koja ce da pokrece chromedriver
 public static WebDriver driver;
 public static WebDriverWait wdWait;
 JavascriptExecutor js;
 public static Shadow shadow;


    // Ovo je JUnit anotacija koja govori da ce se ova metoda izvrsiti pre svih testova
    @Before
    // Ovo je metoda cije ime mi dajemo proizvoljno i tu stavljamo sve sto je potrebno izvrsiti pre svih testova
    public void setUp() {
        // Ovo automatski skida odgovarajucu verziju zeljenog pretrazivaca (drivera)
        WebDriverManager.chromedriver().setup();
        // Ovde smo nasoj promenljivoj driver dodelili objekat klase ChromeDriver
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
        shadow = new Shadow(driver);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    // Ovo je JUnit anotacija koja govori da ce se ova metoda izvrsiti nakon svih testova
    @After
    // Ovo je metoda cije ime mi dajemo proizvoljno i tu stavljamo sve sto je potrebno izvrsiti NAKON svih testova
    public void tearDown() {
        // Ova komanda zatvara samo tab koji je trenutno u fokusu
 //       driver.close();
        // Ova komanda zatvara ceo pretrazivac (driver)
 //       driver.quit();


    }

    // Ovo je Junit anotacija za test
    @Test
    public void firstTest() {
        // Otvoriti google stranicu

        // otovriti yahoo stranicu

        // vratiti se nazad

        // refreshovati stranicu

        // otici napred

        // udjemo u fullscreen sa pretrazivacem

        // zatvorimo tab


        driver.get("https://overview.mail.yahoo.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().fullscreen();
        driver.close();

        //XPATH:
        // Apsolutni - NE SMEMO DA KORISTIMO!!! (stalno se menja)
        // C:/My Documents/My Pictures/More/Grcka 2019/zalazak sunca.jpg

        // Relativni OBAVEZNO KORISTIMO
        // //input[@title="Search"]
        // //input[@maxlenght="2048"]
        //tipElementa[@atribut="vrednost"]
        // zalazak sunca.jpg

        //CSS selektor
        // [maxlength="2048"]
        // xpath po sadrzanom textu
        //div[contains(text(), 'Google offered')]
        //tipElementa[contains(text(), 'zeljeni tekst')]
        // xpath po tacnom tekstu
        //div[text() = 'Google offered in:   ']
        //tipElementa[text() = 'zeljeni tekst']

    }

    @Test
    public void googleTest () {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Beograd");
    }

    @Test
    public void domaci () {
        // u polje za pretragu upisati "yahoo"
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Yahoo");
        //lupiti enter
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        // Kliknuti na Yahoo link
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).click();
        driver.findElement(By.id("root_2")).click();
        driver.findElement(By.name("p")).clear();
        driver.findElement(By.name("p")).sendKeys("Google");
        driver.findElement(By.cssSelector(".rapid-noclick-resp._yb_58vnp")).click();
        driver.get(driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".d-ib.ls-05.fz-20.lh-26.td-hu.tc.va-bot.mxw-100p")).click();
    }

    @Test
            public void comtradeSuccessfulRegistrationTest () throws InterruptedException {
        driver.get("https://www.ctshop.rs/customer/account/create");
        sleep(10000);
        List<WebElement> popupBanners = shadow.findElements("#PsCloseButton");
        popupBanners.get(1).click();
        popupBanners.get(0).click();
        //  shadow.findElement("#PsCloseButton").click();
        // WebElement popUpButton = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35018').shadowRoot.querySelector('#PsCloseButton')");

        //Popuniti ime
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Vanja");

        //Popuniti prezime
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Milenov");

        //Popuniti email adresu ( xxx@xxx.xxx)
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("email"))).clear();
        driver.findElement(By.name("email")).sendKeys("blabla@blabla.bla");

        //odstiklirati news letter checkbox
        sleep(3000);
        WebElement checkbox = driver.findElement(By.name("is_subscribed"));
        if (checkbox.isSelected()) {
            checkbox.click();
        }

        //Popuniti lozinku
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("Peraperic4");

        //Popuniti potvrdu lozinke
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("Peraperic4");

        //Kliknuti na Posalji dugme
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Pošalji']"))).click();

    }



    @Test
    public void comtradeUnmatchingPasswords () throws InterruptedException {
        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(20000);
        List<WebElement> popupBanners = shadow.findElements("#PsCloseButton");

        // While petlja
        // int x = popupBanners.size();
        // while (x > 0) {
        // popupBanners.get(x-1).click();
        // x--;

        popupBanners.get(1).click();
        popupBanners.get(0).click();

        // Popuniti ime
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Vanja");
        // Popuniti prezime
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Milenov");
        // Popuniti email adresu
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("email"))).clear();
        driver.findElement(By.name("email")).sendKeys("lalal@lalal.lalala");
        // Odstiklirati news letter checkbox

        WebElement checkbox = driver.findElement(By.name("is_subscribed"));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
        // Popuniti lozinku
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("Peraperic45");
        // Popuniti potvrdu lozinke
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("Blabla3");
        //Kliknuti na posalji dugme
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Pošalji']"))).click();

    }

    @Test
    public void PopupsLoop () throws InterruptedException {

        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(10000);
        List<WebElement> popupBanners = shadow.findElements("#PsCloseButton");
        for(int i = popupBanners.size(); i> 0 ; i--)
        {
            popupBanners.get(i - 1).click();
        }

        // Popuniti ime
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Vanja");
        // Popuniti prezime
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Milenov");
        // Popuniti email adresu
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("email"))).clear();
        driver.findElement(By.name("email")).sendKeys("lalal@lalal.lalala");
        // Odstiklirati news letter checkbox

        WebElement checkbox = driver.findElement(By.name("is_subscribed"));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
        // Popuniti lozinku
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("Peraperic45");
        // Popuniti potvrdu lozinke
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("Blabla3");
        //Kliknuti na posalji dugme
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Pošalji']"))).click();

    }
@Test
    public void assertTest() {
        driver.get("https://www.ctshop.rs/customer/account/create");
        // Assert True uvek obavezan da bismo proverili da li je nesto prokazano na strani (poruka, slika, tekst)
    Assert.assertTrue(driver.findElement(By.xpath("//strong[text() = 'Kreirajte nalog']")).isDisplayed());
    // Assert Equals obavezan kada proveravamo tekst kako bismo znali da je tekst tacan i poklapa se sa BRD (dokumentacijom)
    Assert.assertEquals("KREIRAJTE NALOG", driver.findElement(By.xpath("//strong[text() = 'Kreirajte nalog']")).getText());


}

@Test
    public void comtradeSuccessfulRegistrationTest2 () throws InterruptedException {
    driver.get("https://www.ctshop.rs/customer/account/create");
    sleep(10000);
    List<WebElement> popupBanners = shadow.findElements("#PsCloseButton");
    for (int i = popupBanners.size(); i > 0; i--) {
        popupBanners.get(i - 1).click();
    }
    // shadow.findElement("#PsCloseButton").click();
    // WebElement popUpButton = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35018').shadowRoot.querySelector('#PsCloseButton')");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text() = 'Prihvatam']"))).click();
    //Popuniti ime
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
    driver.findElement(By.id("firstname")).sendKeys("Pera");

    //Popuniti prezime
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
    driver.findElement(By.id("lastname")).sendKeys("Peric");

    //Popuniti email adresu ( xxx@xxx.xxx)
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("email"))).clear();
    driver.findElement(By.name("email")).sendKeys("bl@blabla.bla");

    //odstiklirati news letter checkbox
    sleep(3000);
    WebElement checkbox = driver.findElement(By.name("is_subscribed"));
    if (checkbox.isSelected()) {
        checkbox.click();
    }

    //Popuniti lozinku
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
    driver.findElement(By.id("password")).sendKeys("Peraperic4");

    //Popuniti potvrdu lozinke
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
    driver.findElement(By.id("confirmation")).sendKeys("Peraperic4");

    //Kliknuti na Posalji dugme
    wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Pošalji']"))).submit();

    Assert.assertTrue(driver.findElement(By.cssSelector(".alert")).isDisplayed());
    Assert.assertEquals("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!", driver.findElement(By.cssSelector(".alert")).getText());

    // 1. nacin
   // Assert.assertFalse(DoesElementExists("//p[text() = 'Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.']"));

    // 2. nacin
    Assert.assertThrows(NoSuchElementException.class, () ->
        driver.findElement(By.xpath("//p[text() = 'Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.']")).getText());
}
    // metoda za 1. nacin
    private boolean DoesElementExists(String selector) {
        try {
           driver.findElement(By.xpath(selector));
            return true;
       }
       catch (NoSuchElementException ex) {
            return false;
        }
 // metoda za 3. nacin
        // Assert.assertTrue( driver.findElements(By.cssSelector(".alert-success")).isEmpty());




    }




    @Test
    public void selectPravnoLice() {
        driver.get("https://www.ctshop.rs/customer/account/create");
        Select pravnoLice = new Select(driver.findElement(By.id("pravnolice")));
        pravnoLice.selectByValue("1");
        pravnoLice.selectByVisibleText("Da");
        pravnoLice.selectByIndex(1);

    }

@Test
    public void SuccessfulRegistrationOfCompanyUser() throws InterruptedException {
        driver.get("https://www.ctshop.rs/customer/account/create");
        sleep(10000);
    List<WebElement> popupBanners = shadow.findElements("#PsCloseButton");
    for (int i = popupBanners.size(); i > 0; i--) {
        popupBanners.get(i - 1).click();
    }

    Select pravnoLice = new Select(driver.findElement(By.id("pravnolice")));
    pravnoLice.selectByVisibleText("Da");

    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
    driver.findElement(By.id("firstname")).sendKeys("Vanja");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
    driver.findElement(By.id("lastname")).sendKeys("Milenov");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("email"))).clear();
    driver.findElement(By.name("email")).sendKeys("ikk@ikk.ikk");
    WebElement checkbox = driver.findElement(By.name("is_subscribed"));
    checkbox.click();
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firma"))).clear();
    driver.findElement(By.id("firma")).sendKeys("VMI Teaching");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pib"))).clear();
    driver.findElement(By.id("pib")).sendKeys("999999999");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
    driver.findElement(By.id("password")).sendKeys("123456");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
    driver.findElement(By.id("confirmation")).sendKeys("123456");
    wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Pošalji']"))).submit();













}





    // Ovo je kraj nase klase i nista ne sme biti posle ove viticaste zagrade
}
