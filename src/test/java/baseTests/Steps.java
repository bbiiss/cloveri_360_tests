package baseTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Steps extends BaseTests {

    @Step("Изменить размер")
    public static void changeZoom() {
        Selenide.zoom(0.5);
    }

    @Step("Создать департамент")
    public String createDepartmentOne(String number) {

        String[] idStr1 = {"1"};

        createDepartmentFirstInLevel(number);
        String id1 = getIdElement(idStr1);
//        idStr1 = getIdElements();
//        String id1 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][1]")).attr("data-id");
        return id1;
    }

    @Step("Создать департаменты уровней 1 - 5")
    public String createDepartmentLevels_1_5() {

        String[] idStr1 = {"1"};

        createDepartmentFirstInLevel("1");
        String id1 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id1 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][1]")).attr("data-id");
        createDepartmentFirstInLevel(id1);
        String id2 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id2 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][2]")).attr("data-id");
        createDepartmentFirstInLevel(id2);
        String id3 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id3 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][3]")).attr("data-id");
        createDepartmentFirstInLevel(id3);
        String id4 = getIdElement(idStr1);
//        String id4 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][4]")).attr("data-id");
        createDepartmentFirstInLevel(id4);
//        String id5 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][4]")).attr("data-id");

        return id1;
    }

    @Step("Создать департаменты уровня N")
    public String createDepartmentLevel_N(Integer level) {

        String[] idStr1 = {"1"};

        createDepartmentFirstInLevel("1");
        String id1 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id1 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][1]")).attr("data-id");
        createDepartmentFirstInLevel(id1);
        String id2 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id2 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][2]")).attr("data-id");
        createDepartmentFirstInLevel(id2);
        String id3 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id3 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][3]")).attr("data-id");
        createDepartmentFirstInLevel(id3);
        String id4 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id4 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][4]")).attr("data-id");
        createDepartmentFirstInLevel(id4);
        String id5 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id5 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][5]")).attr("data-id");
        String n = null;
        if(level == 1) { n = id1; }
        if(level == 5) { n = id5; }
        if(level == 3) { n = id3; }
        createDepartment(n);
        String id6 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id6 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][5]")).attr("data-id");
        createDepartment(id6);
        String id7 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id7 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][6]")).attr("data-id");
        createDepartment(id7);
        String id8 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id8 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][7]")).attr("data-id");
        createDepartment(id8);
        String id9 = getIdElement(idStr1);
        idStr1 = getIdElements();
//        String id9 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][8]")).attr("data-id");
        createDepartment(id9);
//        String id10 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][9]")).attr("data-id");

        return id1;
    }

    @Step("Подождать 2 сек")
    public void wait_2_sec() {
        sleep(2000);
    }

    @Step("Проверить значение поля 'input'")
    public void shouldInput(String id, String text) {
        $(By.xpath("//*[@data-id=\"" + id + "\"]/div/div[1]/form/input")).should(Condition.value(text));
    }

    @Step("Проверить название компании")
    public void shouldInputId_1(String id, String text) {
        $(By.xpath("//*[@data-id=\"" + id + "\"]/div/div[1]/form/input")).should(Condition.value(text));
    }

    @Step("Удалить элемент структуры")
    public void deleteElement(String data_id) {
        try {
            $(By.xpath("//*[@data-id=\"" + 1 + "\"]")).click();
            $(By.xpath("//*[@data-id=\"" + data_id + "\"]/div/div[1]/form/div/div/button")).click();
            $(By.linkText("удалить элемент")).click();
            $(By.cssSelector(".button-delete:nth-child(1)")).click();
        }catch (Exception e) {
            System.out.println("Элемент уже удален");
        }
        sleep(200);
    }

    @org.jetbrains.annotations.NotNull
    @Step("Получить список id элементов структуры")
    public static String[] getIdElements() {

        sleep(200);
        int idNumber;
        idNumber = $$(By.xpath("//*[@data-id]")).size();
        idNumber = idNumber/2;

//        idStr2 = $$(By.xpath("//*[@data-id]").attr("data-id"));

        String[] idNumberString = new String[idNumber];
        idNumberString[0] = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selected selectable\"]")).attr("data-id");

        for (int i = 1; i < idNumber; i++) {
            idNumberString[i] = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][" + i + "]")).attr("data-id");
        }
        return idNumberString;
    }

    @Step("Получить id созданного элемента")
    public static String getIdElement(String[] idStr1) {
        String id = null;

        String[] idStr2;

        idStr2 = getIdElements();
        for (int i = 0; i < idStr2.length; i++) {
            for (int j = 0; j < idStr1.length; j++) {
                if(idStr2[i].equals(idStr1[j])) {
                    idStr2[i] = "0";
                }
            }
        }
        for (int i = 0; i < idStr2.length; i++) {
            if(idStr2[i] != "0") {
                id = idStr2[i];
            }
        }
        return id;
    }

}
