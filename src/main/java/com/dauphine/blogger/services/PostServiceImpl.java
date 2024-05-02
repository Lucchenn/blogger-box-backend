package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.models.Category;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> temporaryPosts;
    private final CategoryServiceImpl categoryService;


    public PostServiceImpl(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
        temporaryPosts = new ArrayList<>();
        temporaryPosts.add(new Post(UUID.randomUUID(), "First Post", "Content of the first post", new Date(), new Category(UUID.randomUUID(), "Category 1")));
        temporaryPosts.add(new Post(UUID.randomUUID(), "Second Post", "Content of the second post", new Date(), new Category(UUID.randomUUID(), "Category 2")));
        temporaryPosts.add(new Post(UUID.randomUUID(), "Third Post", "Content of the third post", new Date(), new Category(UUID.randomUUID(), "Category 3")));
    }

    @Override
    public List<Post> getAllCategoryById(UUID categoryId) {
        Category category = categoryService.getById(categoryId);
        if (category == null) {
            // Gérer le cas où la catégorie n'existe pas
            return new ArrayList<>();
        }
        return category.getPosts();
    }

    @Override
    public List<Post> getAll() {
        return temporaryPosts;
    }

    @Override
    public Post getById(UUID id) {
        return temporaryPosts.stream()
                .filter(post -> id.equals(post.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, UUID categoryId) {
        Category category = getCategoryById(categoryId);
        if (category == null) {
            // Handle invalid category ID
            return null;
        }
        Post post = new Post(UUID.randomUUID(), title, content, new Date(), category);
        temporaryPosts.add(post);
        return post;
    }


    @Override
    public Post update(UUID id, String title, String content, UUID categoryId) {
        Post postToUpdate = getById(id);
        if (postToUpdate == null) {
            // Handle post not found
            return null;
        }
        Category category = getCategoryById(categoryId);
        if (category == null) {
            // Handle invalid category ID
            return null;
        }
        postToUpdate.setTitle(title);
        postToUpdate.setContent(content);
        postToUpdate.setCategory(category);
        return postToUpdate;
    }

    @Override
    public void deleteById(UUID id) {
        temporaryPosts.removeIf(post -> id.equals(post.getId()));
    }

    private Category getCategoryById(UUID categoryId) {
        return categoryService.getById(categoryId);
    }


}
