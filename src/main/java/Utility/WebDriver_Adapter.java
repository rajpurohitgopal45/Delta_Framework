package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class WebDriver_Adapter extends Base {

    public static void waitOnClick(By locator) {
        new WebDriverWait(driver, 60).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitInvisibility(By locator) {
        new WebDriverWait(driver, 60).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static void move_to_element_click(By locator) {
        WebElement btn = driver.findElement(locator);
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(btn)
                .click().build();
        mouseOverHome.perform();
    }

    public static void waitVisibilityOfElement(By locator) {
        new WebDriverWait(driver, 60).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void click(By locator) {
        new WebDriverWait(driver, 100).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static void type(By locator, String data) {
        new WebDriverWait(driver, 100).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
        logInfo("------ value entered: "+data);
    }

    public static boolean isElementPresent(By element) {
        try {
            driver.findElement(element).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void click_javaScript(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void verifyError(String error){
        if(WebDriver_Adapter.isElementPresent(By.xpath("//*[text()='"+error+"']"))==true){
            logInfo("------ error present : "+error);
        }else {
            logInfo("------ error not present : "+error);
        }}

    public static void cookieVerify() throws IOException {
    Cookie cookieval = driver.manage().getCookieNamed(propertyFile("cookieKey"));
        if (cookieval.getValue().equalsIgnoreCase(propertyFile("cookieValue"))) {
        logInfo("------ cookie set to "+propertyFile("cookieKey")+"="+propertyFile("cookieValue"));
    }else {
        logInfo("------ Error : cookie not set to "+propertyFile("cookieKey")+"="+propertyFile("cookieValue"));
    }}

    public static void lastPageCheck(){
        if(WebDriver_Adapter.isElementPresent(Page_Object_Reader.getElement("err"))==true){
            logInfo("------ error present at last page ");
        }else {
            logInfo("------ error not present at last page  ");
        }}
}