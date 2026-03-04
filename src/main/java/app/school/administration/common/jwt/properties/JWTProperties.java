package app.school.administration.common.jwt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "security.jwt")
@Data
public class JWTProperties {

    private String secret;
    private int accessTokenExpireDays;
    private int refreshTokenExpireMonths;

}
