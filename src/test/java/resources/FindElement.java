package resources;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FindElement {
    public String URL = "https://p5013.prometeus.ru/close/default.asp";
    public String adminUserLogin = "p5013admin";
    public String studentUserLogin = "p5013student";
    public String password = "je56dw3";

    public void loginUser(String login, String password) {
        Configuration.browser = "chrome";
        open("https://" + login + ":" + password + "@p5013.prometeus.ru/close/redirect.asp");
    }

    public WebElement findElementInLeftFrame(By by) {
        switchTo().innerFrame("leftFrame");

        WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));

        return switchTo().innerFrame("leftFrame").findElement(by);
    }

    public WebElement findElementInTopFrame(By by){
        switchTo().innerFrame("topFrame");
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return switchTo().innerFrame("topFrame").findElement(by);
    }

    public WebElement findElementInMainFrame(By by) {
        switchTo().innerFrame("mainFrame");
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return switchTo().innerFrame("mainFrame").findElement(by);
    }
}
