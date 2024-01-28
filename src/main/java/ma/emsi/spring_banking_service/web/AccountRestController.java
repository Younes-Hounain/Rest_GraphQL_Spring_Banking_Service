package ma.emsi.spring_banking_service.web;

import lombok.*;
import ma.emsi.spring_banking_service.dto.BankAccountRequestDTO;
import ma.emsi.spring_banking_service.dto.BankAccountResponseDTO;
import ma.emsi.spring_banking_service.entities.BankAccount;
import ma.emsi.spring_banking_service.repositories.BankAccountRepository;
import ma.emsi.spring_banking_service.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Getter@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountRestController {
    private BankAccountRepository repository;
    private AccountServiceImpl accountService;

    @Autowired
    AccountRestController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public AccountRestController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return repository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount bankAccount1 = repository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        bankAccount1.setBalance(bankAccount.getBalance());
        bankAccount1.setDevise(bankAccount.getDevise());
        bankAccount1.setType(bankAccount.getType());
        bankAccount1.setDateCreated(bankAccount.getDateCreated());
        return repository.save(bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
