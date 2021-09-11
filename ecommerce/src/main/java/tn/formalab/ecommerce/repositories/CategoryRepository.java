package tn.formalab.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.ecommerce.model.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {
}
