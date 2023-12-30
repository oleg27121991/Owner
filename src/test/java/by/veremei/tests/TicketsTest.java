package by.veremei.tests;

import by.veremei.data.BuyTicketTestData;
import by.veremei.pages.BuyTicketPage;
import by.veremei.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;

public class TicketsTest extends BaseTest {
    MainPage mainPage = new MainPage();
    BuyTicketPage buyTicketPage = new BuyTicketPage();
    BuyTicketTestData buyTicketTestData = new BuyTicketTestData();

    private final static String EDUCATION_CATEGORY_PAGE = "Образование и развитие";

    @Test
    @Feature("Покупка билета на мероприятие")
    @Story("Отображение информации о билетах на странице мероприятия")
    @Owner("tg - @Veremeioleg")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка отображения количества билетов и сервисного сбора на странице покупки")
    void testCheckTicketCountAndServiceFeeOnBuyPage() {
        AtomicReference<String> count = new AtomicReference<>("");
        AtomicReference<String> price = new AtomicReference<>("");
        step("Открываем главную страницу", () ->
                mainPage.openMainPage(baseUrl)
        );
        step("Переходим на страницу категории 'Красота и здоровье'", () ->
                mainPage.openCategory(EDUCATION_CATEGORY_PAGE)
        );
        step("Кликаем на карточку последнего мероприятия в списке", () ->
                buyTicketPage.openLastCardEvent()
        );
        step("Выбираем любое количество билетов из селекта", () ->
                buyTicketPage.addTicket(buyTicketTestData.ticketCount)
        );
        step("Запоминаем значение 'Цена' для выбранного билета", () ->
                price.set(buyTicketPage.getTicketPrice())
        );
        step("Запоминаем значение 'Количество' для выбранного билета", () ->
                count.set(buyTicketPage.getTicketCount())
        );
        step("Проверяем отображение текста и значение стоимости билета и сервисного сбора для выбранного билета", () ->
                buyTicketPage.checkTotalCostAndServiceFee(price.get(), count.get())
        );
    }
}
