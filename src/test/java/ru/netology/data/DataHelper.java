package ru.netology.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static codeInfo getCode(AuthInfo authInfo) {
        return new codeInfo("12345");
    }

    public static cardInfo getFirstCardInfo() {
        return new cardInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static cardInfo getSecondCardInfo() {
        return new cardInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }
    public static int validTransfer(int balance){
        return new Random().nextInt(balance);
    }
    public static int inValidTransfer(int balance){
        return new Random().nextInt(balance) + balance;
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class codeInfo {
        String code;
    }

    @Value
    public static class cardInfo {
        String cardNumber;
        String cardId;
    }
}