package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(
        name = "CategoryController API",
        description = "Categories functionalities endpoints"
)
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping()
    @Operation(
            summary = "Retrieve all categories",
            description = "Return every category in the database"
    )
    public List<Category> retrieveAllCategories() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Retrieve a category by id",
            description = "Return the category corresponding of a certain id"
    )
    public Category retrieveCategoryById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping()
    @Operation(
            summary = "Create a new category",
            description = "Create a new category regarding a certain name"
    )
    public Category createCategory(@RequestBody String name) {
        return service.create(name);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update the name of a category",
            description = "Update the name of an existing category"
    )
    public Category updateCategory(@PathVariable UUID id, @RequestBody String name) {
        return service.updateName(id, name);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete an existing category",
            description = "Delete a category based on its id"
    )
    public void deleteCategory(@PathVariable UUID id) {
        service.deleteById(id);
    }


}
