package org.example;
import java.util.Scanner;
public class MaxAttemptDecorator extends AuthenticatorDecorator{
    Scanner scanner = new Scanner(System.in);
    private static final int Mx_Attempts = 3;
    private int failedAttempts = 1;
    public MaxAttemptDecorator(Authenticator decoratedAuthenticator) {
        super(decoratedAuthenticator);
    }
    @Override
    public boolean authenticate(String username, String password) {
        //Ek özellik 3 kere şifre yanlış girilirse sistem kapatılır.

         while (failedAttempts <= Mx_Attempts) {
             boolean isAuthenticated = super.authenticate(username, password);


            if (isAuthenticated) {
                return true;
            } else {
                failedAttempts++;
                System.out.println("Yanlış kullanıcı adı / şifre girdiniz. Kalan hakkınız: " + (Mx_Attempts - failedAttempts + 1));
                System.out.println("\nLütfen Kullanıcı adını bir daha deneyiniz: ");
                username = scanner.nextLine();
                System.out.println("\nLütfen Şifrenizi bir daha deneyiniz: ");
                password = scanner.nextLine();

            }

            // 3 denemeden sonra hesap kilitlenir
            if (failedAttempts >= Mx_Attempts) {
                System.out.println("Hesabınız 3 kere yanlış giriş yapıldığı için kilitlenmiştir.\n");
                return false;  // Hesap kilitli
            }
        }
        return false; // Fallback
    }
}
