package com.yugandhar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yugandhar.entity.Books;
import com.yugandhar.jps.repository.BooksRepository;

@Service
public class BookService {
	
	
	@Autowired
	private BooksRepository booksRepository;

	public List<Books> getBooksList() {
		return booksRepository.findAll();
	}
}
