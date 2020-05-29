package com.yg.ClinicSpringReact.bootstrap;

import com.yg.ClinicSpringReact.domain.Category;
import com.yg.ClinicSpringReact.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;//springBoot specific
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    public DataLoader(CategoryRepository categoryRepository)
    {
        this.categoryRepository=categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category fruits=new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Data Loaded = " + categoryRepository.count() );

    }
}
