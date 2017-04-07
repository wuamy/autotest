package com.ibm.autotest.utils;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ibm.autotest.constants.Browsers;

/**
 * Created by wu on 4/2/2017.
 */
public class BrowserFactory {

    private static final String BROWSER_PROP_KEY = "browser";

    public static WebDriver getBrowser(){
        Browsers browser;
        WebDriver driver;

        if (System.getProperty(BROWSER_PROP_KEY) == null){
            browser = Browsers.FIREFOX;
        } else{
            browser = Browsers.browserForName(System.getProperty(BROWSER_PROP_KEY));
        }
        switch (browser){
            case CHROME:
                driver = createChromeDrive();
                break;
            case IE:
                driver = createIEDriver();
                break;
            case FIREFOX:
                default:
                    driver = createFirefoxDriver();
                    break;
        }
        addAllBrowserSetup(driver);
        return driver;
    }

    private static WebDriver createChromeDrive(){
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver.exe");
        return new ChromeDriver();
    }

    private static WebDriver createIEDriver(){
        System.setProperty("webdriver.ie.driver", "C:\\seleniumdriver\\IEDriverServer.exe");
        return new InternetExplorerDriver();
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver(new FirefoxProfile());
    }

    private static void addAllBrowserSetup(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(dim);
    }
}