package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        check();
    }

    @FindBy(xpath = "//*[contains(@id, 'login_field')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@value, 'Sign in')]")
    private WebElement loginBtn;

    @FindBy (xpath = "//*[@id=\"password\"]")
    private WebElement passwdField;

    public LoginPage inputLogin(String login) {
        loginField.sendKeys(login);
    return this;
    }

    public LoginPage inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    return this;}

    public void clickLoginBtn() {
        loginBtn.click();
    }

    @Override
    protected void check() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(loginBtn));
        if(loginBtn.isDisplayed()) {System.out.println("login button is visible");}

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(passwdField));
        if(passwdField.isDisplayed()) {System.out.println("login field is visible");}

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(loginField));
        if(loginField.isDisplayed()) {System.out.println("password field is visible");}

        System.out.println("\n");
    }
}
