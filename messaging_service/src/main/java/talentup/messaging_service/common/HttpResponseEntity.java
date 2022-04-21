package talentup.messaging_service.common;

import lombok.Data;

@Data
public class HttpResponseEntity {
    private String message;
    private String error;
}
