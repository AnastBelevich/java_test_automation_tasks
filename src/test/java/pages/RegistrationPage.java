package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import pages.components.CalendarComponent;

import java.time.Duration;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthdayInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            submitButton = $("#submit"),
            modalDialogOfSubmit = $(".modal-dialog"),
            hobbiesSelect = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            addressImput = $("#currentAddress"),
            selectState = $("#state"),
            selectCity = $("#city")

                    ;

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage inputFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage inputLastName(String surname){
        lastNameInput.setValue(surname);
        return this;
    }

    public RegistrationPage inputEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage inputgender(String gender){
        genderRadio.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage inputNumber(String number){
        numberInput.setValue(number);
        return this;
    }


    public RegistrationPage inputDateOfBirthday(String month, String year, String day){
        dateOfBirthdayInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    public RegistrationPage inputSubjects(String subject){
        subjectsInput.setValue(subject);
        return this;
    }


    public RegistrationPage selectHobbyes(String hobby){
        hobbiesSelect.$(byText(hobby)).click();
        return this;
    }


    public RegistrationPage addImg(String nameImg){
        uploadPictureButton.uploadFromClasspath(nameImg);
        return this;
    }

    public RegistrationPage addAddress(String address){
        addressImput.setValue(address);
        return this;
    }

    public RegistrationPage selectStateAndCity(String state, String city){
        selectState.click();
        $(byText(state)).click();
        selectCity.click();
        $(byText(city)).click();
        return this;
    }




    public RegistrationPage submit(){
        submitButton.click();
        return this;
    }

    public RegistrationPage checkModalAppeared() {
        modalDialogOfSubmit.should(appear);
        return this;
    }


    public RegistrationPage checkModalNotAppeared() {
        modalDialogOfSubmit.shouldNotBe(visible, Duration.ofSeconds(3));
        return this;
    }


    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
