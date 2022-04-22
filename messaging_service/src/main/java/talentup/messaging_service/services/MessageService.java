package talentup.messaging_service.services;

import talentup.messaging_service.common.HttpResponseEntity;
import talentup.messaging_service.dto.Sms;


public interface MessageService {
    HttpResponseEntity sendInboundSms(Sms sms);
    HttpResponseEntity sendOutboundSms(Sms sms);

}
