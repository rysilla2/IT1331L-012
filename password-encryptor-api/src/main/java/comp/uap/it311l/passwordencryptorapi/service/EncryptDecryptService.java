package comp.uap.it311l.passwordencryptorapi.service;

import comp.uap.it311l.passwordencryptorapi.models.EncryptionResponse;
import comp.uap.it311l.passwordencryptorapi.repository.PasswordMyBatisRepository;
import comp.uap.it311l.passwordencryptorapi.webclient.EncryptionApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EncryptDecryptService {

    @Autowired
    private EncryptionApiClient apiClient;

    @Autowired
    private PasswordMyBatisRepository passwordMyBatisRepository;

    public EncryptionResponse encrypt(String password) {
        return apiClient.encrypt("coffee", password, "AES");
    }

    public EncryptionResponse decrypt(String password) {
        return apiClient.decrypt("AES", "coffee", password);
    }

    public void save(String string) {
        passwordMyBatisRepository.save(string);
    }

    public boolean search(String password) {
        System.out.println("EncryptDecryptService().search(): " + password);
        List<String> list = passwordMyBatisRepository.search(password);
        System.out.println("Len: " + list.size());
        if (list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

}
