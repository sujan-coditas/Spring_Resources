package com.example.SpringAmigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customer")
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class SpringAmigoscodeApplication {
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringAmigoscodeApplication.class, args);
	}

	@GetMapping("/greet")
	public GreetResponse greet(){
		return  new GreetResponse("Hello",
				List.of("java","GoLang","Javascript"),
				new Person("sujan",23,1000));
	}

	@GetMapping
	public List<Customer> customer(){
		return customerRepository.findAll();

	}

	record Person(String name,int age, double salary){}

	record GreetResponse(String greet,
						 List<String> favprogramminglanguages,
						 Person person){}
record NewCustomerRequest(
		String name,
		String email,
		Integer age

){}

	public void addCustomer( NewCustomerRequest customerRequest){
		Customer customer=new Customer();
		customer.setName(customerRequest.name);
		customer.setEmail(customerRequest.email);
customer.setAge(customerRequest.age);
customerRepository.save(customer);
	}
	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id){
		customerRepository.deleteById(id);
	}


//	class GreetResponse{
//		private final String greet;
//
//		GreetResponse(String greet) {
//			this.greet = greet;
//		}
//
//		public String getGreet() {
//			return greet;
//		}
//
//		@Override
//		public String toString() {
//			return "GreetResponse{" +
//					"greet='" + greet + '\'' +
//					'}';
//		}
//
//	}

}
