package com.kg.boook.controller;

import com.kg.boook.model.Bookreview;
import com.kg.boook.model.Likereview;
import com.kg.boook.repository.BookLikeRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/booklike")
public class BookLikeController {
    @Autowired
    BookLikeRepository bookLikeRepository;

    @RequestMapping(value="/addbooklike", method=RequestMethod.POST)
    public Likereview savebookrLikereview(@RequestBody Likereview booklike)
    {
        return bookLikeRepository.saveAndFlush(booklike);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Likereview> read() {
        return bookLikeRepository.findAll();
    }
    @RequestMapping(value = "{likeid}", method = RequestMethod.PUT)
    public Likereview update(@PathVariable Long likeid, @RequestBody Likereview updatedBooklike) {
        updatedBooklike.setLikeid(likeid);
        return bookLikeRepository.saveAndFlush(updatedBooklike);
    }

    @RequestMapping(value = "{likeid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long likeid)
     {
        bookLikeRepository.deleteById(likeid);
    }
    @RequestMapping(value = "/getUserLikes/{userid}",method = RequestMethod.GET)
    public Iterable<Likereview> listuserReview(@PathVariable Long userid) {
        return bookLikeRepository.findbyreviewId(userid);
    }
}