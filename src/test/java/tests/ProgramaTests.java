package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.SignIn;
import pages.SignUp;
import pages.Users;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class ProgramaTests {

    private String PAGE_URL = "http://qa-test.programa.pl/";
    private WebDriver driver;

    private HomePage homePage;
    private SignUp signUp;
    private SignIn signIn;
    private Users users;

    @Before
    public void setUp() {
        System.setProperty ( "webdriver.gecko.driver", "C:\\IntelliJ\\programa\\src\\test\\java\\drivers\\geckodriver.exe" );

        driver = new FirefoxDriver ();
        driver.manage ().timeouts ().implicitlyWait ( 10, TimeUnit.SECONDS );

        homePage = PageFactory.initElements ( driver, HomePage.class );
        signUp = PageFactory.initElements ( driver, SignUp.class );
        signIn = PageFactory.initElements ( driver, SignIn.class );
        users = PageFactory.initElements ( driver, Users.class );

        driver.get ( PAGE_URL );
    }

    /**
     * Test checks the posibility of registrationt the same user second time
     **/
    @Test
    public void signUpNewUserSecondTimeTest() {
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
    public void signInUserTest1() {
        String userPass1 = "Haslo123!";
        String userEmail = "uzytkownikkuba@wp.pl";

        homePage.clickOnSignInButton ();
        signIn.signInUser ( userEmail, userPass1 );
        assertTrue ( signIn.wylogujButton.isDisplayed () );
    }

    /**
     * Test checks if sign in process go in good way
     **/
    @Test
    public void signInUserTest2() {
        String userPass1 = "Haslo32!";
        String userEmail = "uzytkownikkuba@wp.pl";

        homePage.clickOnSignInButton ();
        signIn.signInUser ( userEmail, userPass1 );
        assertTrue ( signIn.alertText.isDisplayed () );
        // CHECK CSS // System.out.println (signIn.alertText.getText () );
    }

    /**
     * Test checks how does filter work.
     **/

    @Test
    public void filterTest1() {
        String userPass1 = "Haslo123!";
        String userEmail = "uzytkownikkuba@wp.pl";
        String email = "b7201041@nwytg.net";

        homePage.clickOnSignInButton ();
        signIn.signInUser ( userEmail, userPass1 );
        //driver.manage ().timeouts ().implicitlyWait ( 5, TimeUnit.SECONDS );
        assertTrue ( homePage.usersButton.isDisplayed () );
        homePage.clickOnUsersButton ();
        users.filterByEmail ( email );
        assertEquals ( email, users.userInTest.getText () );

    }

    @After
    public void tearDown() {
        driver.close ();
    }

}
