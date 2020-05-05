package metanet.poc.inventoryservice.repository;

import metanet.poc.inventoryservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByAccountId(Integer accountId);

}
