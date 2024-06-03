package com.dauphine.blogger.controllers;

import com.dauphine.blogger.exceptions.CategoryNameAlreadyExistsException;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<List<Category>> retrieveAllCategories(@RequestParam(required = false) String name) {
        List<Category> categories = name == null || name.isBlank()
                ? service.getAll()
                : service.getAllLikeName(name);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Retrieve a category by id",
            description = "Return the category corresponding of a certain id"
    )
    public ResponseEntity<Category> retrieveCategoryById(@PathVariable UUID id) {
        try {
            Category category = service.getById(id);
            return ResponseEntity.ok(category);
        } catch (CategoryNotFoundByIdException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @Operation(
            summary = "Create a new category",
            description = "Create a new category regarding a certain name"
    )
    public ResponseEntity<Category> createCategory(@RequestBody String name) {
        try {
            Category category = service.create(name);
            return ResponseEntity
                    .created(URI.create("v1/categories/" + category.getId()))
                    .body(category);
        } catch (CategoryNameAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update the name of a category",
            description = "Update the name of an existing category"
    )
    public ResponseEntity<Category> updateCategory(@PathVariable UUID id, @RequestBody String name) {
        try {
            Category category = service.updateName(id, name);
            return ResponseEntity.ok(category);
        } catch (CategoryNotFoundByIdException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete an existing category",
            description = "Delete a category based on its id"
    )
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (CategoryNotFoundByIdException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
