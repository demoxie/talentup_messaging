package talentup.messaging_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import talentup.messaging_service.dto.Sms;
import talentup.messaging_service.model.PhoneNumber;
import talentup.messaging_service.services.MessageService;

@RestController
@RefreshScope
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Value("${server.url:Unable to connect to config server}")
    private String url;

    @RequestMapping("/server/url")
    String getURL() {
        return this.url;
    }
    @PostMapping("/inbound/sms")
    public ResponseEntity<?> inbound(@RequestBody Sms sms){
        return ResponseEntity.ok().body(messageService.sendInboundSms(sms));
    }
    @PostMapping("/outbound/sms")
    public ResponseEntity<?> outbound(@RequestBody Sms sms){
        return ResponseEntity.ok().body(messageService.sendOutboundSms(sms));
    }
}
