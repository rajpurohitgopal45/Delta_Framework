package Project;

import Testcases.Testcases;
import Testcases.TestcasesRestAssured;
import org.testng.annotations.Test;

public class Check24 {
    Testcases testcases=new Testcases();
    TestcasesRestAssured restAssured = new TestcasesRestAssured();

    @Test(priority = 1, enabled = true)
    public void execution() throws Exception {
        testcases.openWebsite();
        testcases.verifyCookie();
    }
    @Test(priority = 2, enabled = true)
    public void execution12() throws Exception {
        testcases.clickOnBarclaysVisa();
        testcases.fillEmailAndNext();
        testcases.chooseIchMochte();
    }
    @Test(priority = 3, enabled = false)
    public void execution123() throws Exception {
        testcases.showError();
        testcases.verifyError();
        testcases.fillForm();
    }

    @Test(priority = 4, enabled = false)
    public void restAssured() throws Exception {
        restAssured.firstId();
    }

}