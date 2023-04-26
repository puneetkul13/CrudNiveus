package com.example.CrudOperations;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.example.model.GuestBook;  
import com.example.service.GuestBookService;  
 
@RestController  
public class GuestBooksController   
{  

@Autowired  
GuestBookService booksService;  
  
@GetMapping("/guestbook")  
private List<GuestBook> getAllBooks()   
{  
return booksService.getAllGuestBooks();  
}  
 
@GetMapping("/book/{entryID}")  
private GuestBook getBooks(@PathVariable("entryID") int entryID)   
{  
return booksService.getGuestBooksById(entryID);  
}  

@DeleteMapping("/book/{entryID}")  
private void deleteBook(@PathVariable("entryID") int entryID)   
{  
booksService.delete(entryID);  
}  

@PostMapping("/books")  
private void saveBook(@RequestBody GuestBook books)   
{  
booksService.saveOrUpdate(books);  
  
}  

@PutMapping("/books")  
private GuestBook update(@RequestBody GuestBook books)   
{  
booksService.saveOrUpdate(books);  
return books;  
}  
}  
