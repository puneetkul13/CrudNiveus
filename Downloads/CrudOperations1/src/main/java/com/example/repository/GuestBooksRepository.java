package com.example.repository;


     
import org.springframework.data.repository.CrudRepository;  
import com.example.model.guestbook;  

public interface GuestBooksRepository extends CrudRepository<guestbook, Integer>  
{  
}  

