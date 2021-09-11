package tn.formalab.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.formalab.ecommerce.model.Product;
import tn.formalab.ecommerce.repositories.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("products")

public class ProductController {
    private ProductRepository productRepository;


    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @PostMapping(path = "add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){


        Product savedProduct = this.productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
    @GetMapping(path = "all")
    public ResponseEntity <List<Product>> getAllProduct(){


        List<Product> product = this.productRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @GetMapping(path = "one/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id  ) {
        try {
            Product products = productRepository.findById(id).get();
            return ResponseEntity.status(HttpStatus.CREATED).body(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Product());

        }
    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity <Map<String,String>> deleteProduct(@PathVariable Integer id){


        this.productRepository.deleteById(id);
        HashMap<String,String> map=new HashMap<>();
        map.put("m","Product deleted");
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
