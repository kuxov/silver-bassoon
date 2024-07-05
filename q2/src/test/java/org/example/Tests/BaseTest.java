package org.example.Tests;

import org.example.Pages.LoginPage;
import org.example.Utils.ConfProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));

    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    public void login()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputLogin(ConfProperties.getProperty("login"))
                .inputPasswd(ConfProperties.getProperty("password"))
                .clickLoginBtn();
    }
}
