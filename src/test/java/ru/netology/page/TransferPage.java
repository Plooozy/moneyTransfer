package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement transferHeader = $("h1.heading");
    private final SelenideElement amount = $("[data-test-id=amount] input");
    private final SelenideElement from = $("[data-test-id=from] input");
    private final SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private final SelenideElement errorMessage = $("[data-test-id=error-notification]");

    public TransferPage() {
        transferHeader.shouldBe(visible);
    }
    public DashboardPage commitTransfer(String amountToTransfer, DataHelper.cardInfo cardInfo){
        transferOperation(amountToTransfer, cardInfo);
        return new DashboardPage();
    }
    public void transferOperation(String amountToTransfer, DataHelper.cardInfo cardInfo) {
        amount.setValue(amountToTransfer);
        from.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }
    public void findErrorMessage(String expectedText){
        errorMessage.shouldHave(text(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}