package org.nir.ecommerce.dao;

import org.junit.jupiter.api.Test;
import org.nir.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
//WHEN ADDING H2 EMBEDDED DB - I HAVE TO ADD THIS ANNOTAION!!! to use the real db
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
public class ProductRepositoryTest
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void smokeTest()
    {
        assertNotNull(this.entityManager);
        assertNotNull(this.productRepository);
    }

    //NOTE:This test will pass only if I remove the Rollback(false) annotation!!!
    @Test
    void shouldThrowDataIntegrityViolationExceptionWhenCreatingProductWithNoCategory()
    {
        //GIVEN
        Product product = new Product();

        assertThrows(DataIntegrityViolationException.class, () -> {
            //WHEN
            this.productRepository.save(product);
        });

    }

    @Test
    public void shouldGetAllProduct()
    {
        //GIVEN
        List<Product> products = null;
        //WHEN
        products  = this.productRepository.findAll();

        //THEN
        assertNotNull(products);
       // assertEquals(5, products.size());
        System.out.println(products.size());

    }

//    @Test
//    public void shouldSaveProductWhenCreatedWithCategory()
//    {
//        //GIVEN
//        ProductCategory category = new ProductCategory();
//        category.setCategoryName("Laptops");
//
//        Product product  = new Product();
//        product.setCategory(category);
//
//        //WHEN
//        this.entityManager.save(category);
//        Product savedProduct = this.productRepository.save(product);
//
//
//        //THEN
//        assertNotNull(savedProduct);
//    }
}
