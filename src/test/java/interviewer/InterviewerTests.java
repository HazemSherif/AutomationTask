package interviewer;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.InterviewerPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InterviewerTests extends BaseTests {

    @Test
    public void testNewInterviewerButtonExists (){
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewerPage = dashboardpage.clickInterviewerPage();
        assertTrue(interviewerPage.isNewInterviewerButtonDisplayed(), "New Interviewer button exists");
        assertEquals(interviewerPage.getPageTitle(),"Interviewers", "Interviewers page title is correct");
    }
}
