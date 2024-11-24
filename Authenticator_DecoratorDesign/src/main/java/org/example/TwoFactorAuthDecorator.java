package org.example;
import java.util.Scanner;
public class TwoFactorAuthDecorator extends AuthenticatorDecorator{
    private Scanner scanner = new Scanner(System.in);
    public TwoFactorAuthDecorator(Authenticator decoratedAuthenticator) {
        super(decoratedAuthenticator);
    }
    @Override
    public boolean authenticate(String username, String password) {
        boolean isAuthenticated = super.authenticate(username, password);
        if(isAuthenticated){
            System.out.println("İki aşamalı doğrulama gerçekleşiyor... \n");
            System.out.println("Lütfen telefonunuza gelen SMS içindeki kodu giriniz:(0499) \n");
            String MessageAnswer = scanner.nextLine();
            if(!"0499".equals(MessageAnswer)){
                System.out.println("Yanlış kod girdiniz! \n");
                return false;
            }
            else
            {return true;}
        }

        return false;
    }
}
