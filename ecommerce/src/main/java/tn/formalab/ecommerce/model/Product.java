package tn.formalab.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue()
    public Integer id ;

    @Column(name= "name",unique = true,nullable = false)
    public String name ;

    @Column(name= "description",nullable = false)
    public String description ;

    @Column(name= "price",nullable = false)
    public Double price ;

    @Column(name= "imageurl",nullable = false)
    public String imageurl ;
     @ManyToOne
    @JoinColumn(name = "idcategory")
    public  Category category;
}
