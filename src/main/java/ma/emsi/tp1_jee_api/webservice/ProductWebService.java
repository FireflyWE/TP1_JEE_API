package ma.emsi.tp1_jee_api.webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.emsi.tp1_jee_api.entities.Product;
import ma.emsi.tp1_jee_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@WebService(serviceName = "ProductWS")
@AllArgsConstructor
public class ProductWebService {
    private ProductRepository productRepository;
    @WebMethod(operationName = "sellingPrice")
    public Double sellingPrice(@WebParam(name = "id") Long id) {
        Product product = productRepository.findById(id).orElse(null);
        assert product != null;
        return product.getPrice() * 1.5;
    }

    @WebMethod(operationName = "getProduct")
    public Product getProduct(@WebParam(name = "id") Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @WebMethod(operationName = "getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @WebMethod(operationName = "createProduct")
    public Product createProduct(double price, String name) {
        Product product = new Product();
        product.setPrice(price);
        product.setName(name);
        product.setDateCreation(new Date());

        productRepository.save(product);
        return product;
    }

    @WebMethod(operationName = "updateProduct")
    public Product updateProduct(Long id, Double price) {
        Product product = productRepository.findById(id).orElse(null);
        assert product != null;
        product.setPrice(price);
        return productRepository.save(product);
    }

    @WebMethod(operationName = "deleteProduct")
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
