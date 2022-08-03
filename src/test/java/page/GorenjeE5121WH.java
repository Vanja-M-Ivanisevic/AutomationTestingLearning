package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GorenjeE5121WH extends BaseTest {
    public GorenjeE5121WH() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='30.588 ']")
    WebElement staraCena;
    @FindBy(xpath = "//span[text()='25.999']")
    WebElement novaCena;

    public boolean staraCenaIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(staraCena));
        return staraCena.isDisplayed();
    }

    public String staraCenaGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(staraCena));
        return staraCena.getText();

    }

    public boolean novaCenaIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(novaCena));
        return novaCena.isDisplayed();
    }

    public String novaCenaGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(novaCena));
        return novaCena.getText();
    }
}