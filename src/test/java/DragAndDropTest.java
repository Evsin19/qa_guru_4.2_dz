import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl="https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.browserSize = "1920x1080"; // Разрешение браузера
        Configuration.pageLoadStrategy = "eager"; // Параметры загрузки страницы
        open("");

    }

    @Test
    void actionsTest(){
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().clickAndHold($("#column-a"))
                .moveToElement($("#column-b"))
                .release()
                .perform();
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void dragAndDropExample(){
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
}
