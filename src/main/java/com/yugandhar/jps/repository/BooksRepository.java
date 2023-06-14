package com.yugandhar.jps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yugandhar.entity.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer>  
{  
	@Modifying
	@org.springframework.data.jpa.repository.Query("update Books u set u.bookname = :bookname where u.author = :author")
	int updateBooks(@Param("bookname") String bookname,@Param("author") String author);

	@Override
    List<Books> findAll();
	
	@Query(value = "CALL moneytransfer(:sender,:receiver,:amount);", nativeQuery = true)
	int executeStoredProc(@Param("sender") String sender,@Param("receiver") String receiver,@Param("amount") Integer amount);

}  