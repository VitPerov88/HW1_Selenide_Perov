package src.test.java;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW1_Selenide {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1500x980";
    }

    @Test
    void fillFormTest() {
        open("https://github.com/selenide/selenide");
        $("a#wiki-tab").click();
        $("#wiki-pages-box").$(".wiki-more-pages-link").$(".f6").click();
        $("div").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        String JUnit5Class = "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}";
    }
}