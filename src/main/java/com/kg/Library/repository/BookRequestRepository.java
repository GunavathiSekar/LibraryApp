package com.kg.Library.repository;

import java.io.Serializable;
import com.kg.Library.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRequestRepository extends JpaRepository<BookRequest, Serializable> {


}