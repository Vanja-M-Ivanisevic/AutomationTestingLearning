package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    WebElement imeInputField;
    @FindBy(id = "is_subscribed")
    WebElement newsLetterCheckbox;
    @FindBy(id = "lastname")
    WebElement prezimeInputField;
    @FindBy(id = "email_address")
    WebElement EmailAdresaField;
    @FindBy(id = "pravnolice")
    WebElement PravnoLiceDropdown;
    @FindBy(id = "firma")
    WebElement firmaInputField;
    @FindBy(id = "pib")
    WebElement pibInputField;
    @FindBy(id = "password")
    WebElement passwordInputField;
    @FindBy(id = "confirmation")
    WebElement confirmationInputField;
    @FindBy (xpath = "//span[text() = 'Pošalji']")
    WebElement PošaljiButton;
    @FindBy (css = ".alert-warning")
    WebElement alertWarningMessage;
    @FindBy(css = ".am-opener")
    WebElement sviProizvodiMenu;
    @FindBy(css = "a[href=\"/bela-tehnika\"")
    WebElement belaTehnikaMenu;
    @FindBy(css = "a[href=\"/sporeti\"")
    WebElement sporetiMenu;




    public void imeInputFieldSendKeys(String ime) {
        wdWait.until(ExpectedConditions.visibilityOf(imeInputField)).clear();
        imeInputField.sendKeys(ime);

    }

    public void newsLetterCheckboxClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(newsLetterCheckbox));
        if (newsLetterCheckbox.isSelected()) {
            newsLetterCheckbox.click();

    }

    }
    public void prezimeInputFieldSendKeys(String prezime) {
        wdWait.until(ExpectedConditions.visibilityOf(prezimeInputField)).clear();
        prezimeInputField.sendKeys(prezime);
    }

    public void EmailAdresaFieldSendKeys(String email) {
        wdWait.until(ExpectedConditions.visibilityOf(EmailAdresaField)).clear();
        EmailAdresaField.sendKeys(email);
    }
   // public void PravnoLiceField(String pravno) {
      //  wdWait.until()
   // }
    private void firmaInputFieldSendKeys(String firma) {
        wdWait.until(ExpectedConditions.visibilityOf(firmaInputField)).clear();
        firmaInputField.sendKeys(firma);
    }
    private void pibInputFieldSendKeys(String id) {
        wdWait.until((ExpectedConditions.visibilityOf(pibInputField))).clear();
        pibInputField.sendKeys(id);
    }
    public void passwordInputFieldSendKeys(String password) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).clear();
        passwordInputField.sendKeys(password);
    }
    public void confirmationInputFieldSendKeys(String confirmation){
        wdWait.until(ExpectedConditions.visibilityOf(confirmationInputField)).clear();
        confirmationInputField.sendKeys(confirmation);
    }

    public void PošaljiButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(PošaljiButton)).click();


    }

    public void pravnoLiceFieldSelect(String firma, String pib, String pravnoLice) {
        wdWait.until(ExpectedConditions.elementToBeClickable(PravnoLiceDropdown)).click();
        dropdown = new Select(PravnoLiceDropdown);
        dropdown.selectByVisibleText(pravnoLice);

        //Select pravnoLiceSelect = new Select(driver.findElement(By.id("pravnolice")));
       // pravnoLiceSelect.selectByValue("1");
       // pravnoLiceSelect.selectByVisibleText("Da");
       // pravnoLiceSelect.selectByIndex(1);
        firmaInputFieldSendKeys(firma);
        pibInputFieldSendKeys(pib);

    }

    public boolean alertWarningMessageIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(alertWarningMessage));
        return alertWarningMessage.isDisplayed();
    }

    public String alertWarningMessageGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(alertWarningMessage));
        return alertWarningMessage.getText();
    }

    public void sviProizvodiMenuHover() {
        wdWait.until(ExpectedConditions.elementToBeClickable(sviProizvodiMenu));
        actions.moveToElement(sviProizvodiMenu).perform();


    }

    public void BelaTehnikaMenuHover() {
        wdWait.until(ExpectedConditions.elementToBeClickable(belaTehnikaMenu));
        actions.moveToElement(belaTehnikaMenu).perform();
    }

    public void sporetiMenuClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(sporetiMenu)).click();
    }



    }

