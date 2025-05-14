package org.yulianakoprinkova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.lang.Math;

import java.time.Duration;

public class NewLogin {

    //UI MAP
    //SIGNUP FORM
    //

    //1.2. USERNAME
    String NEW_USERNAME_INPUT_FIELD_CSS = "input.form-control[formcontrolname=\"username\"]";

    //1.3. EMAIL
    String EMAIL_INPUT_FIELD_CSS = "input.form-control[formcontrolname=\"email\"]";

    //1.3. DOB
    String DOB_INPUT_FIELD_CSS = "input.form-control[formcontrolname=\"birthDate\"]";

    //1.4. PASSWORD
    String PASSWORD_INPUT_FIELD_CSS = "input.form-control[formcontrolname=\"password\"]";

    //1.5 CONFIRM PASSWOR
    String CONFIRM_PASSWORD_INPUT_FIELD_CSS = "input.form-control[formcontrolname=\"confirmPassword\"]";

    //1.6 PUBLIC INFO
    String PUBLIC_INFO_INPUT_FIELD_CSS = "textarea.form-control[formcontrolname=\"publicInfo\"]";

    //1.7. SIGN IN BUTTON
    String SIGN_IN_BUTTON_CSS = "#sign-in-button";


    private WebDriver driver;


    @BeforeTest
    public void setUpDriver () {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void beforeSeleniumTest () {
        System.out.println("Testing Registration of New User");
    }

    @Test
    public void myNewSkilloUserSeleniumTest() throws InterruptedException {

        String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/register";

        driver.get (LOGIN_PAGE_URL);

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(2000));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        WebElement newUserName = driver.findElement(By.cssSelector(NEW_USERNAME_INPUT_FIELD_CSS));

        newUserName.click();
        newUserName.clear();
        newUserName.sendKeys("Name Name");

        WebElement email = driver.findElement(By.cssSelector(EMAIL_INPUT_FIELD_CSS));

        email.click();
        email.clear();
        email.sendKeys("myemail@provider.com");

        WebElement birthDate = driver.findElement(By.cssSelector(DOB_INPUT_FIELD_CSS));
        birthDate.click();
        birthDate.clear();
        birthDate.sendKeys("07/07/2011");

        WebElement password = driver.findElement(By.cssSelector(PASSWORD_INPUT_FIELD_CSS));
        password.click();
        password.clear();

        double rand = Math.random();
        password.sendKeys("A" + rand);

        WebElement confirmPassword = driver.findElement(By.cssSelector(CONFIRM_PASSWORD_INPUT_FIELD_CSS));
        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys("A" + rand);

        WebElement publicInfo = driver.findElement(By.cssSelector(PUBLIC_INFO_INPUT_FIELD_CSS));
        publicInfo.click();
        publicInfo.clear();
        publicInfo.sendKeys("?Public Info?");

        WebElement signInButton;
        signInButton = driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS));
        signInButton.click();

        driver.quit();

    }

    public void textIntoElementCSS(String webElementLocator, String text) throws InterruptedException {

        Thread.sleep(1000);

        String locator = "input.form-control[formcontrolname=\"" + webElementLocator + " \"]";

        if (driver.findElement(By.cssSelector(locator)).isDisplayed()) {

            WebElement element = driver.findElement(By.cssSelector(locator));

            System.out.println("The web element was found " + webElementLocator);

            element.click();
            element.clear();
            element.sendKeys(text);

        } else {

            System.out.println("The web element was not  found ");
        }

        System.out.println("The user has provided text: " + text);


  }

    @AfterTest
    public void afterSeleniumTest () {
        System.out.println("New Registration Test Was Executed");
    }

}
