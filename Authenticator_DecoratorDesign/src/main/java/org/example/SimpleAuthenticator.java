package org.example;
import java.util.Scanner;
public class SimpleAuthenticator implements Authenticator{

    @Override
    public boolean authenticate(String username, String password) {
        if (!username.equals("admin")) {  // String karşılaştırması equals() ile yapılmalı
            System.out.println("Kullanıcı adınız hatalı lütfen tekrar deneyiniz.\n");
            return false;
        } else if (!password.equals("123")) {  // String karşılaştırması equals() ile yapılmalı
            System.out.println("Şifreniz hatalı lütfen tekrar deneyiniz.\n");
            return false;
        } else {
            System.out.println("Giriş başarılı!\n");
            return true;  // Başarılı girişte true döndürüyoruz
        }
    }
}
