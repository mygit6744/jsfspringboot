package com.yugandhar.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.yugandhar.dao.BookService;
import com.yugandhar.dto.Book;
import com.yugandhar.entity.Books;
import com.yugandhar.mappers.Mapper;
import com.yugandhar.util.SortUtils;

@ManagedBean(name = "bookTable")
@SessionScoped
public class BooksListController {

	public List<Book> bookList = new ArrayList<>();

	@ManagedProperty(value = "#{bookService}")
	private BookService bookService;
	
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public List<Book> getBooksList() {
		
		if (this.bookList.isEmpty()) {
			List<Books> booksList = bookService.getBooksList();
			bookList = Mapper.map(booksList);
		} else {
			if (!oldSort.equals(sortColumnName) || oldAscending != ascending) {
				SortUtils.sort(bookList, sortColumnName, bookidColumnName, booknameColumnName, 
						authorColumnName, priceColumnName, ascending);
				oldSort = sortColumnName;
				oldAscending = ascending;
			}
		}
		return bookList;
	}
	
	public String editBook() {
	
		return "addBook";
	}

	// dataTableColumn Names
	private static final String defaultSortColumn = "Book ID";
	private static final String bookidColumnName = "Book ID";
	private static final String booknameColumnName = "Book Name";
	private static final String authorColumnName = "Author";
	private static final String priceColumnName = "Price";

	public BooksListController() {
		  sortColumnName = defaultSortColumn;
	        ascending = true;
	        oldSort = sortColumnName;
	        // make sure sortColumnName on first render
	        oldAscending = !ascending;
	}
	 protected String sortColumnName;
	    protected boolean ascending;

	    // we only want to resort if the oder or column has changed.
	    protected String oldSort;
	    protected boolean oldAscending;
	public String getBookidColumnname() {
		return bookidColumnName;
	}

	public String getBooknameColumnname() {
		return booknameColumnName;
	}

	public String getAuthorColumnname() {
		return authorColumnName;
	}

	public String getPriceColumnname() {
		return priceColumnName;
	}
	
	 /**
     * Gets the sortColumnName column.
     *
     * @return column to sortColumnName
     */
    public String getSortColumnName() {
        return sortColumnName;
    }

    /**
     * Sets the sortColumnName column
     *
     * @param sortColumnName column to sortColumnName
     */
    public void setSortColumnName(String sortColumnName) {
        oldSort = this.sortColumnName;
        this.sortColumnName = sortColumnName;

    }

    /**
     * Is the sortColumnName ascending.
     *
     * @return true if the ascending sortColumnName otherwise false.
     */
    public boolean isAscending() {
        return ascending;
    }

    /**
     * Set sortColumnName type.
     *
     * @param ascending true for ascending sortColumnName, false for desending sortColumnName.
     */
    public void setAscending(boolean ascending) {
        oldAscending = this.ascending;
        this.ascending = ascending;
    }

	
}