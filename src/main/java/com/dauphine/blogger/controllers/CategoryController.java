package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(
        name = "CategoryController API",
        description = "Categories functionalities endpoints"
)
@RequestMapping("/v1/categories")
public class CategoryController {
    private List<Category> categories;


    @GetMapping()
    @Operation(
            summary = "Retrieve all categories",
            description = "Return every category in the database"
    )
    public List<Category> getCategories() {
        return categories;
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Retrieve a category by id",
            description = "Return the category corresponding of a certain id"
    )
    public Category getCategoryById(@PathVariable int id) {
        return categories.get(id);
    }

    @PostMapping("/{name}")
    @Operation(
            summary = "Create a new category",
            description = "Create a new category regarding a certain name"
    )
    public Category createCategory(@PathVariable String name) {
        Category category = new Category();
        category.setName(name);
        categories.add(category);
        return category;
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update the name of a category",
            description = "Update the name of an existing category"
    )
    public void updateName(@PathVariable int id, @RequestParam String name) {
        Category category = categories.get(id);
        category.setName(name);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete an existing category",
            description = "Delete a category based on its id"
    )
    public void deleteCategory(@PathVariable int id) {
        categories.remove(id);
    }


}
