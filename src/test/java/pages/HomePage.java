package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(partialLinkText = "Logowanie")
    private WebElement signInButton;


    @FindBy(xpath = "//*[@id=\"navbar-top-collapse\"]/ul[2]/li[2]/a")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"navbar-top-collapse\"]/ul[1]/li[2]")
    public WebElement usersButton;

    public void clickOnSignInButton() {
        signInButton.click ();
    }

    public void clickOnSignUpButton() {
        signUpButton.click ();
    }

    public void clickOnUsersButton() {
        usersButton.click ();
    }
}
