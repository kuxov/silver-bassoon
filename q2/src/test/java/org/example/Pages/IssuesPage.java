package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssuesPage extends BasePage{

    public WebDriver driver;

    @FindBy(xpath = "//span[text()='New issue']")
    private WebElement newIssueB;

    public IssuesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        check();
    }



    public void createIssue() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(newIssueB));
        newIssueB.click(); }

    @Override
    protected void check() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(newIssueB));
        if(newIssueB.isDisplayed()) {System.out.println("New Issue button is visible");}
    }
}
