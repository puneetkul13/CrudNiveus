package com.example.crudoperations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.*;
import com.example.service.GuestBookService;

@RestController
public class GuestBooksController {

	@Autowired
	static GuestBookService booksService;
	private GuestBooksController() {
		
	}
	@GetMapping("/guestbook")
	public static List<GuestBook> getAllBooks() {
		return booksService.getAllGuestBooks();
	}

	@GetMapping("/book/{entryID}")
	public
	static GuestBook getBooks(@PathVariable("entryID") int entryID) {
		return booksService.getGuestBooksById(entryID);
	}

	@DeleteMapping("/book/{entryID}")
	public
	static void deleteBook(@PathVariable("entryID") int entryID) {
		booksService.delete(entryID);
	}

	@PostMapping("/books")
	public
	static void saveBook(@RequestBody GuestBookRequestModel g) {
		GuestBook books = new GuestBook(g.guestName, g.content, g.entryID);
		booksService.saveOrUpdate(books);


	}

	@PutMapping("/books")
	public
	static GuestBook update(@RequestBody GuestBookRequestModel g) {
		GuestBook books = new GuestBook(g.guestName, g.content, g.entryID);
		booksService.saveOrUpdate(books);
		return books;
	}
}
