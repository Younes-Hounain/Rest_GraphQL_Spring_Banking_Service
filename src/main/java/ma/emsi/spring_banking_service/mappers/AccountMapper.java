package ma.emsi.spring_banking_service.mappers;

import ma.emsi.spring_banking_service.dto.BankAccountRequestDTO;
import ma.emsi.spring_banking_service.dto.BankAccountResponseDTO;
import ma.emsi.spring_banking_service.entities.BankAccount;

public interface AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount);
    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountResponseDTO);

}
