package com.yugandhar.util;

import java.util.Collections;
import java.util.List;

import com.yugandhar.dto.Book;

public class SortUtils {
	
	public static void sort(List<Book> bookList,String sortColumnName,String bookidColumnName,
			String booknameColumnName,String authorColumnName,String priceColumnName,
			boolean ascending) {

		if (sortColumnName.equals(bookidColumnName)) {
			Collections.sort(bookList, (p1, p2) -> {
				return ascending ? p1.getBookid().compareTo(p2.getBookid())
						: p2.getBookid().compareTo(p1.getBookid());
			});
		}
		else if (sortColumnName.equals(booknameColumnName)) {
			Collections.sort(bookList, (p1, p2) -> {
				return ascending ? p1.getBookname().toLowerCase().compareTo(p2.getBookname().toLowerCase())
						: p2.getBookname().toLowerCase().compareTo(p1.getBookname().toLowerCase());
			});
		}
		else if (sortColumnName.equals(authorColumnName)) {
			Collections.sort(bookList, (p1, p2) -> {
				return ascending ? p1.getAuthor().toLowerCase().compareTo(p2.getAuthor().toLowerCase())
						: p2.getAuthor().toLowerCase().compareTo(p1.getAuthor().toLowerCase());
			});
		}
		else if (sortColumnName.equals(priceColumnName)) {
			Collections.sort(bookList, (p1, p2) -> {
				return ascending ? p1.getPrice().compareTo(p2.getPrice()) : p2.getPrice().compareTo(p1.getPrice());
			});
		}

}

}
