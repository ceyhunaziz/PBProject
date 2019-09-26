package main.schedules;

import main.dao.Customer;
import main.model.dto.CustomerDto;
import main.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class CustomerSchedule {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CustomerService customerService;

    public CustomerSchedule(CustomerService customerService) {
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



    @Scheduled(cron = "0,01 * * * * *")
    public void cronJob(){
        logger.info("cronJob.start");

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1,3); i++) {
            StringBuilder name = new StringBuilder(names.get(ThreadLocalRandom.current().nextInt(0,names.size()-1)));              // Сгенерировал Name для Customer
            StringBuilder lastName = new StringBuilder(lastNames.get(ThreadLocalRandom.current().nextInt(0,lastNames.size()-1)));  // Сгенерировал LastName для Customer
            customerService.addCustomer(new CustomerDto(name +  " " + lastName));
        }

        List<CustomerDto> customerEntities = customerService.getAllCustomers();
        logger.info("There are {} customerEntities in the data store", customerEntities.size());
        logger.info("cronJob.end");
    }
}
