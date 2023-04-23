package br.com.vinicius.ecommerce.services.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String message){
        super(message);
    }
}
