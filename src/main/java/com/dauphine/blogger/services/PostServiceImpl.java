package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repositories.PostRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        List<Post> allPosts = repository.findAll();
        List<Post> filteredPosts = new ArrayList<>();

        for(Post post : allPosts) {
            if(post.getCategory() != null && post.getCategory().getId().equals(categoryId)) {
                filteredPosts.add(post);
            }
        }
        return filteredPosts;
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public Post getById(UUID id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, Category category) {
        Post post = new Post(title, content, category);
        return repository.save(post);
    }


    @Override
    public Post update(UUID id, String title, String content) {
        Post post = getById(id);
        if(post != null) {
            post.setTitle(title);
            post.setContent(content);
            return repository.save(post);
        }
        return null;
    }

    @Override
    public boolean deleteById(UUID id) {
        repository.deleteById(id);
        return true;
    }

}
