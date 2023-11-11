package com.aadi.sociel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.aadi.sociel.model.comment;

@Repository
public interface sociealAppCommentDao extends JpaRepository<comment,Long>{
    public List<comment> findByPostedByUserId(Long userID);
    public List<comment> findByPostedForUserId(Long userID);

}
