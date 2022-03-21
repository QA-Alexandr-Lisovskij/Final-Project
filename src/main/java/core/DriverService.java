package core;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Browsers.CHROME;
import static constant.Urls.BASE_URL;

public class DriverService {

    public static void initDriver() {

        // Set settings for selenide browser
        Configuration.baseUrl = BASE_URL;
        Configuration.browser = CHROME;
        Configuration.headless = true;
        Configuration.assertionMode = SOFT;

        
    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void refresh() {
        Selenide.refresh();
    }

    public static void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor)currentDriver();
        try {
            js.executeScript(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean waitForUrlContains(String urlChunk) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), 15);
        return wait.until(ExpectedConditions.urlContains(urlChunk));
    }

    public static void waitForUrlDoesNotContain(String urlChunk) {
        int maxTime = 40;
        while(  currentDriver().getCurrentUrl().contains(urlChunk)  && maxTime > 0) {
            wait(1);
            maxTime--;
        }
    }

    public static void maximize() {
        currentDriver().manage().window().maximize();
    }

    public static void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }


    public static void close() {
        currentDriver().quit();
    }

    public static void wait(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<LogEntry> getBrowserLogs() {
        LogEntries log = currentDriver().manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;
    }

    // COOKIES


    public static void deleteCookie(String cookieName) {
        currentDriver().manage().deleteCookieNamed(cookieName);
    }

}
