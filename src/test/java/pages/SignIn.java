package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;

public class SignIn {

    @FindBy(id = "user-email")
    private WebElement userEmailField;

    @FindBy(id = "user-password")
    private WebElement passField;

    @FindBy(partialLinkText = "Wyloguj")
    public WebElement wylogujButton;

    @FindBy(css = ".alert")
    public WebElement alertText;

    public void signInUser(String userEmail, String userPass1) {
        userEmailField.sendKeys ( userEmail );
        passField.sendKeys ( userPass1 );
        passField.submit ();

    }
}
