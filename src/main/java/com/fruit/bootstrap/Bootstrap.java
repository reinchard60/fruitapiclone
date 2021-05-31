package com.fruit.bootstrap;

import com.fruit.domain.Category;
import com.fruit.domain.Customer;
import com.fruit.repositories.CategoryRepository;
import com.fruit.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LoadCategories();
        loadCustomers();
    }

    private void LoadCategories() {
        List<String> categories = Arrays
                .asList("Fruits","Dried","Fresh","Exotic","Nuts",
                        "Native Hawaiian or Other Pacific Islander","White",
                        "Black or African American","American Indian or Alaska Native");

        categories.forEach(category -> categoryRepository.save(new Category(null, category)));

        log.info("Data loaded: {}", categoryRepository.count());
    }

    private void loadCustomers() {
        List<Customer> users = Arrays.asList(
          new Customer(null, "David", "Smith"),
          new Customer(null, "Gary", "Howell"),
          new Customer(null, "Stephen", "Askins"),
          new Customer(null, "Daniel", "Walton")
        );

        users.forEach(customerRepository::save);

        log.info("Customers loaded: {}", customerRepository.count());
    }
}
