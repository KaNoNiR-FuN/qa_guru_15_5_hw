package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class PracticeFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillAndSubmitFormTest () {
        registrationFormPage.openPage()
                .setFirstName("Dmitry")
                .setLastName("Kharitonov")
                .setEmail("dmitry_kharitonovv@gmail.com")
                .setGender("Male")
                .setNumber("9155951498")
                .setBirthDate("02", "February", "1995")
                .setHobby("Sports")
                .setSubject("Computer Science")
                .uploadPicture("testImage.jpeg")
                .setAddress("Pushkin Street, Kolotushkin house")
                .setStateAndCity("Haryana", "Panipat")
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Dmitry Kharitonov")
                .checkResult("Student Email", "dmitry_kharitonovv@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9155951498")
                .checkResult("Date of Birth", "02 February,1995")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "testImage.jpeg")
                .checkResult("Address", "Pushkin Street, Kolotushkin house")
                .checkResult("State and City", "Haryana Panipat");
    }
}
