package main.batch;

import main.model.Customer;
import main.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class CustomerBatchBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CustomerService customerService;

    public CustomerBatchBean(CustomerService customerService) {
        this.customerService = customerService;
    }

    private List<String> names = new ArrayList<>(Arrays.asList(
            "Cehun","Rufat","Murad","Hicran","Natasha","Konstantin","Nikolay","Zakir","Mahir","Rustam","Abulfez","Riad",
            "Shakir","Isfaqan","Ayan","Laman","Nargiz"
    ));

    private List<String> lastNames = new ArrayList<>(Arrays.asList(
            "Azizzade","Azizov","Muradov","Hicranov","Evgeniyevna","Pashaev","Aliev","Hesenov","Mahirov","Alekseyev",
            "Abulfezov","Riadov","Tofiqov","Mirzoyev","Taxtamishev","Elekberov","Shaxmuradov"
    ));



    @Scheduled(cron = "0,20 * * * * *")
    public void cronJob(){
        logger.info("cronJob.start");

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1,3); i++) {
            StringBuilder name = new StringBuilder(names.get(ThreadLocalRandom.current().nextInt(0,names.size()-1)));              // Сгенерировал Name для Customer
            StringBuilder lastName = new StringBuilder(lastNames.get(ThreadLocalRandom.current().nextInt(0,lastNames.size()-1)));  // Сгенерировал LastName для Customer
            Long id = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);                                                            //Сгенерировал Long id для Customer
            customerService.addCustomer(new Customer(id,name +  " " + lastName));
        }

        Collection<Customer> customers = customerService.getAllCustomers();
        logger.info("There are {} customers in the data store", customers.size());
        logger.info("cronJob.end");
    }
}
