package com.example.CrudOperations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.model.guestbook;
import com.example.service.GuestBookService;
import com.example.CrudOperations.GuestBooksController;

@SpringBootTest
class CrudOperationsApplicationTests {
	@Autowired
	static GuestBookService booksService;

	@Test
	void saveBooks() {
		guestbook g = new guestbook("Punit", "Ohh", 2);
		GuestBooksController.saveBook(g);
		guestbook g1 = booksService.getGuestBooksById(2);
		assertEquals(g, g1);
	}

	@Test
	void getAllBooksTest() {

		List<guestbook> guestbook = booksService.getAllGuestBooks();
		List<guestbook> resultFromAPI = GuestBooksController.getAllBooks();
		assertEquals(guestbook, resultFromAPI);

	}

	@Test
	void getBooksTest() {
		guestbook g = GuestBooksController.getBooks(2);
		guestbook g1 = booksService.getGuestBooksById(2);
		assertEquals(g, g1);

	}

	@Test
	void updateBooksTest() {
		guestbook g = booksService.getGuestBooksById(2);
		g.setContent("I am here");
		guestbook g1 = GuestBooksController.update(g);
		guestbook g2 = booksService.getGuestBooksById(2);
		assertEquals(g1, g2);

	}

	@Test
	void deleteBooksTest() {
		GuestBooksController.deleteBook(2);
		guestbook g1 = booksService.getGuestBooksById(2);
		assertEquals(g1, null);
	}

}
