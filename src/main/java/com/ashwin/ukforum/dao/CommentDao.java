package com.ashwin.ukforum.dao;

import java.util.List;
import com.ashwin.ukforum.model.Comment;
 
public interface CommentDao {
 
	// CREATE Comment
    public void addComment(Comment comment);
    
    // READ Comment
    public Comment getComment(Long commentId);
 
    // UPDATE Comment
    public Comment updateComment(Comment comment);
    
    // DELETE Comment
    public void deleteComment(Long commentId);
    
    // LIST Comments for a given Article
    public List<Comment> getAllCommentsByArticleId(Long articleId);
    
    // LIST Comments for a given User
    public List<Comment> getAllCommentsByUserId(Long userId);  
}