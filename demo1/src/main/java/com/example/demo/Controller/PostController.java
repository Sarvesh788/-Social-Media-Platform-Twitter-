package com.example.demo.Controller;

import com.example.demo.Entity.Post;
import com.example.demo.DTO.postModel.PostRequest;
import com.example.demo.DTO.postModel.PostResponse;
import com.example.demo.DTO.postModel.PostUpdate;
import com.example.demo.Entity.Users;
import com.example.demo.DTO.userModel.UsersFetch;
import com.example.demo.DTO.commentModel.CommentResponse;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Autowired
    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/post")
    public ResponseEntity<?> getPostById(@RequestParam int postID) {
        Map<String, String> errorResponse = new HashMap<>();
        // Retrieve the post by ID
        Optional<Post> postOptional = postRepository.findById(postID);
        if (postOptional.isPresent()) {
            // Return the post if found
            Post post = postOptional.get();
            List<CommentResponse> commentResponses = post.getComments().stream()
                    .map(comment -> new CommentResponse(
                            comment.getCommentID(),
                            comment.getCommentBody(),
                            new UsersFetch(
                                    comment.getUser().getName(),
                                    comment.getUser().getUserID()
                            )
                    )).collect(Collectors.toList());

            PostResponse postResponse = new PostResponse(
                    post.getPostId(),
                    post.getPostBody(),
                    post.getDate(),
                    commentResponses
            );
            return ResponseEntity.ok(postResponse);
        }
        // Return error message if the post does not exist
        errorResponse.put("Error", "Post does not exist");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequest request) {
        // Extract postBody and userID from the request
        String postBody = request.getPostBody();
        int userID = request.getUserID();
        Map<String, String> errorResponse = new HashMap<>();

        // Check if the user exists
        Optional<Users> userOptional = userRepository.findById(userID);
        errorResponse.put("Error", "User does not exist");
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        errorResponse.clear();
        // User exists, create the post
        Users user = userOptional.get();
        Post post = new Post(postBody, user);
        postRepository.save(post);

        return ResponseEntity.ok("Post created successfully");
    }


    @PatchMapping("post")
    public ResponseEntity<?> editPost(@RequestBody PostUpdate request) {
        int postID = request.getPostID();
        String postBody = request.getPostBody();
        Map<String, String> errorResponse = new HashMap<>();

        // Check if the post exists
        Optional<Post> existingPostOptional = postRepository.findById(postID);
        if (existingPostOptional.isEmpty()) {
            errorResponse.put("Error", "Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        // Get the existing post
        Post existingPost = existingPostOptional.get();

        // Update the post body if provided
        if (postBody != null) {
            existingPost.setPostBody(postBody);
        }

        // Save the updated post
        postRepository.save(existingPost);

        return ResponseEntity.ok("Post edited successfully");
    }

    @DeleteMapping("post")
    public ResponseEntity<?> deletePost(@RequestParam int postID) {
        // Check if the post exists
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", "Post does not exist");
        if (!postRepository.existsById(postID)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        errorResponse.clear();
        // Delete the post
        postRepository.deleteById(postID);

        return ResponseEntity.ok("Post deleted");
    }
}

