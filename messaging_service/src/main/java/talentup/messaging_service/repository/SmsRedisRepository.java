package talentup.messaging_service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import talentup.messaging_service.dto.Sms;

@Repository
public interface SmsRedisRepository extends CrudRepository<Sms,Integer> {
    List<Sms> findSmsByFrom(String from);
}
