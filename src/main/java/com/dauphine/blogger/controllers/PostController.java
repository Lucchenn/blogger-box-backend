package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(
        name = "PostController API",
        description = "Posts functionalities endpoints"
)
@RequestMapping("/v1/posts")
public class PostController {
    ;
    private List<Post> posts;

    @PostMapping()
    @Operation(
            summary = "Create a new post",
            description = "Create a new post with specified details"
    )
    public void createPost(@RequestBody Post post) {
        posts.add(post);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing post",
            description = "Update an existing post with specified details"
    )
    public void updatePost(@PathVariable int id, @RequestBody Post updatedPost) {
        if (id < posts.size()) {
            posts.set(id, updatedPost);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete an existing post",
            description = "Delete an existing post based on its id"
    )
    public void deletePost ( @PathVariable int id){
        if (id < posts.size()) {
            posts.remove(id);
        }
    }

    @GetMapping("/orderedByCreationDate")
    @Operation(
            summary = "Retrieve all posts ordered by creation date",
            description = "Return all posts sorted by their creation date"
    )
    public List<Post> getAllPostsOrderedByCreationDate () {
            // Implement logic to retrieve all posts and sort them by creation date
        return posts;
    }

    /*
    @GetMapping("/byCategory/{categoryId}")
    @Operation(
            summary = "Retrieve all posts per a category",
            description = "Return all posts within a certain category"
    )
    public List<Post> getAllPostsByCategory ( @PathVariable int categoryId){
        List<Post> postsByCategory = new ArrayList<>();
        for (Post post : posts) {
            if (post.getCategory().getId() == categoryId) {
                postsByCategory.add(post);
            }
        }
        return postsByCategory;
    }
    */
}

