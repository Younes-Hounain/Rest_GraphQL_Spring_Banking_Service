package ma.emsi.spring_banking_service.repositories;

import ma.emsi.spring_banking_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
