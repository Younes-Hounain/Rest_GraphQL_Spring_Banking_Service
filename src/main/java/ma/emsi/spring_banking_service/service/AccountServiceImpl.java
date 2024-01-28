package ma.emsi.spring_banking_service.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ma.emsi.spring_banking_service.dto.BankAccountRequestDTO;
import ma.emsi.spring_banking_service.dto.BankAccountResponseDTO;
import ma.emsi.spring_banking_service.entities.BankAccount;
import ma.emsi.spring_banking_service.mappers.AccountMapperImpl;
import ma.emsi.spring_banking_service.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@Getter@Setter
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private BankAccountRepository bankAccountRepository;
    private AccountMapperImpl accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountDTO);

        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setDateCreated(new Date());

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);

        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account not found")
        );

        // Update the account from the request dto
        bankAccount.setDevise(bankAccountDTO.getDevise());
        bankAccount.setType(bankAccountDTO.getType());
        bankAccount.setBalance(bankAccountDTO.getBalance());

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);

        return bankAccountResponseDTO;
    }
}
