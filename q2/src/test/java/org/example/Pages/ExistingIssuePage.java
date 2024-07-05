package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExistingIssuePage extends BasePage{

    public WebDriver driver;

    @FindBy(xpath = "//*[contains(@aria-label, 'Show options')]")
    private WebElement button;

    @FindBy(xpath = "//*[contains(@class, 'dropdown-item btn-link js-comment-edit-button')]")
    public WebElement editB;

    @FindBy(xpath = "//*[contains(@name, 'issue[body]')]")
    public WebElement issueBodyField;

    @FindBy(xpath = "//span[text()='Update comment']")
    private WebElement updateB;

    @FindBy(xpath = "//*[contains(@class, 'js-issue-title markdown-title')]")
    private WebElement createdIssue;

    @FindBy(xpath = "//*[contains(text(), 'Lock conversation')]")
    private WebElement lockIssueB;

    @FindBy(xpath = "//*[contains(@class, 'btn btn-block')]")
    private WebElement lockIssueSubmit;


    public ExistingIssuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        check();
    }

    public void submitUpdate()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(updateB));
        updateB.click();
    }

    public void lock()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(lockIssueB));
        lockIssueB.click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(lockIssueSubmit));
        lockIssueSubmit.click();
    }

    public void edit()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(button));
        button.click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(editB));
        editB.click();
    }

    public void inputNewDescription()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(issueBodyField));
        issueBodyField.clear();
        issueBodyField.sendKeys("Я нашел новый баг");
    }

    public boolean checkIfIssueCreated()
    {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(createdIssue));
        return element != null;
    }

    @Override
    protected void check() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(button));
        if(button.isDisplayed()) {System.out.println("button is visible");}
    }
}
