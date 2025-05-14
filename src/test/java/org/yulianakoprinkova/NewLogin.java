package org.yulianakoprinkova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static java.awt.SystemColor.text;
import static java.lang.Thread.sleep;


public class NewLogin {

    //1. URLs
    private static final String REGISTER_PAGE_URL = "http://training.skillo-bg.com:4300/users/register";
    //private static final String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/login";

    private static final String EXPECTED_REG_FORM_HEADER_TEXT = "Sign up";

    String SIGN_UP_FORM_HEADER_XPATH = "//h4";

    //2. Locators
    //2.1 Registration form attributes:
    String NEW_USER_USERNAME_XPATH = "//input[contains(@name,\"username\")]";
    String NEW_USER_EMAIL_XPATH = "//input[contains(@type, \"email\")]";
    String NEW_USER_BIRTHDATE_XPATH = "//input[contains(@formcontrolname, \"birthDate\")]";
    String NEW_USER_PASSWORD_CSS = "#defaultRegisterFormPassword";
    String NEW_USER_CONFIRM_PASSWORD_CSS = "#defaultRegisterPhonePassword";
    String NEW_USER_PUBLIC_INFO_XPATH = "//textarea";
    String NEW_USER_SIGN_IN_BUTTON_CSS = "#sign-in-button";

    //3. When logged in
    // Reg page error messages
    // Reg page layouts
    String PROFILE_BTN_CSS = "#nav-link-profile";

    //4. Driver
    public WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @BeforeMethod
    public void initiateBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(10000);

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void newUserRegistrationTest() throws InterruptedException {

        driver.get(REGISTER_PAGE_URL);
        String actualLoadedUrl = driver.getCurrentUrl();
        Assert.assertEquals(REGISTER_PAGE_URL, actualLoadedUrl);

        WebElement regFormHeader = driver.findElement(By.xpath(SIGN_UP_FORM_HEADER_XPATH));
        String actualregFormHeaderText = regFormHeader.getText();
        Assert.assertEquals(EXPECTED_REG_FORM_HEADER_TEXT, actualregFormHeaderText);

        WebElement newUserNameField = driver.findElement(By.xpath(NEW_USER_USERNAME_XPATH));
        String provideUserName = demoUserName();
        formFillOut(newUserNameField, provideUserName);

        WebElement newUserEmailField = driver.findElement(By.xpath(NEW_USER_EMAIL_XPATH));
        String provideEmail = demoEmail();
        formFillOut(newUserEmailField, provideEmail);

        WebElement newUserBirthdateField = driver.findElement(By.xpath(NEW_USER_BIRTHDATE_XPATH));
        formFillOut(newUserBirthdateField, "07072001");

        String password;
        Random random = new Random();
        password = ("A#a" + random.nextInt(999));

        WebElement newUserPasswordField = driver.findElement(By.cssSelector(NEW_USER_PASSWORD_CSS));
        formFillOut(newUserPasswordField, password);

        WebElement newUserRepeatPasswordField = driver.findElement(By.cssSelector(NEW_USER_CONFIRM_PASSWORD_CSS));
        formFillOut(newUserRepeatPasswordField, password);

        WebElement newUserPublicInfoField = driver.findElement(By.xpath(NEW_USER_PUBLIC_INFO_XPATH));
        String providePublicInfo = "AAaaBBbbCCcc";
        formFillOut(newUserPublicInfoField, providePublicInfo);

        WebElement newUserSigInButton = driver.findElement(By.cssSelector(NEW_USER_SIGN_IN_BUTTON_CSS));
        newUserSigInButton.click();



    }

        public String getCurrentTime() {
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("hhmmss");
            String formattedDateTime = time.format(format);
            return formattedDateTime;
        }

        public String demoUserName () {
            String username = "User" + getCurrentTime();
            return username;
        }

        public String demoEmail () {
            String email = "Pass" + getCurrentTime() + "@mail.com";
            return email;
        }

        public void formFillOut(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        }



    }



