package ma.emsi.tp1_jee_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.emsi.tp1_jee_api.entities.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
}
