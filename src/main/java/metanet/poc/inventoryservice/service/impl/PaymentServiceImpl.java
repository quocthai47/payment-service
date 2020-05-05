package metanet.poc.inventoryservice.service.impl;

import metanet.poc.inventoryservice.dto.AccountDto;
import metanet.poc.inventoryservice.entity.Account;
import metanet.poc.inventoryservice.repository.AccountRepository;
import metanet.poc.inventoryservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.Optional;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private AccountRepository inventoryRepository;

    @Override
    @Transactional
    public void reduceBalance(AccountDto accountDto) {

        Optional<Account> itemAccountOpt = inventoryRepository.findByAccountId(accountDto.getAccountId());

        if(!itemAccountOpt.isPresent()) {
            throw new InvalidParameterException("Can not found Account Id " +  accountDto.getAccountId().toString());
        } else {
            Account currentAccount =  itemAccountOpt.get();

            if(currentAccount.getBalance() < accountDto.getBalance()) {
                throw new InvalidParameterException("Out of stock " +  accountDto.getAccountId().toString());
            }


            Integer updateQuantity = currentAccount.getBalance() - accountDto.getBalance();
            currentAccount.setBalance(updateQuantity);
            inventoryRepository.save(currentAccount);
        }

    }
}
