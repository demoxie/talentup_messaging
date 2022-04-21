package talentup.messaging_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import talentup.messaging_service.dto.Sms;
import talentup.messaging_service.model.PhoneNumber;

@RestController
public class MessageController {
    @PostMapping("/inbound/sms")
    public ResponseEntity<?> inbound(@RequestBody Sms sms){
        return ResponseEntity.ok().body("Welcome");
    }
    @PostMapping("/outbound/sms")
    public ResponseEntity<?> outbound(@RequestBody Sms sms){
        return ResponseEntity.ok().body("Welcome");
    }
}
