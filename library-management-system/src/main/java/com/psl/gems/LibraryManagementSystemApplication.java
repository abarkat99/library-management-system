package com.psl.gems;

import javax.transaction.Transactional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.psl.gems.dao.BookObjRepository;
import com.psl.gems.dao.BookRepository;
import com.psl.gems.dao.UserRepository;
import com.psl.gems.model.Book;
import com.psl.gems.model.BookObj;
import com.psl.gems.model.User;

@SpringBootApplication
public class LibraryManagementSystemApplication {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookObjRepository bookObjRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}
	
	@Bean
	@Transactional
	InitializingBean initialCode() {
		return () -> {
			User user = new User();
			user.setName("Admin");
			user.setUsername("admin");
			user.setPassword("user");
			user.setRole("librarian");
			userRepository.save(user);
			for (User usr : userRepository.findAll()) {
				System.out.println(usr);
			}
			
//			Book book = new Book();
//			book.setISBN(1);
//			book = bookRepository.save(book);
//			BookObj bookObj = new BookObj();
//			bookObj.setBook(book);
//			bookObj = bookObjRepository.save(bookObj);
//			
//			System.out.println(bookObjRepository.findFirstAvailableCopyByBookId(book.getISBN()));
		};
	}

}
