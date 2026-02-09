package com.Dev_Learning_Lab.library_system.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.Dev_Learning_Lab.library_system.model.LibraryModel;
import com.Dev_Learning_Lab.library_system.service.LibraryService;
import java.util.List;

@RestController  
@RequestMapping("/api/books")  
public class LibraryController {
    
    private final LibraryService libraryService;
    
    
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    
    
    
}