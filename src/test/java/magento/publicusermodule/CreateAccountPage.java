package magento.publicusermodule;

import magento.TestUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends TestUtility {
    @FindBy(id = "firstname")
    WebElement firstNameTextField;
    @FindBy(id = "lastname")
    WebElement lastNameBox;
    @FindBy(css = "#email_address")
    WebElement emailAddress;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(xpath= "//input[@id='password-confirmation']")
    WebElement confirmPasswordField;
    @FindBy(css = "button.action.submit.primary")
    WebElement createAccountSubmit;
    @FindBy(xpath = "//div[@class='message-success success message']")
    WebElement verificationLink;
    @FindBy(name = "is_subscribed")
    WebElement newsletterCheckBox;
}
