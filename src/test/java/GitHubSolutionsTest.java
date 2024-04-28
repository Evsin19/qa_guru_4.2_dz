import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSolutionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; // Разрешение браузера
        Configuration.pageLoadStrategy = "eager"; // Параметры загрузки страницы
    }

    @AfterEach
    void afterEach(){
        closeWebDriver();
    }

    @Test
    void openSolutionsEnterprize(){
        open("https://github.com/");
        $(byTagAndText("button","Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-Powered developer platform."));
    }
}
