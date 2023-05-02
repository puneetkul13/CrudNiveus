package com.example.CrudOperations;

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

	@GetMapping("/guestbook")
	public static List<guestbook> getAllBooks() {
		return booksService.getAllGuestBooks();
	}

	@GetMapping("/book/{entryID}")
	static guestbook getBooks(@PathVariable("entryID") int entryID) {
		return booksService.getGuestBooksById(entryID);
	}

	@DeleteMapping("/book/{entryID}")
	static void deleteBook(@PathVariable("entryID") int entryID) {
		booksService.delete(entryID);
	}

	@PostMapping("/books")
	static void saveBook(@RequestBody guestbook books) {
		booksService.saveOrUpdate(books);

	}

	@PutMapping("/books")
	static guestbook update(@RequestBody guestbook books) {
		booksService.saveOrUpdate(books);
		return books;
	}
}
