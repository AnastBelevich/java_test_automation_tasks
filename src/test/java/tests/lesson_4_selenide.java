package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;


public class lesson_4_selenide {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void wikiShouldHaveSoftAssertionsAndJUnit5() {

        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $(byTagAndText("span","Wiki")).click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body").$("a[href$='/wiki/SoftAssertions']").shouldBe(visible);
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").$("a[href$='/wiki/SoftAssertions']").click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));



    }


}
