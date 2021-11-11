package za.co.jaliatechnologies.accessingdatawithmysql.dto;

public class ProductDto {

    private Long product_id;
    private Long product_quantity;
    private String product_type;

    public ProductDto(Long product_id, Long product_quantity, String product_type) {
        this.product_id = product_id;
        this.product_quantity = product_quantity;
        this.product_type = product_type;
    }

    public ProductDto() {
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Long product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}
