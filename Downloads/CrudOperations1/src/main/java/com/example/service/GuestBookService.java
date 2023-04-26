package com.example.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

import com.example.model.guestbook;
import com.example.repository.GuestBooksRepository;  

@Service  
public class GuestBookService  
{  
@Autowired  
GuestBooksRepository guestRepository;  

public List<guestbook> getAllGuestBooks()   
{  
List<guestbook> guestBooks = new ArrayList<guestbook>();  
guestRepository.findAll().forEach(guestBooks1 -> guestBooks.add(guestBooks1));  
return guestBooks;  
}  

public guestbook getGuestBooksById(int entryID)   
{  
return guestRepository.findById(entryID).get();  
}  

public void saveOrUpdate(guestbook books)   
{  
guestRepository.save(books);  
}  

public void delete(int entryID)   
{  
guestRepository.deleteById(entryID);  
}  

public void update(guestbook books, int entryID)   
{  
guestRepository.save(books);  
}  
} 
