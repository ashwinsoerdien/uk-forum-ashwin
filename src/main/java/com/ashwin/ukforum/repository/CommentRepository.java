package com.ashwin.ukforum.repository;

import com.ashwin.ukforum.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> 
{
	
}