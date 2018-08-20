package com.kg.Library.controller;

import com.kg.Library.model.BookRequest;
import com.kg.Library.repository.BookRequestRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/bookRequest")
public class BookRequestController {
    @Autowired
    BookRequestRepository bookRequestRepository;

    @RequestMapping(value="/addrequest", method=RequestMethod.POST)
    public BookRequest savebookrLikereview(@RequestBody BookRequest bookrequest)
    {
        return bookRequestRepository.saveAndFlush(bookrequest);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<BookRequest> read() {
        return bookRequestRepository.findAll();
    }
    @RequestMapping(value = "{requestid}", method = RequestMethod.PUT)
    public BookRequest update(@PathVariable Long requestid, @RequestBody BookRequest updatedRequest) {
        updatedRequest.setBookreqid(requestid);
        return bookRequestRepository.saveAndFlush(updatedRequest);
    }

    @RequestMapping(value = "{likeid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long requestid)
     {
        bookRequestRepository.deleteById(requestid);
    }
}