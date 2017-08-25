package com.ankitnandwani.cucumber.StepDefs;

import com.ankitnandwani.cucumber.Browser;
import com.ankitnandwani.cucumber.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * Created by mac on 25/05/17.
 */
public class search{

    WebDriver driver;
    Browser browser;

    public search(Browser browser){
        this.browser = browser;
    }


    Hooks hooks = new Hooks();

    @Given("^I'm at duckduckgo homepage$")
    public void imAtDuckduckgoHomepage(){
        driver = browser.getDriver();
        driver.get("http://www.duckduckgo.com");
    }

    @When("^I enter (.*) in search bar$")
    public void iEnterInSearchBar(String keyword){
        System.out.println("Enter Keyword : " + keyword);

    }

    @Then("^Search results should be displayed$")
    public void searchResultsShouldBeDisplayed(){
        System.out.println("Results Displayed");

    }
}
