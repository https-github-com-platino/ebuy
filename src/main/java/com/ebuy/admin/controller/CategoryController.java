package com.ebuy.admin.controller;

import com.ebuy.shared.database.entity.Category;
import com.ebuy.shared.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String categoryList(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/category_list";
    }

    @GetMapping("/add")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/category_form";
    }

    @GetMapping("/update")
    public String updateCategory(@RequestParam("categoryId")long id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "admin/category_form";
    }

    @PostMapping("/save")
    public String saveCategory(@Valid @ModelAttribute("category") Category category,
                               BindingResult result, Model model) {
        if(result.hasErrors()){
            return "admin/category_form";
        }
//        else if(categoryService.existsByName(category.getName())) {
//            model.addAttribute("errorMessage","Category Name Already exists");
//            return "admin/category_form";
//        }
        categoryService.save(category);
        return "redirect:/categories/";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("categoryId")long id){

        Category category = categoryService.findById(id);
        category.setDeleted(true);
        categoryService.save(category);
        return "redirect:/categories/";
    }
}
