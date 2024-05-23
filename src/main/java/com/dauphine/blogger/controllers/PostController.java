package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(
        name = "PostController API",
        description = "Posts functionalities endpoints"
)
@RequestMapping("/v1/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping()
    @Operation(
            summary = "Retrieve all posts",
            description = "Return every post in the database"
    )
    public List<Post> retrieveAllPosts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Retrieve a post by id",
            description = "Return the post corresponding of a certain id"
    )
    public Post retrievePostById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping()
    @Operation(
            summary = "Create a new post",
            description = "Create a new post regarding a certain title, content, and category id"
    )
    public Post createPost(@RequestBody CreationPostRequest request) {
        return service.create(request.getTitle(), request.getContent(), request.getCategory());
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing post",
            description = "Update a post based on its id"
    )
    public Post updatePost(@PathVariable UUID id, @RequestParam String title, @RequestParam String content) {
        return service.update(id, title, content);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete an existing post",
            description = "Delete a post based on its id"
    )
    public void deletePost(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
