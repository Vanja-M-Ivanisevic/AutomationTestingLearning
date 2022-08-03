package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BekoFSS66000Welektričnišporet extends BaseTest {
    public BekoFSS66000Welektričnišporet() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class='xl65' and text()='Bela']")
    WebElement belaBojaProvera;
    @FindBy(linkText = "Ocene")
    WebElement bekoOcene;

    @FindBy(xpath = "//p[contains(text(),'Kupili smo')]")
    WebElement komentarLjuba;

    public boolean belaBojaProveraIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(belaBojaProvera));
        return belaBojaProvera.isDisplayed();
    }

    public String belaBojaProveraGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(belaBojaProvera));
        return belaBojaProvera.getText();
    }

    public void bekoOceneClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(bekoOcene)).click();
    }

    public boolean komentarLjubaIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(komentarLjuba));
        return komentarLjuba.isDisplayed();
    }

    public String komentarLjubaGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(komentarLjuba));
        return komentarLjuba.getText();
    }
}
