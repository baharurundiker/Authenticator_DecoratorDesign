package org.example;
import java.util.Scanner;
public class CaptchaValidationDecorator extends AuthenticatorDecorator{
    private Scanner scanner = new Scanner(System.in);
    public CaptchaValidationDecorator(Authenticator decoratedAuthenticator) {
        super(decoratedAuthenticator);
    }
    @Override
    public boolean authenticate(String username, String password) {
        boolean isAuthenticated = super.authenticate(username, password);
        if (isAuthenticated) {
            System.out.println("CAPTCHA doğrulaması gerçekleşiyor lütfen bekleyiniz..\n");
            System.out.println("CAPTCHA kodunu giriniz:(1234)\n");
            String captchaAnswer = scanner.nextLine();
            if (!"1234".equals(captchaAnswer)){
                System.out.println("Kod Hatalı!\n Sistem kapatılıyor");
                return false;
            }
            else
            { return true; }


        }
        else return false;

    }
}
