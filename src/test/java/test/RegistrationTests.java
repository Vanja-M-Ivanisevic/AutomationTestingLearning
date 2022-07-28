package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page.LoginPage;
import page.RegistrationPage;
import page.SharedMethods;

public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage;
    SharedMethods sharedMethods;

    LoginPage loginPage;
    // @Before metode ne smeju da se zovu isto (ona u basetest klasi i ova moraju da imaju razlicito ime)
    @Before
    public void setUpTest() {
        registrationPage = new RegistrationPage();
        sharedMethods = new SharedMethods();
        loginPage = new LoginPage();
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
    public void sporetiKarakondzulaTest() throws InterruptedException {
        registrationPage.sviProizvodiMenuHover();
        registrationPage.BelaTehnikaMenuHover();


    }





}
