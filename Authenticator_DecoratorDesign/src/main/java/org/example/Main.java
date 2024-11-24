package org.example;
import java.util.Scanner;
//BAHAR ÜRÜNDİKER 1220505018
//Burda bulunan kod bir şifre sistemi üzerinde doğrulama eklemektedir.
//Decorator Tasarım deseni kullanılarak yapılmıştır.
//3 farklı ek doğrulama sistemi eklenmiştir. ad ve şifre önceden belirlenmiş.
//Captcha, iki aşamalı doğrulama ve yanlış şifre girildiğinde sistemi kilitleme şeklinde güzenlik önlemleridir.
//Kod sadece fikir üzerine şekillenmiş bu sebepten gerçek bir şifre gelmesi durumu bulunmamakta.
//Captcha ve iki aşamalı doğrulama şifreleri kodun içinde belirlenmiş dinamik olmayan bir şekildedir.
//Captcha ve iki aşamalı doğrulama eğer sifre ve username doğru girilirse çalışacak şekilde yazılmıştır.

public class Main {
    public static void main(String[] args) {

        Authenticator authenticator = new SimpleAuthenticator();

        authenticator = new MaxAttemptDecorator(authenticator);

        authenticator = new CaptchaValidationDecorator(authenticator);

        authenticator = new TwoFactorAuthDecorator(authenticator);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kullanıcı adınızı giriniz:(admin)\n");
        String username = scanner.nextLine();
        System.out.println("Sifrenizi giriniz:(123)\n");
        String password = scanner.nextLine();

        boolean isAuthenticated = authenticator.authenticate(username, password);  // Giriş doğrulama


        if (isAuthenticated) {
            System.out.println("Sisteme giriş başarılı.");
        } else {
            System.out.println("Giriş başarısız.");
        }



        scanner.close();


    }
}