package com.example.demo.Controller;

import com.example.demo.Entity.Comment;
import com.example.demo.DTO.commentModel.*;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/comment")
    public ResponseEntity<?> createComment(@RequestBody CommentCreate request) {
        String commentBody = request.getCommentBody();
        int postId = request.getPostID();
        Map<String, String> badResponse = new HashMap<>();
        int userId = request.getUserID();

        Optional<Users> userOptional = userRepository.findById(userId);
        Optional<Post> postOptional = postRepository.findById(postId);

        badResponse.put("Error", "User does not exist");
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(badResponse);
        }
        badResponse.clear();
        badResponse.put("Error", "Post does not exist");
        if (postOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(badResponse);
        }

        Post post = postOptional.get();
        Users user = userOptional.get();

        Comment comment = new Comment(commentBody, post, user);
        commentRepository.save(comment);
        return ResponseEntity.ok("Comment created successfully");
    }

    @GetMapping("/comment")
    public ResponseEntity<?> getComment(@RequestParam final int commentID) {
        Map<String, String> badResponse = new HashMap<>();

        Optional<Comment> commentOptional = commentRepository.findById(commentID);
        badResponse.put("Error", "Comment does not exist");
        if (commentOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(badResponse);
        }
        badResponse.clear();
        Comment comment = commentOptional.get();
        // Create the CommentCreator object
        CommentCreator commentCreator = new CommentCreator(
                comment.getUser().getUserID(),
                comment.getUser().getName()
        );

        // Create the CommentResponse object
        CommentClass commentResponse = new CommentClass(
                comment.getCommentID(),
                comment.getCommentBody(),
                commentCreator
        );
        return ResponseEntity.ok(commentResponse);
    }



    @DeleteMapping("/comment")
    public ResponseEntity<?> deleteComment(@RequestParam final int commentID) {
        Optional<Comment> commentOptional = commentRepository.findById(commentID);

        if (commentOptional.isPresent()) {
            commentRepository.delete(commentOptional.get());
            return ResponseEntity.ok("Comment deleted");
        }
        Map<String, String> badResponse = new HashMap<>();
        badResponse.put("Error", "Comment does not exist");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(badResponse);
    }

    @PatchMapping("/comment")
    public ResponseEntity<?> editComment(@RequestBody CommentUpdate request) {
        int commentId = request.getCommentID();
        String newCommentBody = request.getCommentBody();

        Map<String, String> badResponse = new HashMap<>();
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isEmpty()) {
            badResponse.put("Error", "Comment does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(badResponse);
        }
        else {
            Comment comment = commentOptional.get();
            comment.setCommentBody(newCommentBody);
            commentRepository.save(comment);
            return ResponseEntity.ok("Comment edited successfully");
        }
    }
}
