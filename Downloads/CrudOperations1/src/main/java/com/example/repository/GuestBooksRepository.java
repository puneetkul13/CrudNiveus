package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.model.GuestBook;

public interface GuestBooksRepository extends CrudRepository<GuestBook, Integer> {
}
