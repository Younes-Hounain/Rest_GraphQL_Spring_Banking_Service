package ma.emsi.spring_banking_service.service;

import ma.emsi.spring_banking_service.dto.BankAccountRequestDTO;
import ma.emsi.spring_banking_service.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);

}
