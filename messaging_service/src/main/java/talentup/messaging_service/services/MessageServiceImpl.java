package talentup.messaging_service.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import talentup.messaging_service.common.HttpResponseEntity;
import talentup.messaging_service.dto.Sms;
import talentup.messaging_service.repository.AccountRepository;
import talentup.messaging_service.repository.PhoneNumberRepository;
import talentup.messaging_service.repository.SmsRedisRepository;

@Service
public class MessageServiceImpl implements MessageService{

    private final PhoneNumberRepository phoneNumberRepository;

    private final AccountRepository accountRepository;
    private final SmsRedisRepository smsRedisRepository;
    @Autowired
    public MessageServiceImpl(final PhoneNumberRepository phoneNumberRepository, final AccountRepository accountRepository, final SmsRedisRepository smsRedisRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.accountRepository = accountRepository;
        this.smsRedisRepository = smsRedisRepository;
    }

    @Override
    public HttpResponseEntity sendInboundSms(final Sms sms) {
        var response = new HttpResponseEntity();
        if (verifyContent(sms, response)) return response;
        if (Objects.isNull(phoneNumberRepository.findPhoneNumberByNumber(sms.getTo()))){
            response.setMessage("");
            response.setError("<to> not found");
            return response;
        }
        List<Sms> previousSms = smsRedisRepository.findSmsByFrom(sms.getFrom());
        if((long) previousSms.size() >=50){
            response.setMessage("");
            response.setError("limit reached for from <from>");
            return response;
        }
        sms.setId(UUID.randomUUID());
        sms.setDateTime(LocalDateTime.now());
        response.setMessage("inbound sms ok");
        response.setError("");
        return response;
    }

    private boolean verifyContent(final Sms sms, final HttpResponseEntity response) {
        if (sms.getText().isEmpty()){
            response.setMessage("");
            response.setError("<text> missing");
            return true;
        } else if (sms.getFrom().isEmpty()) {
            response.setMessage("");
            response.setError("<from> is missing");
            return true;
        }
        if(sms.getText().contains("STOP")){
            smsRedisRepository.save(sms);
        }
        return false;
    }

    @Override
    public HttpResponseEntity sendOutboundSms(final Sms sms) {
        HttpResponseEntity response = new HttpResponseEntity();
        if (verifyContent(sms, response)) return response;
        if (Objects.isNull(smsRedisRepository.findSmsByFrom(sms.getFrom()))){
            response.setMessage("");
            response.setError("<from> not found");
            return response;
        }else if(Objects.isNull(phoneNumberRepository.findPhoneNumberByNumber(sms.getFrom()))){
            response.setMessage("");
            response.setError("sms from <from> to <to> blocked by STOP request");
        }
        List<Sms> previousSms = smsRedisRepository.findSmsByFrom(sms.getFrom());
        if((long) previousSms.size() >=50){
            response.setMessage("");
            response.setError("limit reached for from <from>");
            return response;
        }

        response.setMessage("outbound sms ok");
        response.setError("");
        return response;
    }
}
