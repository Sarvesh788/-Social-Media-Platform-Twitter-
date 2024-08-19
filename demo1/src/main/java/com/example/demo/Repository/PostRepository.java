package com.example.demo.Repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository // it makes this as a repository, making it spring-responsible, it also contains built-in methods like findAll and findBy, etc.
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAll(Sort sort); // it is built in
}
