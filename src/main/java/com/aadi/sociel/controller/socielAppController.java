package com.aadi.sociel.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aadi.sociel.model.comment;
import com.aadi.sociel.model.addComment;
import com.aadi.sociel.service.socielAppService;
import com.aadi.sociel.service.socielAppValidation;

@RestController
@RequestMapping("")
public class socielAppController {
    
    @Autowired
    socielAppService socielAppService;
    @Autowired
    socielAppValidation socielAppValidation;

    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestBody addComment data){
        String commentFrom = data.getCommentFrom();
        String commentTo = data.getCommentTo();
        if(!socielAppValidation.isValidUser(commentTo))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid name: " + commentTo);
        }
        if(!socielAppValidation.isValidUser(commentFrom))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid name: " + commentFrom);
        }
        return  socielAppService.addComment(data);
    }


    @GetMapping("/get/{commentTo}")
    public ResponseEntity<List<comment>> getComment(@PathVariable String commentTo){
        if(!socielAppValidation.isValidUser(commentTo))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return socielAppService.getComment(commentTo);
    }
}
