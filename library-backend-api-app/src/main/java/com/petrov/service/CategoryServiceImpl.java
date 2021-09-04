package com.petrov.service;


import com.petrov.controller.dto.CategoryDto;
import com.petrov.persist.CategoryRepository;
import com.petrov.persist.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<CategoryDto> findById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> new CategoryDto(category.getId(),
                        category.getTitle(),
                        category.getDescription(),
                        category.getBooksTitles()));
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = new Category(
                categoryDto.getId(),
                categoryDto.getTitle(),
                categoryDto.getDescription());
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDto(category.getId(),
                        category.getTitle(),
                        category.getDescription(),
                        category.getBooksTitles()))
                .collect(Collectors.toList());
    }
}

