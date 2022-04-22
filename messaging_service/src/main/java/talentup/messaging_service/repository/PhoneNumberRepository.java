package talentup.messaging_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import talentup.messaging_service.model.PhoneNumber;
@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
    PhoneNumber findPhoneNumberByNumber(String number);
}
