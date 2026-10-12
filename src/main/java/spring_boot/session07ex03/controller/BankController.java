package spring_boot.session07ex03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring_boot.session07ex03.service.BankService;

@RestController
public class BankController {
    private final BankService bankService;
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/withdraw")
    public String withdraw(@RequestParam double amount,
                           @RequestParam String otp
    ) {
        return bankService.withdraw(amount, otp);
    }

    @GetMapping("/transfer")
    public String transfer(@RequestParam String toUser,
                           @RequestParam double amount,
                           @RequestParam String otp
    ) {
        return bankService.transfer(toUser, amount, otp);
    }

    @GetMapping("/balance")
    public String balance() {
        return bankService.getBalance();
    }
}
