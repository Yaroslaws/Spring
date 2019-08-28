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

    private static final String DEFAULT_FILE_NAME = "D:/IdeaProjects/Spring/uploads/067a3baf-0434-4d31-a329-d015c78983ab.0.png";
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
//    @Autowired
//    private MessageRepo messageRepo;
//
//    @Value("${upload.path}")
//    private String uploadPath;

//    @GetMapping("/")
//    public String greeting(Map<String, Object> model) {
//        return "greeting";
//    }

//    @GetMapping("/main")
//    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
//        Iterable<Message> messages = messageRepo.findAll();
//
//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }
//
//        model.addAttribute("messages", messages);
//        model.addAttribute("filter", filter);
//
//        return "mainController";
//    }
//

//    @PostMapping("/main")
//    public String add(
//            @AuthenticationPrincipal User user,
//            @Valid Message message,
//            BindingResult bindingResult,
//            Model model,
//            @RequestParam("file") MultipartFile file
//    ) throws IOException {
//        message.setAuthor(user);
//
//        if (bindingResult.hasErrors()) {
//            System.out.println("No No No");
//            model.addAttribute("message", message);
//        } else {
//            if (file != null && !file.getOriginalFilename().isEmpty()) {
//                File uploadDir = new File(uploadPath);
//
//                if (!uploadDir.exists()) {
//                    uploadDir.mkdir();
//                }
//
//                String uuidFile = UUID.randomUUID().toString();
//                String resultFilename = uuidFile + "." + file.getOriginalFilename();
//
//                file.transferTo(new File(uploadPath + "/" + resultFilename));
//
//                message.setFilename(resultFilename);
//            }
//
//            model.addAttribute("message", null);
//
//            messageRepo.save(message);
//        }
//
//        Iterable<Message> messages = messageRepo.findAll();
//
//        model.addAttribute("messages", messages);
//
//        return "main";
//    }
//
}
