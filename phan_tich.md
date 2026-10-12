1. Định nghĩa Input/Output
    - Input: phương thức sẽ nhận các dữ liệu như:
      - amount (số tiền)
      - toUser (Người nhận)
      - otp (Mã OTP)
    - Output: Hệ thống sẽ trả về:
      - OTP hợp lệ --> Giao dịch thành công
      - OTP null hoặc rỗng --> ném exeption/ chặn xử lý
      - OTP sai --> chặn xử lý
2. Dùng Custom Annotation để đánh dấu hàm cần bảo mật lại tối ưu hơn việc dùng Pointcut quét theo
tên hàm thông thường tại vì:
   - Không phụ thuộc vào tên method:
     - Ví dụ đổi tên từ withdraw()-->withdrawMoney() thì annotation vẫn hoạt động được
   - Dễ mở rộng:
     - Method nào cần OTP thì chỉ cần thêm @RequiresOTP --> không cần sửa Aspect
   - Code rõ ràng hơn
     - Chỉ cần nhìn vào method có @RequiresOTP là biết ngay hàm đó cần xác thực OTP
   - Tránh quên bảo mật
     - Nếu quét tên theo hàm, dev dễ quên đặt đúng tên method --> gây lỗ hổng bảo mật.
     - Annotation giúp đánh giấu trực tiếp nên an toàn hơn