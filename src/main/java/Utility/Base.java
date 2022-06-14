package Utility;

import Listeners.TestListners;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    public void setup() {
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        logInfo("------------------------------Setup completed--------------------------------------");
    }

    public static void url() throws IOException {
        driver.get(propertyFile("TestUrl"));
        logInfo("Url launched : "+propertyFile("TestUrl"));
    }

    public static void logInfo(String info){
        try {
            TestListners.testReport.get().info(info);
        } catch (Throwable t) {
            System.out.println(t);
        }
    }

    public static String propertyFile(String key) throws IOException {
        Properties obj = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\Delta.properties");
        obj.load(objfile);
        String data=obj.getProperty(key);
        return data;
    }
    public static String captureScreenshot(String screenshotName) {
        File scrFile = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\reports\\" + screenshotName + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(scrFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
    public static void close(){
        driver.close();
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}