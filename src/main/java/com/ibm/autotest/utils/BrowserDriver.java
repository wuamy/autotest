package com.ibm.autotest.utils;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by wu on 4/1/2017.
 */
public class BrowserDriver {
    private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());
    private static WebDriver mDriver;

    public synchronized static WebDriver getCurrentDriver(){
        if (mDriver == null){
            try {
                mDriver = new FirefoxDriver(new FirefoxProfile());
            } finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new BrowserCleanup()));
            }
        }
        return mDriver;
    }

    private static class BrowserCleanup implements Runnable{
        public void run(){
            LOGGER.info("Closing the browser");
            close();
        }
    }

    public static void close(){
        try {
            getCurrentDriver().quit();
            mDriver = null;
            LOGGER.info("closing the browser");
        } catch (UnreachableBrowserException e){
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }

    // loading page
    public static void loadPage(String url){
        LOGGER.info("Directing browser to: " + url);
        getCurrentDriver().get(url);
    }

    public static WebElement waitForElement(WebElement elementToWaitFor){
        return waitForElement(elementToWaitFor, null);
    }

    public static WebElement waitForElement(WebElement elementToWaitFor, Integer waitTimeInSeconds){
        if (waitTimeInSeconds == null){
            waitTimeInSeconds = 20;
        }

        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), waitTimeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }

    public static WebElement getParent(WebElement element) {
        return element.findElement(By.xpath(".."));
    }
}
