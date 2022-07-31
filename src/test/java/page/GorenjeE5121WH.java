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

    @FindBy(xpath = "//span[text()='30.588']")
    WebElement StaraCena;
    @FindBy(xpath = "//span[text()='25.999']")
    WebElement NovaCena;

    public boolean StaraCenaIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(StaraCena));
        return StaraCena.isDisplayed();
    }

    public String StaraCenaGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(StaraCena));
        return StaraCena.getText();

    }

    public boolean NovaCenaIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(NovaCena));
        return NovaCena.isDisplayed();
    }

    public String NovaCenaGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(NovaCena));
        return NovaCena.getText();
    }
}