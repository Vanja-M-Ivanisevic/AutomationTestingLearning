package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BaseTest {
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".alert-success")
    WebElement successfulRegistrationMessage;
    @FindAll({
            @FindBy(css =".alert-success" )
    }) List<WebElement> successfulRegistrationMessageList;


    public boolean successfulRegistrationMessageIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationMessage));
        return successfulRegistrationMessage.isDisplayed();
    }

    public String successfulRegistrationMessageGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationMessage));
         return successfulRegistrationMessage.getText();

    }
    public boolean SuccessfulRegistrationMessageListIsEmpty() {
          return successfulRegistrationMessageList.isEmpty();
    }

    }



