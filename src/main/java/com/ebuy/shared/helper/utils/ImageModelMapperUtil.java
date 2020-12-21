package com.ebuy.shared.helper.utils;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.ebuy.shared.helper.common.Constants.UPLOAD_DIR;

/**
 * @created 20/12/2020 - 11:08 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */
@Component
public class ImageModelMapperUtil {

    public String processImage(MultipartFile file, Model model){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            Path path = Paths.get(UPLOAD_DIR + "/productImages/" + fileName);
//            if (Files.exists(path)) {
//                model.addAttribute("errorMessage", "Image Already exists");
//                return "product_form";
//            }
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/productImages/" + fileName;
    }
}
