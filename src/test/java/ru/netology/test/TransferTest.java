package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPageV1;

import static com.codeborne.selenide.Selenide.open;

public class TransferTest {
    @Test
    void shouldLogIn() {
        open("http://localhost:9999/");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getCode(authInfo);
        verificationPage.validVerify(verificationCode);
    }
}