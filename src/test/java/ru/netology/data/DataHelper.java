package ru.netology.data;

import lombok.Value;

public class DataHelper {
    @Value
    public static class AuthInfo{
        String login;
        String password;
    }
    public static AuthInfo getAuthInfo(){
        return new AuthInfo("vasya", "qwerty123");
    }
    @Value
    public static class codeInfo{
        String code;
    }
    public static codeInfo getCode(AuthInfo authInfo){
        return new codeInfo("12345");
    }
}