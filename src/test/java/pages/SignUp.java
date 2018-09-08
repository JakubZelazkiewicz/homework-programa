package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp {

    @FindBy(id = "user-email")
    private WebElement userEmailField;

    @FindBy(name = "user-login-email[password][password]")
    private WebElement passField;

    @FindBy(name = "user-login-email[password][password_repeat]")
    private WebElement passFieldRepeat;

    @FindBy(name = "user-login-email[submit]")
    private WebElement submitButton;

    public void signUpUser(String userEmail, String userPass1, String userPass2) {
        userEmailField.sendKeys ( userEmail );
        passField.sendKeys ( userPass1 );
        passFieldRepeat.sendKeys ( userPass2 );
        submitButton.click ();
    }

    @FindBy(css = ".alert")
    public WebElement alertText;

}