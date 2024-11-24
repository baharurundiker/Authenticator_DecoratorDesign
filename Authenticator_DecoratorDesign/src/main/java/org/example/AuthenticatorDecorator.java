package org.example;

public abstract class AuthenticatorDecorator implements Authenticator{
    protected Authenticator decoratedAuthenticator;

    public AuthenticatorDecorator(Authenticator decoratedAuthenticator){
        this.decoratedAuthenticator = decoratedAuthenticator;
    }

    @Override
    public boolean authenticate(String username, String password) {
        return decoratedAuthenticator.authenticate(username, password);
    }
}
