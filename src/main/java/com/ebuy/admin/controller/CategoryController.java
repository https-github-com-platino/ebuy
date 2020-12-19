package com.ebuy.admin.controller;

import com.ebuy.shared.database.entity.Category;
import com.ebuy.shared.dataclass.requestDTO.CategoryRequestDto;
import com.ebuy.shared.dataclass.responseDTO.CategoryResponseDto;
import com.ebuy.shared.service.CategoryService;
import com.ebuy.shared.helper.utils.RequestModelMapperUtil;
import com.ebuy.shared.helper.utils.ResponseModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Nazim Uddin Asif
 * @created 11/12/2020 - 6:36 PM
 * @project ebuy
 */

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController {

    private final CategoryService categoryService;
    private final RequestModelMapperUtil requestModelMapperUtil;
    private final ResponseModelMapperUtil responseModelMapperUtil;

    @GetMapping("/")
    public String List(Model model) {
//        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", responseModelMapperUtil.getResponseDTOList(categoryService.findAll(), CategoryRequestDto.class));
        return "admin/category_list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new CategoryRequestDto());
        return "admin/category_form";
    }

    @GetMapping("/update")
    public String update(@RequestParam("categoryId") long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", responseModelMapperUtil.getResponseDTO(category, CategoryResponseDto.class));
        return "admin/category_form";
    }

    @PostMapping("/save")
    public String save(@Valid CategoryRequestDto categoryRequestDTO,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/category_form";
        } else if (categoryService.existsByName(categoryRequestDTO.getName())) {
            model.addAttribute("errorMessage", "Category Name Already exists");
            return "admin/category_form";
        }
        categoryService.save(requestModelMapperUtil.getRequestDTO(categoryRequestDTO, Category.class));
        return "redirect:/categories/";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("categoryId") long id) {
        categoryService.deleteById(id);
        return "redirect:/categories/";
    }
}
