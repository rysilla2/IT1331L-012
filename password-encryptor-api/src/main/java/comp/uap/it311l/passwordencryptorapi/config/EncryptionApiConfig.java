package comp.uap.it311l.passwordencryptorapi.config;

import comp.uap.it311l.passwordencryptorapi.webclient.EncryptionApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@ComponentScan("comp.uap.it311l.passwordencryptorapi")
public class EncryptionApiConfig {

    @Bean
    EncryptionApiClient encryptionApi() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://encryption-api1.p.rapidapi.com/api/Cryptor")
                .defaultHeader("X-RapidAPI-Key", "80245bca54msh4163e2d43e699bep1e651ejsn03731b2e6700")
                .defaultHeader("X-RapidAPI-Host", "encryption-api1.p.rapidapi.com")
                .build();

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient)).build();
        return httpServiceProxyFactory.createClient(EncryptionApiClient.class);
    }


}
