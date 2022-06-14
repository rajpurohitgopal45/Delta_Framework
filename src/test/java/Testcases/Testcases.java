package Testcases;

import Utility.Base;
import Utility.Page_Object_Reader;
import Utility.WebDriver_Adapter;

public class Testcases extends Base {

    public void openWebsite() throws Exception {
        setup();
        Base.url();
    }
    public void verifyCookie() throws Exception {
        WebDriver_Adapter.cookieVerify();
    }
    public void clickOnBarclaysVisa() {
        WebDriver_Adapter.click(Page_Object_Reader.getElement("btnYes"));
        WebDriver_Adapter.waitInvisibility(Page_Object_Reader.getElement("btnYes"));

        WebDriver_Adapter.waitVisibilityOfElement(Page_Object_Reader.getElement("btnweiter1"));
        WebDriver_Adapter.click(Page_Object_Reader.getElement("btnweiter1"));
        logInfo("---------- click on weiter button of Barclay visa  ");
    }
    public void fillEmailAndNext() throws Exception {
        WebDriver_Adapter.type(Page_Object_Reader.getElement("txtEmail"), propertyFile("email"));
        WebDriver_Adapter.click_javaScript(Page_Object_Reader.getElement("btnweiter2"));
        logInfo("---------- email entered and click on weiter ");
    }
    public void chooseIchMochte() {
        WebDriver_Adapter.waitOnClick(Page_Object_Reader.getElement("checkIchMochte"));
        WebDriver_Adapter.click_javaScript(Page_Object_Reader.getElement("checkIchMochte"));

        WebDriver_Adapter.click_javaScript(Page_Object_Reader.getElement("btnweiter3"));
        logInfo("---------- click on Ich Mochte ");
    }
    public void showError() {
        WebDriver_Adapter.waitOnClick(Page_Object_Reader.getElement("btnweiter4"));
        WebDriver_Adapter.click_javaScript(Page_Object_Reader.getElement("btnweiter4"));
        logInfo("---------- error display successfully ");
    }

    public void verifyError(){
        WebDriver_Adapter.verifyError("Bitte wählen Sie Ihre Anrede aus.");
        WebDriver_Adapter.verifyError("Bitte geben Sie Ihren Vornamen an.");
        WebDriver_Adapter.verifyError("Bitte geben Sie Ihren Nachnamen an.");
        WebDriver_Adapter.verifyError("Bitte geben Sie Ihr Geburtsdatum an.");
        WebDriver_Adapter.verifyError("Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.");
    }
    public void fillForm() throws Exception {

        WebDriver_Adapter.click(Page_Object_Reader.getElement("male"));
        WebDriver_Adapter.type(Page_Object_Reader.getElement("firstName"),propertyFile("name"));
        WebDriver_Adapter.type(Page_Object_Reader.getElement("lastName"),propertyFile("surname"));
        WebDriver_Adapter.type(Page_Object_Reader.getElement("dob"),propertyFile("dob"));
        WebDriver_Adapter.type(Page_Object_Reader.getElement("phone"),propertyFile("phone"));
        WebDriver_Adapter.click_javaScript(Page_Object_Reader.getElement("btnweiter5"));
        logInfo("---------- Execution completed ");
        WebDriver_Adapter.waitVisibilityOfElement(Page_Object_Reader.getElement("lastPage"));
        WebDriver_Adapter.lastPageCheck();
    }
}