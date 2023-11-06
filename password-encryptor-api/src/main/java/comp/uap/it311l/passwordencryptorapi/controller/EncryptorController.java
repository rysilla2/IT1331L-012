package comp.uap.it311l.passwordencryptorapi.controller;

import comp.uap.it311l.passwordencryptorapi.models.DecryptDto;
import comp.uap.it311l.passwordencryptorapi.models.EncryptionResponse;
import comp.uap.it311l.passwordencryptorapi.models.UapEncryptionRequest;
import comp.uap.it311l.passwordencryptorapi.service.EncryptDecryptService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptorController  {


    @Autowired
    private EncryptDecryptService encryptDecryptService;

    @GetMapping("/api/encryption")
    public EncryptionResponse encryptString(@RequestBody UapEncryptionRequest request) {
        System.out.println("encryptString() called");
        EncryptionResponse encryptionResponse = encryptDecryptService.encrypt(request.getPassword());
        encryptDecryptService.save(encryptionResponse.getResult());
        return encryptionResponse;
    }

    @GetMapping("/check")
    public boolean check(String string) {
        System.out.println("check: " + string);
        boolean exists = encryptDecryptService.search(string);
        return exists;
    }

    @GetMapping("/api/decryption")
    public String descryptString(@RequestBody DecryptDto decryptDto) {
        System.out.println("decrypt() called");
        System.out.println("Received: " + decryptDto);

        //look for encryptedword in database
        String encryptedWord = decryptDto.getEncryptedString();
        System.out.println("Ecnrypted: " + encryptedWord);

        if (check(encryptedWord) == false) {
            return "Encrypted Word Does Not Exist";
        }

        EncryptionResponse encryptionResponse = encryptDecryptService.decrypt(encryptedWord);

        return encryptionResponse.getResult();


    }

}
