package ma.emsi.spring_banking_service.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ma.emsi.spring_banking_service.dto.BankAccountRequestDTO;
import ma.emsi.spring_banking_service.dto.BankAccountResponseDTO;
import ma.emsi.spring_banking_service.entities.BankAccount;
import ma.emsi.spring_banking_service.entities.Customer;
import ma.emsi.spring_banking_service.repositories.BankAccountRepository;
import ma.emsi.spring_banking_service.repositories.CustomerRepository;
import ma.emsi.spring_banking_service.service.AccountServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Getter@Setter
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private AccountServiceImpl accountService;
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account not found")
        );
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customersList(){
        return customerRepository.findAll();
    }
}
