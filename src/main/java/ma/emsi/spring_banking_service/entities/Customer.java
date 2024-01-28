package ma.emsi.spring_banking_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;
}
