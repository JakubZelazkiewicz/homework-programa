package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(partialLinkText = "Logowanie")
    private WebElement signInButton;


    @FindBy(xpath = "/html/body/div[1]/div/div[2]/ul[2]/li[2]/a")
    private WebElement signUpButton;

    public void clickOnSignInButton() {
        signInButton.click ();
    }

    public void clickOnSignUpButton() {
        signUpButton.click ();
    }
}
