package cn.cpoet.mt.single.boot.auth;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.KeyPair;

/**
 * 密钥对
 *
 * @author CPoet
 */
@Slf4j
public class KeyPairHolder {
    /**
     * 密钥对生成算法
     */
    public final static SignatureAlgorithm DEFAULT_ALGORITHM = SignatureAlgorithm.RS256;

    private static KeyPair keyPair;

    static {
        KeyPair newKeyPair = refresh();
        log.debug("Generated authentication key pair:\n\tpublicKey: {}\n\tprivateKey: {}",
            newKeyPair.getPublic(), newKeyPair.getPrivate());
    }

    public static KeyPair getKeyPair() {
        return keyPair;
    }

    public static KeyPair refresh() {
        keyPair = Keys.keyPairFor(DEFAULT_ALGORITHM);
        return keyPair;
    }
}
