package metanet.poc.inventoryservice.controller;

import metanet.poc.inventoryservice.dto.AccountDto;
import metanet.poc.inventoryservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/reduceBalance")
    @ResponseStatus(HttpStatus.OK)
    public void reduceBalance(@RequestBody AccountDto accountDto) {
        paymentService.reduceBalance(accountDto);
    }
}