package com.example.ecommerceshopbe.configuration;

import com.example.ecommerceshopbe.dao.model.Gender;
import com.example.ecommerceshopbe.dao.model.ProductSize;
import com.example.ecommerceshopbe.dao.model.Role;
//import com.example.ecommerceshopbe.dao.model.User;
import com.example.ecommerceshopbe.dao.repository.GenderRepository;
import com.example.ecommerceshopbe.dao.repository.ProductSizeRepository;
//import com.example.ecommerceshopbe.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private ProductSizeRepository productSizeRepository;

//    @Autowired
//    private UserRepository userRepository;

    private final List<Map<String, Object>> productSizeData = List.of(
            Map.of("name", "4XS", "isForShoes", false),
            Map.of("name", "XXXS", "isForShoes", false),
            Map.of("name", "XXS", "isForShoes", false),
            Map.of("name", "XS", "isForShoes", false),
            Map.of("name", "S", "isForShoes", false),
            Map.of("name", "M", "isForShoes", false),
            Map.of("name", "L", "isForShoes", false),
            Map.of("name", "XL", "isForShoes", false),
            Map.of("name", "XXL", "isForShoes", false),
            Map.of("name", "XXXL", "isForShoes", false),
            Map.of("name", "33", "isForShoes", true),
            Map.of("name", "33.5", "isForShoes", true),
            Map.of("name", "34", "isForShoes", true),
            Map.of("name", "34.5", "isForShoes", true),
            Map.of("name", "35", "isForShoes", true),
            Map.of("name", "35.5", "isForShoes", true),
            Map.of("name", "36", "isForShoes", true),
            Map.of("name", "36.5", "isForShoes", true),
            Map.of("name", "37", "isForShoes", true),
            Map.of("name", "37.5", "isForShoes", true),
            Map.of("name", "38", "isForShoes", true),
            Map.of("name", "38.5", "isForShoes", true),
            Map.of("name", "39", "isForShoes", true),
            Map.of("name", "39.5", "isForShoes", true),
            Map.of("name", "40", "isForShoes", true),
            Map.of("name", "40.5", "isForShoes", true),
            Map.of("name", "41", "isForShoes", true),
            Map.of("name", "41.5", "isForShoes", true),
            Map.of("name", "42", "isForShoes", true),
            Map.of("name", "42.5", "isForShoes", true),
            Map.of("name", "43", "isForShoes", true),
            Map.of("name", "43.5", "isForShoes", true),
            Map.of("name", "44", "isForShoes", true),
            Map.of("name", "44.5", "isForShoes", true),
            Map.of("name", "45", "isForShoes", true),
            Map.of("name", "45.5", "isForShoes", true),
            Map.of("name", "46", "isForShoes", true),
            Map.of("name", "46.5", "isForShoes", true),
            Map.of("name", "47", "isForShoes", true),
            Map.of("name", "47.5", "isForShoes", true),
            Map.of("name", "48", "isForShoes", true),
            Map.of("name", "48.5", "isForShoes", true),
            Map.of("name", "49", "isForShoes", true),
            Map.of("name", "49.5", "isForShoes", true),
            Map.of("name", "50", "isForShoes", true)
    );

    @Override
    public void run(String... args) throws Exception {
        initializeGenders();
        initializeProductSize();
//        initializeAdmins();
    }

    private void initializeGenders() {
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

//    private void initializeAdmins(){
//        if (!userRepository.existsById(1L)) {
//            User admin = new User();
//            admin.setId(1L);
//            admin.setRole(Role.ADMIN);
//            admin.setEmail("admin@ecommerce.com");
//            admin.setFirstName("Admin");
//            admin.setLastName("Admin");
//            admin.setBirthdate(Date.valueOf("2002-04-14"));
//            userRepository.save(admin);
//        }
//    }

    private void initializeProductSize() {
        if (productSizeRepository.count() == 0) {
            for (Map<String, Object> sizeData : productSizeData) {
                ProductSize productSize = new ProductSize();
                productSize.setName((String) sizeData.get("name"));
                productSize.setForShoes((boolean) sizeData.get("isForShoes"));
                productSizeRepository.save(productSize);
            }
            int i = 44;
            while (i <= 182) {
                ProductSize productSize = new ProductSize();
                productSize.setName(String.format("%d", i));
                productSize.setForKids(true);
                productSizeRepository.save(productSize);
                i += (i > 59) ? 2 : 1;
            }
        }
    }
}
