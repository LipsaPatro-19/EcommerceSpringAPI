package com.example.RESTAPI.repository;

import com.example.RESTAPI.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //This is a custom query method using HQL(Hibernate Query Language means it queries from java entity objects instead of raw sql table).
    //Explicitly define the query logic
    @Query("SELECT p from Product p where p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);

    //This is a custom query method using raw SQL, nativeQuery = true means you are making it as raw sql query
    @Query(value = "Select * from product where match(name, description) against (:keyword)", nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);

    //:minPrice - "minPrice" in @Param("minPrice")
    //:brand - "brand" in @Param("brand")
    @Query("Select p from Product p where p.price > :minPrice and p.brand = :brand")
    List<Product> findByBrandAndPrice(@Param("minPrice") int price, @Param("brand") String brandName);
}
