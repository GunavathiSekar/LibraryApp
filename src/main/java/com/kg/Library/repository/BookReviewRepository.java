package com.kg.Library.repository;

import java.io.Serializable;
import com.kg.Library.model.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookReviewRepository extends JpaRepository<BookReview, Serializable> {
    @Query(value="select a.USERID,a.BOOKREVID,a.BOOKID,a.REVIEW,b.LIKEID,b.LIKESTATUS from BOOKREVIEW a join LIKEREVIEW b on a.USERID=b.USERID where a.USERID=:user_id",nativeQuery=true)
    Iterable<BookReview> findbyreviewId(@Param("user_id") Long user_id);
}