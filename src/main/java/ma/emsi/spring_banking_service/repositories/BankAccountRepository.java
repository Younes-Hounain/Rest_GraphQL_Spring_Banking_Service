package ma.emsi.spring_banking_service.repositories;

import ma.emsi.spring_banking_service.entities.BankAccount;
import ma.emsi.spring_banking_service.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/byType")
    BankAccount findByType(@Param("t") AccountType type);
}