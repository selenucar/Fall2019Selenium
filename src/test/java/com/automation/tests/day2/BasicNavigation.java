package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception { // because of Thread.sleep()
        // to start selenium script we need:
        // setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

//        RemoteWebDriver driver = new SafariDriver();
        // In selenium, everything starts from WebDriver interface
        // ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com"); // open a website

        Thread.sleep(3000); // for demo, wait 3 seconds
        // Method that return page title
        // you can also see it as tabe name, in the browser
        String title = driver.getTitle(); // returns <title> Some title</title> text
        String expectedTitle = "Google";
        System.out.println("The title is... "+ title);
        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");
        }

        // must be at the end
        driver.close();// to close browser
        // browser cannot close itself

    }
}
