package com.triagem.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
@ConfigurationProperties(prefix = "rsa")
public class RsaKeyProperties {
    public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
    }
}
