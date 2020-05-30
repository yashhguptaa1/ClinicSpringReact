package com.yg.ClinicSpringReact.bootstrap;

import com.yg.ClinicSpringReact.domain.Category;
import com.yg.ClinicSpringReact.domain.Guardian;
import com.yg.ClinicSpringReact.repositories.CategoryRepository;
import com.yg.ClinicSpringReact.repositories.GuardianRepository;
import org.springframework.boot.CommandLineRunner;//springBoot specific
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{
    private final CategoryRepository categoryRepository;
    private final GuardianRepository guardianRepository;

    public DataLoader(CategoryRepository categoryRepository, GuardianRepository guardianRepository) {
        this.categoryRepository = categoryRepository;
        this.guardianRepository = guardianRepository;
    }

    @Override
        public void run(String... args) throws Exception {

            loadCategories();
            loadGuardians();
        }

        private void loadCategories(){
            Category fruits = new Category();
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


            System.out.println("Categories Loaded = " + categoryRepository.count() );

        }

        private void loadGuardians()
        {
            Guardian guardian1=new Guardian();
            guardian1.setId(1L);
            guardian1.setFirstName("Tarun");
            guardian1.setLastName("Chugh");
            guardianRepository.save(guardian1);


            Guardian guardian2=new Guardian();
            guardian2.setId(2L);
            guardian2.setFirstName("Yash");
            guardian2.setLastName("Gupta");
            guardianRepository.save(guardian2);


            System.out.println("Guardians Loaded = " + guardianRepository.count());


        }
}
