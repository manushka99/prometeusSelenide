package catalogCourses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import resources.FindElement;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SendRequestForCourse extends FindElement {

    @Test
    public void createRequestForCourse() {
        Configuration.browser = "chrome";
        open("https://p5013.prometeus.ru");
        $(byText("Каталог курсов")).click();
        $(byText("Все курсы")).click();
        $(byId("btnhOK")).click();
        $(byAttribute("type", "radio")).click();
        createNewUser();
    }

    private void createNewUser() {
        String date = String.valueOf(new SimpleDateFormat("dd.MM.yyyy").format(new Date().getTime()));
        $(byId("login")).val(date + new Date().getSeconds());
        $(byId("pw")).val("password");
        $(byId("pw2")).val("password");
        $(byId("lname")).val("family" + date);
        $(byId("name")).val("name" + date);
        $(byId("otch")).val("patronymic" + date);
        $(byId("phone")).val("8-800-00-00");
        $(byId("email")).val("emailTest@email.ru");
        $(byId("btnhOK")).click();
        $(byText("Заказ зарегистрирован успешно. После проверки данных мы свяжемся с Вами")).shouldBe(Condition.exist);
    }

}
