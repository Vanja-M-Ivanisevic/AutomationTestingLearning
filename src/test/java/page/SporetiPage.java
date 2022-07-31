package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SporetiPage extends BaseTest {
    public SporetiPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text() = 'Električni šporeti']")
    WebElement ElektricniSporeti;


    public void ElektricniSporetiClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(ElektricniSporeti)).click();
    }


}