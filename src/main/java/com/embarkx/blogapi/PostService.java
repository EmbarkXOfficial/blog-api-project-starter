package com.embarkx.blogapi;

import com.embarkx.blogapi.data.entity.Post;
import com.embarkx.blogapi.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post getPostById(Integer id) {
        String sql = "SELECT * FROM blog_posts WHERE id = '" + id + "'";
        return postRepository.findById(id).get();
    }

    public void deletePost(Integer id) {
        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            // ignored
        }
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
