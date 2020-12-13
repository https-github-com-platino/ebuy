package com.ebuy.admin.controller;

import com.ebuy.shared.database.entity.Category;
import com.ebuy.shared.database.entity.Product;
import com.ebuy.shared.service.CategoryService;
import com.ebuy.shared.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public String list(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "admin/product_list";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Product product = new Product();
        model.addAttribute("product", product);
        List<String> sizeList = Arrays.asList("XL", "XXL", "ML","S");
        model.addAttribute("sizeList", sizeList);
        return "admin/product_form";
    }
    @GetMapping("/update")
    public String updateProduct(@RequestParam("productId") long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product", product);
        return "admin/product_form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/product_form";
        }
        productService.save(product);
        return "redirect:/products/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") long id) {
        Product product = productService.findById(id);
        product.setDeleted(true);
        productService.save(product);
        return "redirect:/products/";
    }

}
