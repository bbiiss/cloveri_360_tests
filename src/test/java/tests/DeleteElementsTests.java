package tests;

import baseTests.Steps;
import io.qameta.allure.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class DeleteElementsTests extends Steps {

    @Description("Проверка удаления элемента")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    void deleteOneElement(String browser) {
        String id;
        id = createDepartmentOne("1");
        System.out.println("id = " + id);
        deleteElement(id);
        int n = $$(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"]")).size();
        System.out.println("n = " + n);
        assert n == 1;
    }

    @Description("Проверка удаления элемента с потомками")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    void deleteElementWithChildren(String browser) {
        String id;
        id = createDepartmentLevels_1_5();
        deleteElement(id);
        int n = $$(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"]")).size();
        assert n == 1;
    }

}