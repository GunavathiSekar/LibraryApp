package com.kg.Library.repository;

import java.io.Serializable;

import com.kg.Library.model.LikeReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeReviewRepository extends JpaRepository<LikeReview, Serializable> {
    @Query(value="select b.LIKEID,b.LIKESTATUS,b.USERID,b.BOOKREWID,a.BOOKID,a.REVIEW from LIKEREVIEW b join BOOKREVIEW a on b.USERID=a.USERID where b.USERID=:user_id",nativeQuery=true)
    Iterable<LikeReview> findbyreviewId(@Param("user_id") Long user_id);

}