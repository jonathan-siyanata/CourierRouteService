package za.co.jaliatechnologies.accessingdatawithmysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    @Query(value = "select product from Product product where" +
            " product.product_type = :product_type")
    Product findProductType(@Param("product_type") String product_type);
}
