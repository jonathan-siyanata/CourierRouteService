package za.co.jaliatechnologies.accessingdatawithmysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.dao.ProductDao;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.ProductDto;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Driver;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Product;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Product service imp.
 */
@Service
@Transactional
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();

        product.setProduct_id(productDto.getProduct_id());
        product.setProduct_type(productDto.getProduct_type());
        product.setProduct_quantity(productDto.getProduct_quantity());
        productDto.setProduct_id(productDao.save(product).getProduct_id());
        System.out.println("Product has been save and created!!");
        return productDto;
    }
    @Override
    public ProductDto createNewProduct(String product, Long productQuantity) {
        ProductDto productDto = new ProductDto();
        productDto.setProduct_type(product);
        productDto.setProduct_quantity(productQuantity);
        System.out.println("ProductDto has been populated!!");
        return productDto;
    }

    @Override
    public List<ProductDto> readAllProductInfo() {
        ProductDto productDto = new ProductDto();
        List<Product> productDtoList = (List<Product>) productDao.findAll();
        List<ProductDto> personDtoReturnList = new ArrayList(Arrays.asList(productDtoList));
        return personDtoReturnList;
    }

    @Override
    public ProductDto updateProductInfo(ProductDto productDto) {
        Optional<Product> productOptional = this.productDao.findById(productDto.getProduct_id());

        if(productOptional.isPresent()){
            Product updateProduct = productOptional.get();
            updateProduct.setProduct_id(productDto.getProduct_id());
            updateProduct.setProduct_type(productDto.getProduct_type());
            updateProduct.setProduct_quantity(productDto.getProduct_quantity());
            productDao.save(updateProduct);
            return productDto;
        }else {
            throw new ResourceNotFoundException("Product id : " + productDto.getProduct_id() + " not found");
        }
    }

    @Override
    public ProductDto delivery(Long productId) {
        Optional<Product> delivery = this.productDao.findById(productId);
        ProductDto productDto = new ProductDto();

        if(delivery.isPresent()){
            productDto.setProduct_id(delivery.get().getProduct_id());
            productDto.setProduct_quantity(delivery.get().getProduct_quantity());
            productDto.setProduct_type(delivery.get().getProduct_type());
            return productDto;
        }else{
            throw new ResourceNotFoundException("Product id : " + productId + " not found");
        }
    }



    @Override
    public void deleteProductInfo(Long productId) {
        Optional<Product> optionalProduct = this.productDao.findById(productId);

        if(optionalProduct.isPresent()){
            this.productDao.delete(optionalProduct.get());
        }else{
            throw new ResourceNotFoundException("Product id : " + productId + " not found");
        }

    }
}
