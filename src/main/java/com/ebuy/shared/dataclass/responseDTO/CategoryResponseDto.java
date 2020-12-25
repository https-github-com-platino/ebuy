package com.ebuy.shared.dataclass.responseDTO;

import com.ebuy.shared.database.entity.Category;
import lombok.Data;
/**
 * @created 14/12/2020 - 11:36 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */

@Data
public class CategoryResponseDto {
    private long id;
    private String name;
}
