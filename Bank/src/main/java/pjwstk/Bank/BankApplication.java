package pjwstk.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {
	private BankService bankService;
	public BankApplication(BankService bankService){
		this.bankService = bankService;
	}
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
