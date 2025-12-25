package com.siugi.marketplace.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {
    private final String uploadDir = "/workspaces/marketplace/upload/";

    public String save(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }

        try {
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // 파일 이름을 유니크하게 만들어줌.
            Path filepath = Paths.get(uploadDir).resolve(filename);

            Files.createDirectories(filepath.getParent());

            file.transferTo(filepath.toFile());

            return "/upload/" + filename;

        } catch (IOException e) {
            throw new RuntimeException("파일 저장 실패", e);
        }
    }
}

