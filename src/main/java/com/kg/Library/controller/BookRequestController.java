package com.kg.Library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kg.Library.model.BookRequest;
import com.kg.Library.repository.BookRequestRepository;
import org.springframework.web.bind.annotation.RequestBody;
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
        System.out.println(bookRequestRepository.findAll());
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        List<BookRequest> br=bookRequestRepository.findAll().stream().filter(x->1 == (x.getUserid())).collect(Collectors.toList()); 
        Long likedbookstaken =bookRequestRepository.findAll().stream().filter(x->1 == (x.getUserid())).collect(Collectors.counting()); 
        System.out.println(likedbookstaken); 
        return bookRequestRepository.findAll();

    }
    @RequestMapping(value = "{requestid}", method = RequestMethod.PUT)
    public BookRequest update(@PathVariable Long requestid, @RequestBody BookRequest updatedRequest) {
        updatedRequest.setBookreqid(requestid);
        return bookRequestRepository.saveAndFlush(updatedRequest);
    }

    @RequestMapping(value = "{requestid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long requestid)
     {
        bookRequestRepository.deleteById(requestid);
    }
    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public   HashMap<String, String> findone(@PathVariable Long id) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        List<BookRequest> br=bookRequestRepository.findAll().stream().filter(x->1 == (x.getUserid())).collect(Collectors.toList()); 
        Long bookstaken =bookRequestRepository.findAll().stream().filter(x->x.getUserid() == (id)).collect(Collectors.counting());
        String result1 = mapper.writeValueAsString(br);
        String result2 = mapper.writeValueAsString(bookstaken); 
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("BookRequestlist", result1);
        hmap.put("BooksTaken",result2);
        System.out.println(hmap); 
        System.out.println(bookstaken); 
        // return bookRequestRepository.findById(id);
        return hmap;
    }
    @RequestMapping(value="/multiple/{id}",method = RequestMethod.GET)
    public Iterable<BookRequest> findMultipleDetails(@PathVariable Long id) throws JsonProcessingException
    {
        return bookRequestRepository.findbyuserid(id);
        
    }
}