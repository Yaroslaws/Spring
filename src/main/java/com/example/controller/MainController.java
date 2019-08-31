package com.example.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class MainController {

    private static final String DEFAULT_FILE_NAME = "/Users/yaroslav/IdeaProjects/Spring/uploads/067a3baf-0434-4d31-a329-d015c78983ab.0.png";
    @GetMapping("/")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {


        return "download";
    }


    @GetMapping("/download2")
    public ResponseEntity<Resource> downloadFile2(
            @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {

        Path path =  Paths.get( DEFAULT_FILE_NAME);
        byte[] data = Files.readAllBytes(path);
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + path.getFileName().toString())
                // Content-Lengh
                .contentLength(data.length) //
                .body(resource);
    }
}
