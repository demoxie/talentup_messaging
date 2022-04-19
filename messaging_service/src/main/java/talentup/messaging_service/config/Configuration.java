package talentup.messaging_service.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="bank-account-service")
@Setter
@Getter
public class Configuration {
    private Double minBalance;
    private Double maxBalance;

}