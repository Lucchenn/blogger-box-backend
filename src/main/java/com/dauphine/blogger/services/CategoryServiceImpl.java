package com.dauphine.blogger.services;

import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll(){
        return repository.findAll();
    }

    @Override
    public List<Category> getAllLikeName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Category getById(UUID id) throws CategoryNotFoundByIdException {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundByIdException(id));
    }

    @Override
    public Category create(String name){
        Category category = new Category(name);
        return repository.save(category);
    }

    @Override
    public Category updateName(UUID id, String newName){
        Category category = repository.getById(id);
        if (category != null){
            category.setName(newName);
            return repository.save(category);
        }
        return null;
    }

    @Override
    public boolean deleteById(UUID id){
        repository.deleteById(id);
        return true;
    }


}
