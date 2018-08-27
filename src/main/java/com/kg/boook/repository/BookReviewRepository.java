package com.kg.boook.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import com.kg.boook.model.Book;
import com.kg.boook.model.Bookreview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.data.repository.query.Param;

public interface BookReviewRepository extends JpaRepository<Bookreview, Long>
 {

@Query(value="select a.USERID,a.BOOKREVID,a.BOOKID,a.REVIEW,b.LIKEID,b.LIKESTATUS from BOOKREVIEW a join LIKEREVIEW b on a.USERID=b.USERID where a.USERID=:user_id",nativeQuery=true)
Iterable<Bookreview> findbyreviewId(@Param("user_id") Long user_id);
}