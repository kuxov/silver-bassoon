package org.example.Tests;

import io.qameta.allure.Step;
import org.example.Pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase extends BaseTest {

    @Test
    @DisplayName("test case :)")
    public void testValidData() throws InterruptedException {

        step1();
        step2();
        step3();
        step4();
        step6();
        step7();
    }

    @Step("Step 1 - login")
    void step1() {
        login();
    }

    @Step("Step 2 - from Main page to Repository page")
    void step2() {
        InitPage initPage= new InitPage(driver);
        initPage.goToRepoPage();
    }

    @Step("Step 3 - to Create issue page")
    void step3() {
        RepoPage repoPage = new RepoPage(driver);
        repoPage.goToIssuesPage();
        IssuesPage issuesPage = new IssuesPage(driver);
        issuesPage.createIssue();
    }

    @Step("Step 4 - creating issue")
    void step4() {
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        newIssuePage.inputTitle();
        newIssuePage.inputDescription();
        newIssuePage.submit();
        newIssuePage.assign();
    }

    @Step("Step 5 - check if created correctly")
    void step5(){
        ExistingIssuePage existingIssuePage = new ExistingIssuePage(driver);
        assertTrue(existingIssuePage.checkIfIssueCreated());
    }

    @Step("Step 6 - update issue")
    void step6(){
        ExistingIssuePage existingIssuePage = new ExistingIssuePage(driver);
        existingIssuePage.edit();
        existingIssuePage.inputNewDescription();
        existingIssuePage.submitUpdate();
    }

    @Step("Step 7 - lock issue")
    void step7(){
        ExistingIssuePage existingIssuePage = new ExistingIssuePage(driver);
        existingIssuePage.lock();
    }
}
