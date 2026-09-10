package tests;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;      // $, $$, open, sleep
import static com.codeborne.selenide.Condition.*;     // text, visible, exist
import static com.codeborne.selenide.Selectors.*;     // byText, byTagAndText

class lesson5Test {
    @Test
    void solutionsEnterprise() {
        open("https://github.com");
        // $("nav").$(byText("Solutions")).hover();
        $(byTagAndText("button","Solutions")).hover();
        $(byText("Enterprises")).click();
       // $("[href='/enterprise']").click();
        sleep(5000);
        $("[data-testid=Hero-grid]").$("span").shouldHave(text(("Bring your DevOps together on one secure platform")));

    }

    @Test
    void dragAndDropActions() {

        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенесите прямоугольник А на место В
        //        Selenide.actions().clickAndHold($("#column-a"))
        //               .moveToElement($("#column-b"))
        //              .release()
        //              .perform();
        $("#column-a").dragAndDrop(to($("#column-b")));
        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


    }
}
