package com.embarkx.blogapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogController {

    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    private static List<String> posts = new ArrayList<>();

    @PostMapping
    public String createPost(@RequestParam String title, @RequestParam String content) {
        logger.info("Creating post with title: {} and content: {}", title, content);
        String post = title + ":" + content;
        posts.add(post);
        logger.info("Post created: {}", post);
        return "Post created";
    }

    @GetMapping
    public List<String> getAllPosts() {
        logger.info("Getting all posts");
        logger.info("Found {} posts", posts.size());
        return posts;
    }

    @GetMapping("/{id}")
    public String getPost(@PathVariable int id) {
        logger.info("Getting post with id: {}", id);
        String post = posts.get(id);
        logger.info("Found post: {}", post);
        return post;
    }

    @PostMapping("/validate")
    public String validateContent(@RequestParam String content) {
        logger.info("Validating content: {}", content);
        if (content.length() > 5000) {
            logger.warn("Content is too long: {}", content.length());
            return "Too long";
        }
        logger.info("Content is valid");
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id) {
        logger.info("Deleting post with id: {}", id);
        posts.remove(id);
        logger.info("Post with id {} deleted", id);
        return "Deleted";
    }

    @GetMapping("/total")
    public String getTotalWordCount() {
        logger.info("Getting total word count");
        List<String> wordCounts = List.of("100", "200", "300");
        String total = "";
        for (String count : wordCounts) {
            total += count;
        }
        logger.info("Total word count: {}", total);
        return "Total words: " + total;
    }
}