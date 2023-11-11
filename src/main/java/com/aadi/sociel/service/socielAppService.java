package com.aadi.sociel.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aadi.sociel.dao.sociealAppCommentDao;
import com.aadi.sociel.dao.socielAppUserDao;
import com.aadi.sociel.model.comment;
import com.aadi.sociel.model.addComment;
import com.aadi.sociel.model.user;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class socielAppService {
    
    @Autowired
    sociealAppCommentDao sociealCommentAppDao;
    @Autowired
    socielAppUserDao socielAppUserDao;
    user getUserComment;
    user postedForUser;
    user postedByUser;
    comment comment;

    @Transactional
    public ResponseEntity<String> addComment(addComment data){
        
        try {
            postedForUser = socielAppUserDao.findByUserName(data.getCommentTo());
            postedByUser = socielAppUserDao.findByUserName(data.getCommentFrom());
            Date curdate = new Date();
            // System.out.println("this is user : "+user);
            if(postedForUser == null)
            {
                user newUser = new user(data.getCommentTo(),curdate);
                postedForUser = socielAppUserDao.save(newUser);
                System.out.println("userTo added successfully");
            }
            if(postedByUser == null)
            {
                user newUser = new user(data.getCommentFrom(),curdate);
                postedByUser = socielAppUserDao.save(newUser);
                System.out.println("userFrom added successfully");
            }
            comment newComment = new comment(data.getMessage(),curdate,postedByUser.getUserID(),postedForUser.getUserID());
            sociealCommentAppDao.save(newComment);
            return ResponseEntity.of(Optional.of("Comment Added Successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @Transactional
    public ResponseEntity<List<comment>> getComment(String postedForUser){
        try {
            getUserComment = socielAppUserDao.findByUserName(postedForUser);
            System.out.println("this is getUserComment : in service  : " + getUserComment);
            if(getUserComment == null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            List<comment> list =(List<comment>)sociealCommentAppDao.findByPostedForUserId(getUserComment.getUserID());
            System.out.println("this is list of comment : "+list);
            return ResponseEntity.of(Optional.of(list));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
