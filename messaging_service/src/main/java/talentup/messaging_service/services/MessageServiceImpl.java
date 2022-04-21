package talentup.messaging_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import talentup.messaging_service.common.HttpResponseEntity;
import talentup.messaging_service.dto.Sms;
import talentup.messaging_service.model.Account;
import talentup.messaging_service.model.PhoneNumber;
import talentup.messaging_service.repository.AccountRepository;
import talentup.messaging_service.repository.PhoneNumberRepository;
@Service
public class MessageServiceImpl implements MessageService{

    private final PhoneNumberRepository phoneNumberRepository;

    private final AccountRepository accountRepository;
    @Autowired
    public MessageServiceImpl(final PhoneNumberRepository phoneNumberRepository, final AccountRepository accountRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public HttpResponseEntity validateInboundSms(final Sms sms) {
        Account account = accountRepository.findAccountByAuth_idAndUsername(sms.getTo(), )
        return null;
    }

    @Override
    public HttpResponseEntity validateOutboundSms(final Sms sms) {
        return null;
    }
}
