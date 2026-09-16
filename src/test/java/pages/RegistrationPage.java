package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            numberInput = $("#userNumber")
    ;

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



}
