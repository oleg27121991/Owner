package by.veremei.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public void openMainPage (String url) {
        Selenide.open(url);
    }

    public void openCategory(String nameCategory) {
        $(byTagAndText("a", nameCategory)).click(ClickOptions.usingJavaScript());
    }
}
