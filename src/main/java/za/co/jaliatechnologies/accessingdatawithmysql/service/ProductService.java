package za.co.jaliatechnologies.accessingdatawithmysql.service;

import za.co.jaliatechnologies.accessingdatawithmysql.dto.ProductDto;

import java.util.List;

/**
 * The interface Product service.
 */
public interface ProductService {

    /**
     * Create the product to be delivered
     *
     * @param productDto contains the product information
     * @return the ProductDto consist of the product to be delivered
     */
    ProductDto createProduct(ProductDto productDto);

    /**
     * Returns all products available
     *
     * @return the list of products that are to be delivered
     */
    List<ProductDto> readAllProductInfo();

    /**
     * Deletes product according to product id
     *
     * @param productId of the product to be deleted
     */
    void deleteProductInfo(Long productId);

    /**
     * Updates a product
     *
     * @param productDto contains the information used to updated a particular product
     * @return the ProductDto which contains the updated information
     */
    ProductDto updateProductInfo (ProductDto productDto);

    /**
     * Attaches a product to a delivery
     *
     * @param productId of the product to be delivered
     * @return the ProductDto which contains the product information to be used for the delivery
     */
    ProductDto delivery(Long productId);

    /**
     * Creates a new product
     *
     * @param productType     is the new product you want tp create
     * @param productQuantity the number of items
     * @return the ProductDto which contains the information of the product
     */
    ProductDto createNewProduct(String productType, Long productQuantity);
}
