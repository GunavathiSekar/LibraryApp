package com.kg.Library.repository;

import java.io.Serializable;
import java.util.List;
import com.kg.Library.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRequestRepository extends JpaRepository<BookRequest, Serializable> {
    // @Query(value="select distinct(b.BOOKCAT_ID ),c.NAME from BOOK_REQUEST br join BOOK b on br.BOOKID=b.BOOK_ID join Book_Category c on b.bookcat_id=c.bookcat_id where br.USERID=:user_id",nativeQuery=true)
    // Iterable<BookRequest> findbyuserid(@Param("user_id") Long user_id);
    @Query(value="SELECT count(DISTINCT br.BOOKID) as 'Book Request Count',count(DISTINCT b.BOOKCAT_ID) as 'Book Category Count',count(DISTINCT rv.BOOKID)*5 as 'Book Review Points' FROM BOOK_REQUEST br,BOOK b,BOOK_REVIEW rv where b.BOOK_ID=br.BOOKID and b.BOOK_ID=rv.BOOKID and rv.USERID=:user_id",nativeQuery=true)
    Iterable<BookRequest> findbyuserid(@Param("user_id") Long user_id);
    // public List<BookRequest> findByUserid(Long userid);
}