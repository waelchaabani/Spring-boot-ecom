package tn.formalab.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.ecommerce.model.User;
import tn.formalab.ecommerce.model.Category;
import tn.formalab.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
