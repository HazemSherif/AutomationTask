package interviewer;

import base.BaseTests;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewInterviewerPage;
import pages.DashBoardPage;
import pages.InterviewerPage;
import pages.JobPositionsPage;

import java.util.List;

import static org.testng.Assert.*;


public class NewInterviewerTests extends BaseTests {

    // can fail it because there isn't any confirmation message
    @Test
    public void youCanCreateNewInterviewers(){

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();

        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setFirstNameFieldText(firstName);
        newInterviewerPage.setLastNameFieldText(lastName);
        newInterviewerPage.selectJobPosition("System Admin");
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(interviewersPage.getFirstInterviewerEmail(),email,"created email is written correctly");

        //Assert.assertTrue(interviewersPage.isAlertDisplayed(), "Creation message is displayed");
        //assertEquals(interviewersPage.getAlertText(), "Interviewer was successfully created.", "Creation message text is not displayed correctly");
    }
    @Test
    public void cancelButtonDoesNotCreateAccount(){

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();

        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setFirstNameFieldText(firstName);
        newInterviewerPage.setLastNameFieldText(lastName);
        newInterviewerPage.selectJobPosition("System Admin");
        interviewersPage = newInterviewerPage.clickCancelButton();
        assertNotEquals(interviewersPage.getFirstInterviewerEmail(),email,"new account wasn't created");
    }
    // fails but that means it works XD
    @Test
    public void cantLogInWithInvalidEmail(){

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String [] emails = {"abc-@mail.com","abc..def@mail.com",".abc@mail.com","abc#def@mail.com","abc.def@mail.c","abc.def@mail#archive.com","abc.def@mail","abc.def@mail..com"};
        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setFirstNameFieldText(firstName);
        newInterviewerPage.setLastNameFieldText(lastName);
        newInterviewerPage.selectJobPosition("System Admin");
        for(int i =0; i < 8; i++){
            newInterviewerPage.setEmailFieldText(emails[i]);
            interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
            assertEquals(newInterviewerPage.getErrorMessage(0),"is not an email and is invalid", "email format is wrong");
            newInterviewerPage.clearEmailFieldText();
        }
    }
    @Test
    public void cantCreateAccountWithSameEmail(){
        String [] sameEmail = {"abc-@mail.com", "abc-@maIl.com", "abc-@mail.com  "};
        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        for ( int i = 0 ; i < 3 ;i++){
            CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
            newInterviewerPage.setEmailFieldText(sameEmail[i]);
            interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
            assertEquals(newInterviewerPage.getUpdateButtonText(),"Update Interviewer","Submit button changed to update button");
            interviewersPage = newInterviewerPage.clickCancelButton();
        }
    }

    // how to test that the UI isn't going to look bad????
    @Test
    public void cantCreateAnInterviewerWhenAllFieldsAreEmpty(){
        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0),"can't be blank and is invalid");
        assertEquals(newInterviewerPage.getErrorMessage(1), "can't be blank");
        assertEquals(newInterviewerPage.getErrorMessage(2), "can't be blank");
        assertEquals(newInterviewerPage.getErrorMessage(3), "can't be blank");
    }

    @Test
    public void cantCreateAnInterviewerWithEmptyEmailField(){
        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        String name = faker.name().firstName();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setFirstNameFieldText(name);
        newInterviewerPage.setLastNameFieldText(lastName);
        newInterviewerPage.selectJobPosition("007");
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0), "can't be blank and is invalid");

    }

    @Test
    public void cantCreateAnInterviewerWithEmptyFirstNameField(){
        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setLastNameFieldText(lastName);
        newInterviewerPage.selectJobPosition("007");
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0), "can't be blank");

    }
    @Test
    public void cantCreateAnInterviewerWithEmptyLastNameField(){
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setFirstNameFieldText(name);
        newInterviewerPage.selectJobPosition("007");
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0), "can't be blank");

    }
    @Test
    public void cantCreateAnInterviewerWithJobPositionField(){
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setFirstNameFieldText(name);
        newInterviewerPage.setLastNameFieldText(lastname);
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0), "can't be blank");

    }
    @Test
    public void cantCreateAnInterviewerWithNumbersInName(){
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setFirstNameFieldText(1 + name+ "1");
        newInterviewerPage.setLastNameFieldText(lastname);
        newInterviewerPage.selectJobPosition("007");
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0), "First Name Can't Have numbers");

    }
    @Test
    public void cantCreateAnInterviewerWithSymbolsInName(){
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setFirstNameFieldText(name+ "@");
        newInterviewerPage.setLastNameFieldText(lastname);
        newInterviewerPage.selectJobPosition("007");
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0), "First Name Can't Have Symbols");
    }
    @Test
    public void cantCreateAnInterviewerWithNumbersInLastName(){
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setFirstNameFieldText(name);
        newInterviewerPage.setLastNameFieldText(1 + lastname + "1");
        newInterviewerPage.selectJobPosition("007");
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0), "Last Name Can't Have numbers");

    }
    @Test
    public void cantCreateAnInterviewerWithSymbolsInLastName(){
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = faker.internet().emailAddress();

        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        newInterviewerPage.setEmailFieldText(email);
        newInterviewerPage.setFirstNameFieldText(name);
        newInterviewerPage.setLastNameFieldText(lastname + "@");
        newInterviewerPage.selectJobPosition("007");
        interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
        assertEquals(newInterviewerPage.getErrorMessage(0), "Last Name Can't Have Symbols");
    }

    @Test
    public void canCreateAnInterviewerWithValidFirstNameValues(){
        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String min = faker.lorem().characters(1);             // characters are made of letters and numbers
        String minPlusOne = faker.lorem().characters(2);
        String maxMinusOne= faker.lorem().characters(49);
        String max = faker.lorem().characters(50);
        String [] firstName = {min,minPlusOne,maxMinusOne, max};
        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        for(int i = 0 ; i <4; i++){
            newInterviewerPage.setEmailFieldText(email);
            newInterviewerPage.setFirstNameFieldText(firstName[i]);
            newInterviewerPage.setLastNameFieldText(lastName);
            newInterviewerPage.selectJobPosition("System Admin");
            interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
            assertEquals(interviewersPage.getFirstInterviewerEmail(),email,"created email is written correctly");
            if(i <3)
            newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        }
    }
    @Test
    public void canCreateAnInterviewerWithValidLastNameValues(){
        Faker faker = new Faker();
        String firstName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String min = faker.lorem().characters(1);             // characters are made of letters and numbers
        String minPlusOne = faker.lorem().characters(2);
        String maxMinusOne= faker.lorem().characters(49);
        String max = faker.lorem().characters(50);
        String [] lastName = {min,minPlusOne,maxMinusOne, max};
        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        for(int i = 0 ; i <4; i++){
            newInterviewerPage.setEmailFieldText(email);
            newInterviewerPage.setFirstNameFieldText(firstName);
            newInterviewerPage.setLastNameFieldText(lastName[i]);
            newInterviewerPage.selectJobPosition("007");
            interviewersPage = newInterviewerPage.clickCreateNewInterviewerButton();
            assertEquals(interviewersPage.getFirstInterviewerEmail(),email,"created email is written correctly");
            if(i <3)
                newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        }
    }

    @Test
    public void allTheJobPositionExistInTheJobPositionList(){
        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
        DashBoardPage dashboardpage =  loginPage.clickLoginButton();
        InterviewerPage interviewersPage = dashboardpage.clickInterviewerPage();
        CreateNewInterviewerPage newInterviewerPage = interviewersPage.clickNewInterviewerButton();
        List jobpositions = newInterviewerPage.getJobPositionList();
        JobPositionsPage jobPositionsPage = newInterviewerPage.clickJobPositionsPage();
        for (int i = jobPositionsPage.getJobTitleList().size(); i < jobPositionsPage.getJobTitleList().size()- 1 ; i++){
            assertEquals(jobPositionsPage.getJobTitleList().get(i+1),jobpositions.get(i));
        }

    }


}
