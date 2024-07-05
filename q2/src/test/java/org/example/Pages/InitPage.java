package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InitPage extends BasePage{

    public WebDriver driver;

    @FindBy(css = "a[href*='/kuxov/StepikFinal']")
    private WebElement repoLink;

    public InitPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        check();
    }

    public void goToRepoPage() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(repoLink));
        repoLink.click(); }

    @Override
    protected void check() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(repoLink));
        if(repoLink.isDisplayed()) {System.out.println("New Issue button is visible");}
    }
}
