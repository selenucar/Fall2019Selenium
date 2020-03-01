package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        // every window has some ID, this ID calls window handle
        // based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
        // getWindowHandles() - returns ID's of all currently opened windows
        // Set - doesn't allow duplicates
        Set<String> windowHandles = driver.getWindowHandles();


        System.out.println(windowHandles);
        System.out.println("BEFORE SWITCH : " + driver.getCurrentUrl());

        // since we have all windows
        // and we know ID of original window
        // we can say switch to something that is not equals to old window ID
        for (String windowId: windowHandles){
            // if it's not an old window, then switch
            if (!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("AFTER SWITCH : " + driver.getCurrentUrl());

        driver.close();
    }
}
