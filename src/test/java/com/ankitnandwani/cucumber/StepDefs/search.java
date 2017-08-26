package com.ankitnandwani.cucumber.StepDefs;

import com.ankitnandwani.cucumber.Browser;
import com.ankitnandwani.cucumber.Hooks;
import com.ankitnandwani.cucumber.Repo.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by mac on 25/05/17.
 */
public class search{

    private WebDriver driver;
    private Browser browser;
    private HomePage homePage;

    public search(Browser browser){
        this.browser = browser;
    }

    Hooks hooks = new Hooks();

    @Given("^I'm at duckduckgo homepage$")
    public void imAtDuckduckgoHomepage(){
        driver = browser.getDriver();
        homePage = browser.getHomePage();
        driver.get("http://www.duckduckgo.com");
    }

    @When("^I enter (.*) in search bar$")
    public void iEnterInSearchBar(String keyword){
        homePage.getSearchBar().sendKeys(keyword);
        homePage.getSearchButton().click();

    }

    @Then("^Search results should be displayed$")
    public void searchResultsShouldBeDisplayed(){
        Assert.assertTrue(homePage.getResultOne().isDisplayed());
    }

    @Then("^(.*) text should be displayed$")
    public void textShouldBeDisplayed(String text){
        String actual;
        switch (text) {
            case "We don’t store your personal information. Ever." :
                actual = homePage.getHomePageText().get(0).getText();
                break;

            case "Our privacy policy is simple: we don’t collect or share any of your personal information." :
                actual = homePage.getHomePageText().get(1).getText();
                break;

            case "We don’t follow you around with ads." :
                actual = homePage.getHomePageText().get(2).getText();
                break;

            case "We don’t store your search history. We therefore have nothing to sell to advertisers that track you across the internet." :
                actual = homePage.getHomePageText().get(3).getText();
                break;

            case "We don’t track you in or out of private browsing mode." :
                actual = homePage.getHomePageText().get(4).getText();
                break;

            case "Other search engines track your searches even when you’re in private browsing mode. We don’t track you — period." :
                actual = homePage.getHomePageText().get(5).getText();
                break;

            case "Switch to DuckDuckGo and take back your privacy!" :
                actual = homePage.getHomePageText().get(6).getText();
                break;

            case "No tracking, no ad targeting, just searching." :
                actual = homePage.getHomePageText().get(7).getText();
                break;

            default :
                actual = "";
                break;
        }
        Assert.assertEquals(text,actual);
    }
}