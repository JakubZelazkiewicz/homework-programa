package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.SignIn;
import pages.SignUp;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class ProgramaTest {

    private String PAGE_URL = "http://qa-test.programa.pl/";
    private WebDriver driver;

    private HomePage homePage;
    private SignUp signUp;
    private SignIn signIn;

    @Before
    public void setUp() {
        System.setProperty ( "webdriver.gecko.driver", "C:\\IntelliJ\\programa\\src\\test\\java\\drivers\\geckodriver.exe" );

        driver = new FirefoxDriver ();
        driver.manage ().timeouts ().implicitlyWait ( 10, TimeUnit.SECONDS );

        homePage = PageFactory.initElements ( driver, HomePage.class );
        signUp = PageFactory.initElements ( driver, SignUp.class );
        signIn = PageFactory.initElements ( driver, SignIn.class );

        driver.get ( PAGE_URL );
    }

    /**
     * Test checks the posibility of registrationt the same user second time
     **/
    @Test
    public void SignUpNewUserSecondTimeTest() {
        String userPass1 = "Haslo123!";
        String userPass2 = "Haslo123!";
        String userEmail = "uzytkownikkuba@wp.pl";

        homePage.clickOnSignUpButton ();
        signUp.signUpUser ( userEmail, userPass1, userPass2 );

        assertTrue ( signUp.alertText.isDisplayed () );
    }

    /**
     * Test checks if sign in process go in good way
     **/
    @Test
    public void SignInUserTest() {
        String userPass1 = "Haslo123!";
        String userEmail = "uzytkownikkuba@wp.pl";

        homePage.clickOnSignInButton ();
        signIn.signInUser ( userEmail, userPass1 );
        assertTrue ( signIn.wylogujButton.isDisplayed () );
    }


}
