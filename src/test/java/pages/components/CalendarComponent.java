package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement
            monthOfBirthday = $(".react-datepicker__month-select"),
            yearOfBirthday = $(".react-datepicker__year-select")

                    ;

    public void setDate(String month, String year, String day){
        monthOfBirthday.selectOption(month);
        yearOfBirthday.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        }
}
