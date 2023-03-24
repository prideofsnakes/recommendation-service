package com.xmcyodc.recommendationservice.exception;


public class CryptoNotFoundException extends RuntimeException{
    public CryptoNotFoundException() {
        super("Crypto not found, Please, try another crypto");
    }
}
