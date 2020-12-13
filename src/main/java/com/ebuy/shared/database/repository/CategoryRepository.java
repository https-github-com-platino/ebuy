package com.ebuy.shared.database.repository;

import com.ebuy.shared.database.entity.Category;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @created 11/12/2020 - 6:36 PM
 * @project ebuy
 * @author Abdur Rahim Nishad
 */
@Repository
public interface CategoryRepository extends BaseRepository<Category> {
    boolean existsByName(String name);
}
