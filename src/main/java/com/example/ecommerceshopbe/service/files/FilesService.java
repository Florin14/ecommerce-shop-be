package com.example.ecommerceshopbe.service.files;

import com.example.ecommerceshopbe.dao.model.Product;
import com.example.ecommerceshopbe.dao.model.ProductImage;
import com.example.ecommerceshopbe.dao.repository.ProductImageRepository;
import com.example.ecommerceshopbe.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FilesService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private ProductImageRepository productImageRepository;

    public String saveImageToDisk(MultipartFile image, Product product) {
        try {
            // Create a unique filename for the image
            String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();

            // Resolve the upload directory path
            Path uploadPath = Path.of(uploadDir).toAbsolutePath().normalize();

            // If the directory does not exist, create it
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Resolve the file path
            Path filePath = uploadPath.resolve(fileName).normalize();

            // Copy the image to the destination directory
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Save image information to the database
            ProductImage imageEntity = ProductImage.builder().imageUrl(fileName).product(product).build();
            productImageRepository.save(imageEntity);

            // Return the relative URL to be stored in the database
            return fileName;
        } catch (IOException e) {
            throw new FileStorageException("Failed to store file", e);
        }
    }
}
