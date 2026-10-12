package spring_boot.session07ex03.service;

import org.springframework.stereotype.Service;
import spring_boot.session07ex03.annotation.RequiresOTP;

@Service
public class BankService {
    @RequiresOTP
    public String withdraw(double amount, String otp) {
        return "Rút tiền thành công";
    }

    @RequiresOTP
    public String transfer(String toUser,
                           double amount,
                           String otp
    ) {
        return "Chuyển khoản thành công"
    }

    public String getBalance() {
        return "Số dư hiện tại: 5 triệu";
    }
}
