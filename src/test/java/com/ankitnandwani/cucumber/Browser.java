package com.ankitnandwani.cucumber;


import com.ankitnandwani.cucumber.Repo.HomePage;
import com.ankitnandwani.cucumber.StepDefs.search;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

/**
 * Created by mac on 25/08/17.
 */
public class Browser {

    private WebDriver driver;
    private Properties prop;
    private HomePage homePage;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","/Users/mac/IdeaProjects/CucumberPrototype/src/test/Resources/Drivers/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);

    }

    public WebDriver getDriver(){
        return driver;
    }

    public Properties getProp(){
        return prop;
    }

    public HomePage getHomePage(){
        return homePage;
    }

    //@After
    public void tearDown(){
        driver.quit();
    }


}
