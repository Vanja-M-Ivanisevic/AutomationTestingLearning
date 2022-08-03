package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page.*;

public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage;
    SharedMethods sharedMethods;

    LoginPage loginPage;
    // @Before metode ne smeju da se zovu isto (ona u basetest klasi i ova moraju da imaju razlicito ime)

    SporetiPage sporetiPage;
    ElektricniSporetiPage elektricniSporetiPage;

    GorenjeE5121WH gorenjeE5121WH;

    BekoFSS66000Welektričnišporet bekoFSS66000Welektričnišporet;


    @Before
    public void setUpTest() {
        registrationPage = new RegistrationPage();
        sharedMethods = new SharedMethods();
        loginPage = new LoginPage();
        sporetiPage = new SporetiPage();
        elektricniSporetiPage = new ElektricniSporetiPage();
        gorenjeE5121WH = new GorenjeE5121WH();
        bekoFSS66000Welektričnišporet = new BekoFSS66000Welektričnišporet();

    }


    @Test
    public void successfulRegistrationTest() throws InterruptedException{
        sharedMethods.killAllPopupBanners();
        registrationPage.imeInputFieldSendKeys("Neit");
        registrationPage.newsLetterCheckboxClick();
        registrationPage.prezimeInputFieldSendKeys("Milenov");
        registrationPage.EmailAdresaFieldSendKeys("bla@bli.bla");
        registrationPage.passwordInputFieldSendKeys("blablabla");
        registrationPage.confirmationInputFieldSendKeys("blablabla");
        registrationPage.PošaljiButtonClick();
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert")).isDisplayed());
        Assert.assertEquals("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!", driver.findElement(By.cssSelector(".alert")).getText());



    }
    @Test
    public void unmatchingPasswordsTest() throws InterruptedException {
        sharedMethods.killAllPopupBanners();
        registrationPage.imeInputFieldSendKeys("Vanja");
        registrationPage.newsLetterCheckboxClick();
        registrationPage.prezimeInputFieldSendKeys("Ivanisevic");
        registrationPage.EmailAdresaFieldSendKeys("vmi@vmi.vm");
        registrationPage.passwordInputFieldSendKeys("blblbl");
        registrationPage.confirmationInputFieldSendKeys("123456");
        registrationPage.PošaljiButtonClick();
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert")).isDisplayed());
        Assert.assertEquals("Razlikuju se lozinka i potvrda lozinke!", driver.findElement(By.cssSelector(".alert")).getText());


    }
    @Test
    public void SuccessfulRegistrationAsCompanyUser() throws InterruptedException {
        sharedMethods.killAllPopupBanners();
        registrationPage.imeInputFieldSendKeys("Vanja");
        registrationPage.newsLetterCheckboxClick();
        registrationPage.prezimeInputFieldSendKeys("Milenov");
        registrationPage.EmailAdresaFieldSendKeys("vim@bla.vm");
        registrationPage.pravnoLiceFieldSelect("VMI", "123456789", "Da");
        registrationPage.passwordInputFieldSendKeys("123456");
        registrationPage.confirmationInputFieldSendKeys("123456");
        registrationPage.PošaljiButtonClick();
        Assert.assertTrue(loginPage.successfulRegistrationMessageIsDisplayed());
        Assert.assertEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.", loginPage.successfulRegistrationMessageGetText());



    }

    @Test

    public void sameEmailUnsuccessfulRegistrationTest() throws InterruptedException {

        sharedMethods.killAllPopupBanners();
        registrationPage.imeInputFieldSendKeys("Vanja");
        registrationPage.newsLetterCheckboxClick();
        registrationPage.prezimeInputFieldSendKeys("Milenov");
        registrationPage.EmailAdresaFieldSendKeys("vim@bla.vmi");
        registrationPage.pravnoLiceFieldSelect("VMI", "123456789", "Da");
        registrationPage.passwordInputFieldSendKeys("123456");
        registrationPage.confirmationInputFieldSendKeys("123456");
        registrationPage.PošaljiButtonClick();
        Assert.assertTrue(registrationPage.alertWarningMessageIsDisplayed());
        Assert.assertEquals("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!", registrationPage.alertWarningMessageGetText());
        Assert.assertTrue(loginPage.SuccessfulRegistrationMessageListIsEmpty());
    }


    @Test
    public void sporetiKarakondzulaTest() {
        registrationPage.sviProizvodiMenuHover();
        registrationPage.BelaTehnikaMenuHover();
        registrationPage.sporetiMenuClick();
        sporetiPage.ElektricniSporetiClick();
        sharedMethods.prihvatamButtonClick();
        elektricniSporetiPage.GorenjeCheckboxSelect();
        registrationPage.gorenjeSporetScroll();
        elektricniSporetiPage.GorenjeSporetClick();
        Assert.assertTrue(gorenjeE5121WH.staraCenaIsDisplayed());
        Assert.assertEquals("30.588 RSD", gorenjeE5121WH.staraCenaGetText());
        Assert.assertTrue(gorenjeE5121WH.staraCenaIsDisplayed());
        Assert.assertEquals("25.999", gorenjeE5121WH.novaCenaGetText());
        driver.navigate().back();
        elektricniSporetiPage.GorenjeCheckboxSelect();
        elektricniSporetiPage.bekoCheckboxClick();
        elektricniSporetiPage.bekoElektricniSporetClick();
        Assert.assertTrue(bekoFSS66000Welektričnišporet.belaBojaProveraIsDisplayed());
        Assert.assertEquals("Bela", bekoFSS66000Welektričnišporet.belaBojaProveraGetText());
        bekoFSS66000Welektričnišporet.bekoOceneClick();
        Assert.assertTrue(bekoFSS66000Welektričnišporet.belaBojaProveraIsDisplayed());
        Assert.assertEquals("Kupili smo ovaj sporet za letnju kuhinju i jedini kriterijum je bio da bude sto jeftiniji. " +
                "Videli smo ovaj model i posle razgovora sa prodavcem, shvatili smo da nema sta dalje da gledamo. Bekov sporet najobicniji, sa minimalno elektronike za 23 hiljade je smesno. " +
                "Mi smo prezadovoljni jer smo prosli jeftinije nego sto smo mislili, a sporet za sada radi perfektno.", bekoFSS66000Welektričnišporet.komentarLjubaGetText());

    }





}
