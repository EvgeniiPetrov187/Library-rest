package com.petrov.controller;

import com.petrov.controller.dto.CategoryDto;
import com.petrov.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // отображение всех категорий
    @GetMapping(path = "/all", produces = "application/json")
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }


    // отображение категории по ID
    @GetMapping(path = "/{id}", produces = "application/json")
    public CategoryDto findById(@PathVariable("id") Long id) {
        return categoryService.findById(id)
                .orElseThrow(()-> new NotFoundException("Book not found"));
    }

    // создание категории
    @PostMapping(produces = "application/json")
    public CategoryDto create(@RequestBody CategoryDto categoryDto) throws BadRequestException {
        if(categoryDto.getId() != null){
            throw new BadRequestException("Request false");
        }
        categoryService.save(categoryDto);
        return categoryDto;
    }

    // обновление категории
    @PutMapping(produces = "application/json")
    public void update(@RequestBody CategoryDto categoryDto) throws BadRequestException {
        if(categoryDto.getId() == null){
            throw new BadRequestException("Request false");
        }
        categoryService.save(categoryDto);
    }

    // удаление категории
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void delete(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
    }

}
