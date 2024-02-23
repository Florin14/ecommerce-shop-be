package com.example.ecommerceshopbe.configuration;

import com.example.ecommerceshopbe.dao.model.Gender;
import com.example.ecommerceshopbe.dao.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeGenders();
    }

    private void initializeGenders() {
        // Check if genders are already initialized
        if (genderRepository.count() == 0) {
            Gender male = new Gender();
            male.setName("Male");
            male.setGenderCode('M');
            genderRepository.save(male);

            Gender female = new Gender();
            female.setName("Female");
            female.setGenderCode('F');
            genderRepository.save(female);

            Gender unisex = new Gender();
            unisex.setName("Unisex");
            unisex.setGenderCode('U');
            genderRepository.save(unisex);
        }
    }
}
