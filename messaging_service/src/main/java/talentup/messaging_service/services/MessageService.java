package talentup.messaging_service.services;

import javax.print.DocFlavor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import talentup.messaging_service.common.HttpResponseEntity;
import talentup.messaging_service.dto.Sms;


public interface MessageService {
    HttpResponseEntity validateInboundSms(Sms sms);
    HttpResponseEntity validateOutboundSms(Sms sms);

}
