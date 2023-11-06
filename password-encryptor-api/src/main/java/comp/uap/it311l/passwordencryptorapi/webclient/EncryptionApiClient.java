package comp.uap.it311l.passwordencryptorapi.webclient;

import comp.uap.it311l.passwordencryptorapi.models.EncryptionResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface EncryptionApiClient {

    @GetExchange("/encryptstring?secretKey={secretKey}&plainText={plainText}&cryptAlgorithm={cryptAlgorithm}")
    public EncryptionResponse encrypt(@PathVariable String secretKey,
                                      @PathVariable String plainText,
                                      @PathVariable String cryptAlgorithm);

    @GetExchange("/decryptstring?cryptAlgorithm={cryptAlgorithm}&secretKey={secretKey}&encryptedText={encryptedText}")
    public EncryptionResponse decrypt(@PathVariable String cryptAlgorithm,
                                      @PathVariable String secretKey,
                                      @PathVariable String encryptedText);


}
