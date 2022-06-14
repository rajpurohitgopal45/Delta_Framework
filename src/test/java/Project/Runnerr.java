package Project;

import Testcases.Testcases;
import Testcases.TestcasesRestAssured;
import org.testng.annotations.Test;

public class Runnerr {
    Testcases testcases=new Testcases();
    TestcasesRestAssured restAssured = new TestcasesRestAssured();

    @Test(priority = 1, enabled = true)
    public void verifyCookie() throws Exception {
        testcases.openWebsite();
        testcases.verifyCookie();
    }
    @Test(priority = 2, enabled = true)
    public void enterEmail() throws Exception {
        testcases.clickOnBarclaysVisa();
        testcases.fillEmailAndNext();
        testcases.chooseIchMochte();
    }
    @Test(priority = 3, enabled = true)
    public void fillForm() throws Exception {
        testcases.showError();
        testcases.verifyError();
        testcases.fillForm();
    }

    @Test(priority = 4, enabled = true)
    public void restAssured() throws Exception {
        restAssured.firstId();
    }

}