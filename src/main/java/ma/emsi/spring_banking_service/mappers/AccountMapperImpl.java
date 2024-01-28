package ma.emsi.spring_banking_service.mappers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ma.emsi.spring_banking_service.dto.BankAccountRequestDTO;
import ma.emsi.spring_banking_service.dto.BankAccountResponseDTO;
import ma.emsi.spring_banking_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Getter@Setter
@AllArgsConstructor
@Component
public class AccountMapperImpl implements AccountMapper{
    @Override
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);

        return bankAccountResponseDTO;
    }

    @Override
    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountResponseDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountResponseDTO, bankAccount);

        return bankAccount;
    }
}
