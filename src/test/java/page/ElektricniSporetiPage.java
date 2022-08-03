package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElektricniSporetiPage extends BaseTest {
    public ElektricniSporetiPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[text()=\"Gorenje\"]")
    WebElement GorenjeCheckbox;

    @FindBy (linkText = "Gorenje E5121WH električni šporet")
    WebElement GorenjeSporet;

    @FindBy (xpath = "//label[text()='Beko']")
    WebElement bekoCheckbox;

    @FindBy(partialLinkText = "Beko FSS66000W električni šporet")
    WebElement bekoElektricniSporet;


    public void GorenjeCheckboxSelect() {
        wdWait.until(ExpectedConditions.elementToBeClickable(GorenjeCheckbox)).click();

        }
        public void GorenjeSporetClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(GorenjeSporet)).click();
        }

        public void bekoCheckboxClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(bekoCheckbox)).click();
        }

        public void bekoElektricniSporetClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(bekoElektricniSporet)).click();
        }
    }

