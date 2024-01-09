package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final SelenideElement header = $("[data-test-id=dashboard]");
    private final ElementsCollection cards = $$(".list__item div");
    private final String startBalance = "баланс: ";
    private final String finishBalance = " р.";

    public DashboardPage() {
        header.shouldBe(visible);
    }

    public int getCardBalance(DataHelper.cardInfo cardInfo) {
        val text = cards.findBy(Condition.text(cardInfo.getCardNumber().substring(15))).getText();
        return extractBalance(text);
    }

    public TransferPage selectCardToTransfer(DataHelper.cardInfo cardInfo) {
        cards.findBy(attribute("data-test-id", cardInfo.getCardId())).$(".button").click();
        return new TransferPage();
    }

    private int extractBalance(String text) {
        val start = text.indexOf(startBalance);
        val finish = text.indexOf(finishBalance);
        val value = text.substring(start + startBalance.length(), finish);
        return Integer.parseInt(value);
    }
}