package com.ashwin.ukforum.service;

import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.model.Comment;

public interface CommentService {
	
    Comment getComment(Long id);

    Long saveNewComment(Comment comment, Article article);

    void deleteComment(Long commentId);

    void updateComment(Comment newComment, Long commentId);
}
