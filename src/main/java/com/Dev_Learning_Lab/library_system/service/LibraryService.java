package com.Dev_Learning_Lab.library_system.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.Dev_Learning_Lab.library_system.model.LibraryModel;
import com.Dev_Learning_Lab.library_system.repository.LibraryRepository;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<LibraryModel> getByName(String name) {
        return libraryRepository.findByNameIgnoreCase(name);
    }

    public List<LibraryModel> getByDate(String date) {
        return libraryRepository.findByDate(date);
    }

    public List<LibraryModel> getByDescription(String description) {
        return libraryRepository.findByDescription(description);
    }
}
