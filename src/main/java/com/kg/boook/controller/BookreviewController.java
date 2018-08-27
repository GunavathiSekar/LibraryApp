package com.kg.boook.controller;

import java.util.HashMap;
import java.util.Optional;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import com.kg.boook.model.Book;
import com.kg.boook.model.BookCategory;
import com.kg.boook.model.Bookreview;
import com.kg.boook.model.Likereview;
import com.kg.boook.repository.BookLikeRepository;
import com.kg.boook.repository.BookReviewRepository;
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

import springfox.documentation.spring.web.json.Json;
@RestController
@RequestMapping(value = "/bookreview")
public class BookreviewController {
    @Autowired
    BookReviewRepository bookreviewRepository;

    @Autowired
    BookLikeRepository booklikeRepository;

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public Bookreview savebook(@RequestBody Bookreview bookreview)
    {
        return bookreviewRepository.saveAndFlush(bookreview);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Bookreview> read() {
        return bookreviewRepository.findAll();
    }
    @RequestMapping(value = "{bookreviewid}", method = RequestMethod.PUT)
    public Bookreview update(@PathVariable Long bookreviewid, @RequestBody Bookreview updatedBookreview) {
        updatedBookreview.setBookrevid(bookreviewid);
        return bookreviewRepository.saveAndFlush(updatedBookreview);
    }

    @RequestMapping(value = "{bookreviewid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long bookreviewid) {
        bookreviewRepository.deleteById(bookreviewid);
    }
    @RequestMapping(value = "/getUser/{userid}",method = RequestMethod.GET)
    public String listItems(@PathVariable Long userid) {
        // return bookreviewRepository.findbyreviewId(userid);
        Iterable<Bookreview> review=bookreviewRepository.findbyreviewId(userid);
        Iterable<Likereview> like= booklikeRepository.findbyreviewId(userid);
        System.out.println(review); System.out.println(like.toString());
        System.out.println(Iterables.concat(review,like));
        return  Iterables.concat(review,like).toString();
    }

    @RequestMapping(value = "/getReview/{userid}",method = RequestMethod.GET)
    public HashMap<String, String> listUserReview(@PathVariable Long userid) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Optional<Bookreview> review = bookreviewRepository.findById(userid);
        Bookreview brw=review.get();
        Optional<Likereview> like = booklikeRepository.findById(userid);
        Likereview lkrw=like.get();
        String res1 = mapper.writeValueAsString(brw);
        String res2 = mapper.writeValueAsString(lkrw); 
        String result = res1 + res2;
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("Bookreview", res1);
        hmap.put("Likereview", res2);
        return hmap;
    }

}