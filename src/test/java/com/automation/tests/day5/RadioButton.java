package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        //<input type="radio">
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        // to check if button can be clicked

        for (WebElement radioButton : radioButtons) {

            //<input type = "radio" id="red" name="color">
            String id = radioButton.getAttribute("id");

            // return true of you can click on the button
            boolean isSelected = radioButton.isSelected();
            System.out.println( id +" isSelected ? = " + isSelected);

            // if button is eligible to click
            // returns true of ypu can click on yhe button
            if (radioButton.isEnabled()) {

                radioButton.click();
                BrowserUtils.wait(1);

            }else {
                System.out.println("Button is disabled, not clicked : : " +id);
            }
            System.out.println();
        }

        driver.quit();
    }


}
