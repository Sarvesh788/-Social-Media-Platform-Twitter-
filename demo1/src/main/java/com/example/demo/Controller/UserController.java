package com.example.demo.Controller;

import com.example.demo.Entity.Users;
import com.example.demo.DTO.postModel.PostResponse;
import com.example.demo.DTO.userModel.*;
import com.example.demo.Entity.Post;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.PostRepository;
import com.example.demo.DTO.commentModel.CommentResponse;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Optional<Users> userOptional = userRepository.findByEmail(email);
        Map<String, String> errorResponse = new HashMap<>();

        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            if (user.getPassword().equals(password)) {
                // Return success response
                return ResponseEntity.ok("Login Successful");
            } else {
                // Return error response (Incorrect password)
                errorResponse.put("Error", "Username/Password Incorrect");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }
        } else {
            // Return error response (User does not exist)
            errorResponse.put("Error", "User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "postID"));
        List<PostResponse> postResponses = posts.stream()
                .map(post -> new PostResponse(
                        post.getPostId(),
                        post.getPostBody(),
                        post.getDate(),
                        post.getComments().stream()
                                .map(comment -> new CommentResponse(
                                        comment.getCommentID(),
                                        comment.getCommentBody(),
                                        new UsersFetch(
                                                comment.getUser().getName(),
                                                comment.getUser().getUserID()
                                        )
                                )).collect(Collectors.toList())
                )).collect(Collectors.toList());
        return ResponseEntity.ok(postResponses);
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserSignup user) {
        // Check if required fields are present

        Map<String, String> errorResponse = new HashMap<>();
//        if (user.getEmail() == null || user.getName() == null || user.getPassword() == null) {
//            errorResponse.put("Error", "Required fields are missing");
//            return ResponseEntity.badRequest().body(errorResponse);
//        }

        // Check if the user already exists
        Optional<Users> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            errorResponse.put("Error", "Forbidden, Account already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
        Users newUser = new Users(user.getEmail(), user.getName(), user.getPassword());
        // Save the user
        userRepository.save(newUser);

        return ResponseEntity.ok("Account Creation Successful");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<Users> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream()
                .map(user -> new UserResponse(user.getName(), user.getUserID(), user.getEmail()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResponses);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserDetails(@RequestParam int userID) {
        Map<String, String> errorResponse = new HashMap<>();
        Optional<Users> userOptional = userRepository.findById(userID);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            errorResponse.put("Error", "User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}

