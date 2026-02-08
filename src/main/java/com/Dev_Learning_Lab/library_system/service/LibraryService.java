package com.Dev_Learning_Lab.library_system.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Dev_Learning_Lab.library_system.model.LibraryModel;
import com.Dev_Learning_Lab.library_system.repository.LibraryRepository;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepo;

    public LibraryService(LibraryRepository libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    public List<LibraryModel> getByName(String name) {
        return libraryRepo.findByNameIgnoreCase(name);
    }

    public List<LibraryModel> getByDate(String date) {
        return libraryRepo.findByDate(date);
    }

    public List<LibraryModel> getByDescription(String description) {
        return libraryRepo.findByDescription(description);
    }

    
}