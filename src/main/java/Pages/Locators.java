package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {
    @FindBy(xpath="//a[text()='Akzeptieren']")
    public WebElement btnYes;

    @FindBy (xpath="//span[text()='1.']/parent::div/following-sibling::div[2]/div[3]/a")
    public WebElement btnweiter1;

    @FindBy (xpath="//*[@id='cl_login']")
    public WebElement txtEmail;

    @FindBy (xpath="//*[text()=' weiter ']/parent::button")
    public WebElement btnweiter2;

    @FindBy (xpath="//*[text()='Ich möchte als Gast fortfahren']")
    public WebElement checkIchMochte;

    @FindBy (xpath="//*[@id='c24-uli-register-btn']")
    public WebElement btnweiter3;

    @FindBy (xpath="//*[text()='weiter']")
    public WebElement btnweiter4;

    @FindBy (xpath="//*[text()='Herr']")
    public WebElement male;

    @FindBy (xpath="//*[@id='GIVEN_NAME']")
    public WebElement firstName;

    @FindBy (xpath="//*[@id='LAST_NAME']")
    public WebElement lastName;

    @FindBy (xpath="//*[@id='DATE_OF_BIRTH']")
    public WebElement dob;

    @FindBy (xpath="//*[@id='PHONENUMBER_MOBILE']")
    public WebElement phone;

    @FindBy (xpath="//a[text()='weiter']")
    public WebElement btnweiter5;

    @FindBy (xpath="//h2[text()='Weitere persönliche Angaben']")
    public WebElement lastPage;

    @FindBy (xpath="//div[@type='ERROR']")
    public WebElement err;

}
