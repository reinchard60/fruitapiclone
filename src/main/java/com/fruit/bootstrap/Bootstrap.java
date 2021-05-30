package com.fruit.bootstrap;

import com.fruit.domain.Category;
import com.fruit.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits  = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        Category nativeHawaiian = new Category();
        nativeHawaiian.setName("Native Hawaiian or Other Pacific Islander");

        Category white  = new Category();
        white.setName("White");

        Category africanAmerican = new Category();
        africanAmerican.setName("Black or African American");

        Category americanIndian = new Category();
        americanIndian.setName("American Indian or Alaska Native");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
        categoryRepository.save(nativeHawaiian);
        categoryRepository.save(white);
        categoryRepository.save(africanAmerican);
        categoryRepository.save(americanIndian);

        log.info("Data loaded: {}", categoryRepository.count());

    }
}
