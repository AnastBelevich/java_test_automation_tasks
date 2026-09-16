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
                .inputNumber("1234567895");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("тема");
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath("img/cat.jpg");
        $("#currentAddress").setValue("Адрес");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $$("tbody tr").findBy(text("Student Name")).shouldHave(text("Anastasiia Belevich"));
        $$("tbody tr").findBy(text("Student Email")).shouldHave(text("nasti@mail.ru"));
        $$("tbody tr").findBy(text("Gender")).shouldHave(text("Female"));
        $$("tbody tr").findBy(text("Mobile")).shouldHave(text("1234567895"));
        $$("tbody tr").findBy(text("Date of Birth")).shouldHave(text("15 April,1990"));
        $$("tbody tr").findBy(text("Hobbies")).shouldHave(text("Reading, Music"));
        $$("tbody tr").findBy(text("Picture")).shouldHave(text("cat.jpg"));
        $$("tbody tr").findBy(text("Address")).shouldHave(text("Адрес"));
        $$("tbody tr").findBy(text("State and City")).shouldHave(text("Haryana Karnal"));

    }


    @Test
    void minFillFormTest() {
        registrationPage.openPage()
                .inputFirstName("Anastasiia")
                .inputLastName("Belevich")
                .inputgender("Female")
                .inputNumber("1234567895");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--015").click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $$("tbody tr").findBy(text("Student Name")).shouldHave(text("Anastasiia Belevich"));
        $$("tbody tr").findBy(text("Gender")).shouldHave(text("Female"));
        $$("tbody tr").findBy(text("Mobile")).shouldHave(text("1234567895"));
        $$("tbody tr").findBy(text("Date of Birth")).shouldHave(text("15 April,1990"));


    }

    @Test
    void notFillFormTest() {
        registrationPage.openPage();
        $("#submit").click();
        $(".modal-content").shouldNotBe(visible, Duration.ofSeconds(10));

        }
    //bs-form-valid-border-color: #198754;
    //bs-form-invalid-border-color: #dc3545;

}
