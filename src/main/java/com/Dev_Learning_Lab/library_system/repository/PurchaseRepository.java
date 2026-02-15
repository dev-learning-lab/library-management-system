package com.Dev_Learning_Lab.library_system.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.Dev_Learning_Lab.library_system.model.PurchaseModel;

@Repository
public interface PurchaseRepository extends MongoRepository<PurchaseModel, String>{
    
    List<PurchaseModel> findByBookId(String bookId);
    List<PurchaseModel> findByBookTitle(String bookTitle);

}
