package ma.emsi.spring_banking_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import ma.emsi.spring_banking_service.enums.AccountType;

import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Date dateCreated;
    private Double balance;
    private String devise;
    private AccountType type;
    @ManyToOne
    private Customer customer;
}
