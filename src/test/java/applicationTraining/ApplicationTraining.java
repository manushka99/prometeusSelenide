package applicationTraining;

import org.junit.jupiter.api.Test;
import resources.FindElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ApplicationTraining extends FindElement{

    @Test
    public void addStudentForGroup(){
        loginUser(adminUserLogin, password);
        findElementInLeftFrame(byText("ОРГАНИЗАТОР")).click();
        findElementInLeftFrame(byText("Заявки на обучение")).click();
        findElementInMainFrame(byText("Ожидают зачисления")).click();
        findElementInMainFrame(byAttribute("data-original-title", "Зачислить в заказанную группу")).click();
    }

    @Test
    public void addStudentForSecondGroup(){
        loginUser(adminUserLogin, password);
        findElementInLeftFrame(byText("ОРГАНИЗАТОР")).click();
        findElementInLeftFrame(byText("Заявки на обучение")).click();
        findElementInMainFrame(byText("Ожидают зачисления")).click();
        findElementInMainFrame(byAttribute("data-original-title", "Зачислить в другую группу")).click();
        findElementInMainFrame(byXpath("/html/body/table/tbody/tr/td/div[1]/form/table/tbody/tr[1]/td[3]/input")).click();
        findElementInMainFrame(byClassName("btnDs")).click();
    }

    @Test
    public void deleteStudentRequest(){
        loginUser(adminUserLogin, password);
        findElementInLeftFrame(byText("ОРГАНИЗАТОР")).click();
        findElementInLeftFrame(byText("Заявки на обучение")).click();
        findElementInMainFrame(byText("Ожидают зачисления")).click();
        findElementInMainFrame(byAttribute("data-original-title", "Удалить")).click();
    }

    @Test
    public void filteringStudent(){
        loginUser(adminUserLogin, password);
        findElementInLeftFrame(byText("ОРГАНИЗАТОР")).click();
        findElementInLeftFrame(byText("Заявки на обучение")).click();
        findElementInMainFrame(byText("Найти")).click();
        changeWindow();
        $(byAttribute("name", "Email")).val("emailTest@email.ru");
        $(byAttribute("name", "action")).click();
    }

    private void changeWindow() {
        ArrayList tabs2 = new ArrayList (getWebDriver().getWindowHandles());//Получение списка табов
        getWebDriver().switchTo().window(String.valueOf(tabs2.get(1)));//Переключение на второй таб в браузере
    }
}
