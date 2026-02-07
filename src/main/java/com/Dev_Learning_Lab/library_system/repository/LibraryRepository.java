package com.Dev_Learning_Lab.library_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.Dev_Learning_Lab.library_system.model.LibraryModel;
import java.util.List;

public interface LibraryRepository extends MongoRepository<LibraryModel, String> {

    List<LibraryModel> findByNameIgnoreCase(String name);

    List<LibraryModel> findByDescription(String description);

    List<LibraryModel> findByDate(String date);

    List<LibraryModel> findByAutor(String autor);
}
