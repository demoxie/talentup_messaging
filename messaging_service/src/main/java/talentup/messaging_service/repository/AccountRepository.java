package talentup.messaging_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import talentup.messaging_service.model.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findAccountByAuthIdAndUsername(String auth_id, String username);
}
