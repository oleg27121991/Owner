package by.veremei.pages;

import by.veremei.pages.components.CheckServiceFeeAndTotalCostComponent;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BuyTicketPage {
    CheckServiceFeeAndTotalCostComponent checkServiceFeeAndTotalCostComponent = new CheckServiceFeeAndTotalCostComponent();
    private final ElementsCollection btnBuyTicketInEventCard = $$(".afisha_image_container a");
    private final SelenideElement btnBuyTicketOnPageWithEventDescr = $(".buy-button a"),
                                  selectTicketCount = $(".group_info_ticket"),
                                  divWithTicketPriceInForm = $(".price-info");
    public void openLastCardEvent() {
        btnBuyTicketInEventCard.last().click(ClickOptions.usingJavaScript());
    }

    public void addTicket(String count) {
        btnBuyTicketOnPageWithEventDescr.click();
        selectTicketCount.selectOptionContainingText(count);
    }

    public String getTicketPrice() {
        return divWithTicketPriceInForm.getText().replaceAll("[^\\d.]+", "");
    }

    public String getTicketCount() {
        return selectTicketCount.getText().replaceAll("[^\\d.]+", "");
    }

    public void checkTotalCostAndServiceFee(String valuePrice, String valueCount) {
        checkServiceFeeAndTotalCostComponent.checkServiceFeeAndCostTicket(valuePrice, valueCount);
    }
}
