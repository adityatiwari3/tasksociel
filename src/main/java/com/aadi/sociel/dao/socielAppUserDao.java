package com.aadi.sociel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aadi.sociel.model.user;

@Repository
public interface socielAppUserDao extends JpaRepository<user,Long>{
    public user findByUserName(String commentTo);
}
