package spring_boot.session07ex03.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import spring_boot.session07ex03.annotation.RequiresOTP;

@Aspect
@Component
public class OtpAspect {
    @Before("@annotation(requiresOTP)")
    public void verifyOtp(JoinPoint joinPoint,
                          RequiresOTP requiresOTP
    ) {
        Object[] args = joinPoint.getArgs();
        String otp = null;
        for (Object arg : args) {
            if (arg instanceof String) {
                otp = (String) arg;
            }
        }

        if (otp == null || otp.trim().isEmpty()) {
            throw new RuntimeException("OTP không được để trống");
        }

        if (!"21012005".equals(otp)) {
            throw new RuntimeException("OTP không hợp lệ");
        }

        System.out.println("Xác thực OTP thành công");
    }
}
