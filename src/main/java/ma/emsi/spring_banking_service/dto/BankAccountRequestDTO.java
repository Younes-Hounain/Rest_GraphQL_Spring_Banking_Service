package ma.emsi.spring_banking_service.dto;

import lombok.*;
import ma.emsi.spring_banking_service.enums.AccountType;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private Double balance;
    private String devise;
    private AccountType type;
}
