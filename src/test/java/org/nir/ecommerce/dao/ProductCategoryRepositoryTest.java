package org.nir.ecommerce.dao;

import org.junit.jupiter.api.Test;
import org.nir.ecommerce.entity.Product;
import org.nir.ecommerce.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductCategoryRepositoryTest
{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testSmoke()
    {
        assertNotNull(this.entityManager);
        assertNotNull(this.productCategoryRepository);

    }

    @Test
    public void shouldListAllProductCategories()
    {
        List<ProductCategory> productCategoryList = null;


        productCategoryList =  this.productCategoryRepository.findAll();


        assertNotNull(productCategoryList);
        assertEquals(2, productCategoryList.size());

        productCategoryList.stream().forEach(System.out::println);
    }
}

