package com.ebuy.admin.controller;

import com.ebuy.shared.database.entity.Product;
import com.ebuy.shared.dataclass.requestDTO.CategoryRequestDto;
import com.ebuy.shared.dataclass.requestDTO.ProductRequestDto;
import com.ebuy.shared.dataclass.responseDTO.ProductResponseDto;
import com.ebuy.shared.service.CategoryService;
import com.ebuy.shared.service.ProductService;
import com.ebuy.shared.helper.utils.RequestModelMapperUtil;
import com.ebuy.shared.helper.utils.ResponseModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * @created 11/12/2020 - 6:36 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final RequestModelMapperUtil requestModelMapperUtil;
    private final ResponseModelMapperUtil responseModelMapperUtil;

    @GetMapping("/")
    public String list(Model model) {
//        List<ProductResponseDto> productResponseDtos = responseModelMapperUtil.getResponseDTOList(productService.findAll(), ProductResponseDto.class);
        model.addAttribute("products", responseModelMapperUtil.getResponseDTOList(productService.findAll(), ProductResponseDto.class));
        return "admin/product_list";
    }
    @ModelAttribute
    public void init(Model model){
//        List<CategoryRequestDto> categoryRequestDto = responseModelMapperUtil.getResponseDTOList(categoryService.findAll(), CategoryRequestDto.class);
        model.addAttribute("categories",  responseModelMapperUtil.getResponseDTOList(categoryService.findAll(), CategoryRequestDto.class));
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product",new ProductRequestDto());
        model.addAttribute("sizeList", Arrays.asList("XL", "XXL", "ML","S"));
        return "admin/product_form";
    }
    @GetMapping("/update")
    public String update(@RequestParam("productId") long id, Model model) {
        model.addAttribute("categories", responseModelMapperUtil.getResponseDTOList(categoryService.findAll(), CategoryRequestDto.class));
        model.addAttribute("product", responseModelMapperUtil.getResponseDTO(productService.findById(id), ProductResponseDto.class));
        return "admin/product_form";
    }

    @PostMapping("/save")
    public String save(@Valid ProductRequestDto productRequestDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/product_form";
        }
        Product p =requestModelMapperUtil.getRequestDTO(productRequestDto, Product.class);
        productService.save(p);

        return "redirect:/products/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") long id) {
        productService.deleteById(id);
        return "redirect:/products/";
    }

}
