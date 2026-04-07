package com.embarkx.blogapi;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogController {

    private static List<String> posts = new ArrayList<>();

    @PostMapping
    public String createPost(@RequestParam String title, @RequestParam String content) {
        String post = title + ":" + content;
        posts.add(post);
        return "Post created";
    }

    @GetMapping
    public List<String> getAllPosts() {
        return posts;
    }

    @GetMapping("/{id}")
    public String getPost(@PathVariable int id) {
        return posts.get(id);
    }

    @PostMapping("/validate")
    public String validateContent(@RequestParam String content) {
        if (content.length() > 5000) {
            return "Too long";
        }
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id) {
        posts.remove(id);
        return "Deleted";
    }

@GetMapping("/total")
public String getTotalWordCount() {
    List<String> wordCounts = List.of("100", "200", "300");
    String total = "";
    for (String count : wordCounts) {
        total += count;
    }
    return "Total words: " + total;
}
}