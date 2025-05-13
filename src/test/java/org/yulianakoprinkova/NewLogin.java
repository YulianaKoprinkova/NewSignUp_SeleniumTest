package org.yulianakoprinkova;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class NewLogin {

    @Test
    public void myNewSkilloUserSeleniumTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/register";

        driver.get (LOGIN_PAGE_URL);

        //UI MAP
        //SIGNUP FORM

        //1.2. USERNAME
        String NEW_USERNAME_INPUT_FIELD_CSS = "#Username";

        //1.3. EMAIL
        String EMAIL_INPUT_FIELD_CSS = "#email";

        //1.3. DOB
        String DOB_INPUT_FIELD_CSS = "#birthDate";

        //1.4. PASSWORD
        String PASSWORD_INPUT_FIELD_CSS = "#password";

        //1.5 CONFIRM PASSWORD
        String CONFIRM_PASSWORD_INPUT_FIELD_CSS = "#confirmPassword";

        //1.6 PUBLIC INFO
        String PUBLIC_INFO_INPUT_FIELD_CSS = "#publicInfo";

        //1.7. SIGN IN BUTTON
        String SIGN_IN_BUTTON_CSS = "#sign-in-button";

        WebElement newUserName = driver.findElement(By.cssSelector(NEW_USERNAME_INPUT_FIELD_CSS));

        newUserName.click();
        Thread.sleep(1000);

        //newUserName.clear();
        //Thread.sleep(1000);

        newUserName.sendKeys("MyFirstName MyLastName");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.cssSelector(EMAIL_INPUT_FIELD_CSS));

        email.click();
        Thread.sleep(1000);

        //email.clear();
        //Thread.sleep(1000);

        email.sendKeys("myemail@provider.com");
        Thread.sleep(1000);

        WebElement birthDate = driver.findElement(By.cssSelector(DOB_INPUT_FIELD_CSS));

        birthDate.click();
        Thread.sleep(1000);

        //birthDate.clear();
        //Thread.sleep(1000);

        birthDate.sendKeys("07/07/2011");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector(PASSWORD_INPUT_FIELD_CSS));
        password.click();
        Thread.sleep(1000);

        //password.clear();
        //Thread.sleep(1000);

        password.sendKeys("MyPass#123");
        Thread.sleep(1000);

        WebElement confirmPassword = driver.findElement(By.cssSelector(CONFIRM_PASSWORD_INPUT_FIELD_CSS));

        confirmPassword.click();
        Thread.sleep(1000);

        //confirmPassword.clear();
        //Thread.sleep(1000);

        confirmPassword.sendKeys("MyPass#123");
        Thread.sleep(1000);

        WebElement publicInfo = driver.findElement(By.cssSelector(PUBLIC_INFO_INPUT_FIELD_CSS));

        publicInfo.click();
        Thread.sleep(1000);

        //publicInfo.clear();
        //Thread.sleep(1000);

        publicInfo.sendKeys("MyPass#123");
        Thread.sleep(1000);

        WebElement signInButton;
        signInButton = driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS));

        signInButton.click();
        Thread.sleep(1000);

        Thread.sleep(13000);

        driver.quit();


    }

}
