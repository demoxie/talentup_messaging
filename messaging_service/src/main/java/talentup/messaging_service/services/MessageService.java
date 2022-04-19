package talentup.messaging_service.services;

import talentup.messaging_service.model.PhoneNumber;

public interface MessageService {
    PhoneNumber addMessage(PhoneNumber phoneNumber);
    PhoneNumber sendMessage(PhoneNumber phoneNumber);
}
