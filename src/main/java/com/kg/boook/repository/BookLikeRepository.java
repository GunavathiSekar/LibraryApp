package com.kg.boook.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import com.kg.boook.model.Book;
import com.kg.boook.model.Likereview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookLikeRepository extends JpaRepository<Likereview, Serializable> {
    @Query(value="select b.LIKEID,b.LIKESTATUS,b.USERID,b.BOOKREWID,a.BOOKID,a.REVIEW from LIKEREVIEW b join BOOKREVIEW a on b.USERID=a.USERID where b.USERID=:user_id",nativeQuery=true)
    Iterable<Likereview> findbyreviewId(@Param("user_id") Long user_id);

}