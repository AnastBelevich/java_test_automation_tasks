package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;      // $, $$, open, sleep
import static com.codeborne.selenide.Condition.*;     // text, visible, exist
import static com.codeborne.selenide.Selectors.*;     // byText, byTagAndText

public class lesson_5_github {
    @Test
    void solutionsEnterprise() {
        open("https://github.com");
        $("nav").$(byText("Solutions")).hover();
       // $(byTagAndText("button","Solutions")).hover();
        $(byText("Enterprises")).click();
        sleep(5000);
        $("[data-testid=Hero-grid]").$("span").shouldHave(text(("Bring your DevOps together on one secure platform")));

    }
}
