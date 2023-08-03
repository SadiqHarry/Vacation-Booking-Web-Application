package D288;

import D288.services.CustomerDataInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class D288Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(D288Application.class, args);

		// Get the CustomerDataInitializer bean and call the initializeSampleCustomers method
		CustomerDataInitializer customerDataInitializer = context.getBean(CustomerDataInitializer.class);
		customerDataInitializer.initializeSampleCustomers();
	}
}
