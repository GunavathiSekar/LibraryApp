package com.kg.Library.controller;

import org.springframework.web.bind.annotation.RequestBody;
import com.kg.Library.model.Book;
import com.kg.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public Book savebook(@RequestBody Book book)
    {
        return bookRepository.saveAndFlush(book);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> read() {
        return bookRepository.findAll();
    }
    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public Book findone(@PathVariable Long id) {
        return bookRepository.getOne(id);
    }
    @RequestMapping(value = "{bookid}", method = RequestMethod.PUT)
    public Book update(@PathVariable Long bookid, @RequestBody Book updatedBook) {
        updatedBook.setBookId(bookid);
        return bookRepository.saveAndFlush(updatedBook);
    }

    @RequestMapping(value = "{bookid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long bookid)
     {
        bookRepository.deleteById(bookid);
    }
}