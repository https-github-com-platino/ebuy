package com.ebuy.admin.controller;

import com.ebuy.shared.database.entity.Product;
import com.ebuy.shared.dataclass.requestDTO.CategoryRequestDto;
import com.ebuy.shared.dataclass.requestDTO.ProductRequestDto;
import com.ebuy.shared.dataclass.responseDTO.CategoryResponseDto;
import com.ebuy.shared.dataclass.responseDTO.ProductResponseDto;
import com.ebuy.shared.helper.utils.ImageModelMapperUtil;
import com.ebuy.shared.service.CategoryService;
import com.ebuy.shared.service.ProductService;
import com.ebuy.shared.helper.utils.RequestModelMapperUtil;
import com.ebuy.shared.helper.utils.ResponseModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private final ImageModelMapperUtil imageModelMapperUtil;

    @ModelAttribute
    public void init(Model model){
        model.addAttribute("sizeList", Arrays.asList("XL", "XXL", "ML","S"));
        model.addAttribute("categories",  responseModelMapperUtil.getResponseDTOList(categoryService.findAll(), CategoryRequestDto.class));
    }

    @GetMapping("/")
    public String list(Model model) {
        List<ProductResponseDto> productResponseDtos = responseModelMapperUtil.getResponseDTOList(productService.findAll(), ProductResponseDto.class);
        model.addAttribute("products", productResponseDtos);
        return "admin/product_list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product",new ProductRequestDto());
        return "admin/product_form";
    }
    @GetMapping("/update")
    public String update(@RequestParam("productId") long id, Model model) {
        model.addAttribute("product", responseModelMapperUtil.getResponseDTO(productService.findById(id), ProductResponseDto.class));
        return "admin/product_form";
    }

    @PostMapping("/save")
    public String save(@Valid ProductRequestDto productRequestDto, BindingResult result, @RequestParam("file") MultipartFile file, Model model) {
        if (result.hasErrors()) {
            return "admin/product_form";
        }
        if (!file.isEmpty()) {
            //return "redirect:/";
//            productRequestDto.setImages(imageModelMapperUtil.processImage(file, model));
        }
        productRequestDto.setImages(imageModelMapperUtil.processImage(file, model));
        productService.save(requestModelMapperUtil.getRequestDTO(productRequestDto, Product.class));

        return "redirect:/products/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") long id) {
        productService.deleteById(id);
        return "redirect:/products/";
    }

}
