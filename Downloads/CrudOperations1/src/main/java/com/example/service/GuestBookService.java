package com.example.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.example.model.GuestBook;  
import com.example.repository.GuestBooksRepository;  

@Service  
public class GuestBookService  
{  
@Autowired  
GuestBooksRepository guestRepository;  

public List<GuestBook> getAllGuestBooks()   
{  
List<GuestBook> guestBooks = new ArrayList<GuestBook>();  
guestRepository.findAll().forEach(guestBooks1 -> guestBooks.add(guestBooks1));  
return guestBooks;  
}  

public GuestBook getGuestBooksById(int entryID)   
{  
return guestRepository.findById(entryID).get();  
}  

public void saveOrUpdate(GuestBook books)   
{  
guestRepository.save(books);  
}  

public void delete(int entryID)   
{  
guestRepository.deleteById(entryID);  
}  

public void update(GuestBook books, int entryID)   
{  
guestRepository.save(books);  
}  
} 
