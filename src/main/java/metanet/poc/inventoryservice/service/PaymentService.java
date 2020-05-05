package metanet.poc.inventoryservice.service;


import metanet.poc.inventoryservice.dto.AccountDto;

public interface PaymentService {

    void reduceBalance(AccountDto productDto);
}
