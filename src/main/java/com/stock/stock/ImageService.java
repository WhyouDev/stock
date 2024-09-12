package com.stock.stock;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageService {
    private static final String IMAGE_DIR = "path/to/image/folder";

    public String saveImage(MultipartFile image) throws Exception {
        if (!image.getContentType().equals("image/jpeg") && !image.getContentType().equals("image/png")) {
            throw new IllegalArgumentException("Only JPG and PNG files are allowed.");
        }

        String imagePath = IMAGE_DIR + "/" + image.getOriginalFilename();
        Path path = Paths.get(imagePath);
        Files.write(path, image.getBytes());

        return imagePath;
    }
}
