package com.ebuy.shared.database.repository;

import com.ebuy.shared.database.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @created 11/12/2020 - 6:36 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 * @author Abdur Rahim Nishad
 */
@Repository
public interface ProductRepository extends BaseRepository<Product> {

    @Query(value = "SELECT size FROM product where id=?1", nativeQuery = true)
    String getSizeNameById(long id);
}
