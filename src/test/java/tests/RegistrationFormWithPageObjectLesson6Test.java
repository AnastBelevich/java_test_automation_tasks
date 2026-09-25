package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectLesson6Test {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

  RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fullFillFormTest() {

        registrationPage.openPage()
                .inputFirstName("Anastasiia")
                .inputLastName("Belevich")
                .inputEmail("nasti@mail.ru")
                .inputgender("Female")
                .inputNumber("1234567895")
                .inputDateOfBirthday("April", "1990", "22")
                .inputSubjects("тема")
                .selectHobbyes("Reading")
                .selectHobbyes("Music")
                .addImg("img/cat.jpg")
                .addAddress("Адрес")
                .selectStateAndCity("Haryana","Karnal")
                .submit()
                .checkModalAppeared()
                .checkResult("Student Name", "Anastasiia Belevich")
                .checkResult("Student Email", "nasti@mail.ru")

                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567895")
                .checkResult("Date of Birth", "22 April,1990")

                .checkResult("Hobbies", "Reading, Music")
                .checkResult("Picture", "cat.jpg")
                .checkResult("Address", "Адрес")
                .checkResult("State and City", "Haryana Karnal")
                ;


    }


    @Test
    void minFillFormTest() {
        registrationPage.openPage()
                .inputFirstName("Anastasiia")
                .inputLastName("Belevich")
                .inputgender("Female")
                .inputNumber("1234567895")
                .inputDateOfBirthday("April", "1990", "22")
                .submit()
                .checkModalAppeared()
                .checkResult("Student Name", "Anastasiia Belevich")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567895")
                .checkResult("Date of Birth", "22 April,1990")
        ;

    }


    @Test
    void notFillFormTest() {
        registrationPage.openPage()
                .submit()
                .checkModalNotAppeared();


        }
    //bs-form-valid-border-color: #198754;
    //bs-form-invalid-border-color: #dc3545;

}
