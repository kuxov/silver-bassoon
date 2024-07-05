package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RepoPage extends BasePage{

    public WebDriver driver;

    @FindBy (xpath = "//*[@id=\"issues-tab\"]")
    private WebElement issuePageB;

    public RepoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        check();
    }

    public void goToIssuesPage() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(issuePageB));
        issuePageB.click(); }

    @Override
    protected void check() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(issuePageB));
        if(issuePageB.isDisplayed()) {System.out.println("issuePageB is visible");}
    }
}
