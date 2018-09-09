package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Users {

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/table/thead/tr[1]/td[1]/input")
    private WebElement emailField;

    @FindBy(name = "firstname")
    private WebElement firstNameField;

    @FindBy(name = "lastname")
    private WebElement lastNameField;

    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private WebElement filterResult;

    public void filterByEmail(String email) {
        emailField.sendKeys ( email );
        firstNameField.click ();
    }


}
