package page;

import base.BaseTest;
import io.github.sukgu.support.ElementFieldDecorator;
import io.github.sukgu.support.FindElementBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.PublicKey;
import java.util.List;

public class SharedMethods extends BaseTest {
    public SharedMethods() {
        ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
        PageFactory.initElements(decorator, this);
    }
    @FindElementBy(css = "#PsCloseButton")
    List<WebElement> popupBanners;
    @FindBy(xpath = "//button[text() = 'Prihvatam']")
    WebElement prihvatamButton;

    public void killAllPopupBanners() throws InterruptedException {
        Thread.sleep(10000);
        for (int i = popupBanners.size(); i > 0; i--) {
            popupBanners.get(i - 1).click();
        }

    }

    public void prihvatamButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(prihvatamButton)).click();
    }
}
