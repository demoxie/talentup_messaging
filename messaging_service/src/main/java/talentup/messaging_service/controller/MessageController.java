package talentup.messaging_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import talentup.messaging_service.model.PhoneNumber;

@RestController
public class MessageController {
    @PostMapping("/from")
    public void receiveMessage(@RequestBody PhoneNumber phoneNumber){

    }
}
