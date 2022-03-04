package org.nir.ecommerce.dao;

import org.nir.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 1. collectionResourceRel: The real value to use when generating links to the collection resource.
                        This will be the name of the JSON entry in the response
                        Instead of the default which is

 2. The actual reference (end point ) instead of the default  product-categories.
 *
 */
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>
{
}
