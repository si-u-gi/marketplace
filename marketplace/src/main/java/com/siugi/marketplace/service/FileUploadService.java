package com.siugi.marketplace.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    // 프로젝트 밖의 실제 저장 경로
    private final String uploadDir = "/workspaces/marketplace/upload/";

    public String save(MultipartFile file) {

        if (file.isEmpty()) {
            return null;
        }

        try {
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filepath = Paths.get(uploadDir + filename);

            Files.createDirectories(filepath.getParent());

            file.transferTo(filepath.toFile());

            return "/upload/" + filename;

        } catch (IOException e) {
            throw new RuntimeException("파일 저장 실패", e);
        }
    }
}

