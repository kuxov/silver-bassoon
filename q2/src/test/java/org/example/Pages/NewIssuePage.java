package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewIssuePage extends BasePage{

    public WebDriver driver;

    @FindBy (xpath = "//*[@id=\"issue_title\"]")
    private WebElement issueTitleField;

    @FindBy (xpath = "//*[@id=\"issue_body\"]")
    private WebElement issueBodyField;

    @FindBy(xpath = "//*[contains(text(), 'Submit new issue')]")
    public WebElement submitB;

    @FindBy(xpath = "//*[contains(text(), 'assign yourself')]")
    public WebElement assignRef;

    public NewIssuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        check();
    }

    public void inputTitle()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(issueTitleField));
        issueTitleField.sendKeys("Issue1");
    }

    public void inputDescription()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(issueBodyField));
        issueBodyField.sendKeys("Я нашел баг");
    }

    public void assign()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(assignRef));
        assignRef.click();
    }

    public void submit()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(submitB));
        submitB.click();
    }

    @Override
    protected void check() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(issueTitleField));
        if(issueTitleField.isDisplayed()) {System.out.println("issueTitleField is visible");}
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(issueBodyField));
        if(issueBodyField.isDisplayed()) {System.out.println("issueBodyField is visible");}
    }
}