package org.nir.ecommerce.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

//import org.jboss.logging.Logger;
//import org.junit.jupiter.api.Test;
//import org.nir.ecommerce.entity.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.nir.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 *  start the application and listen for a connection (as it would do in production)
 *  and then send an HTTP request and assert the response
 *  The server will be started with the entire Spring Context
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest 
{
	private static final Logger logger = Logger.getLogger(HttpRequestTest.class);

	
    @LocalServerPort
    private int port ;


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void smoke()
    {
    	
    	assertThat(this.testRestTemplate).isNotNull();
    	logger.info("The TestRestTemlate Injected Succesffully");
    }

    @Test
    public void testResponseAsString()
    {
        String url = "http://localhost:" + port + "/api/products";

        String strResponse = this.testRestTemplate.getForObject(url,  String.class);
        assertThat(strResponse).contains("Learn JavaScript");

        System.out.println(">>testResponseAsString(): The response:\n" + strResponse);
//


    }

    /**
     * String url = "http://localhost:" + port + "/api/customers";
     * 		int expectedCount = 7;
     *
     *
     * 		//WHEN
     * 		//make REST call
     * 		ResponseEntity<List<Customer>> responseEntity = this.restTemplate.exchange(url,
     * 					HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {});
     *
     *
     * 		//THEN
     * 		//Get the list of customers from the Response(Observable)
     * 		List<Customer> actualCustomers = responseEntity.getBody();
     *
     * 		assertThat(actualCustomers).isNotNull();
     * 		assertThat(actualCustomers.size()).isEqualTo(expectedCount);
     *
     *
     *
     * 		logger.info("in testListAll(): success! customers \n " + actualCustomers);
     */
    @Test
    public void testGetAllProducts()
    {
    	//GIVEN
    	List<Product> products = null;
    	String url = "http://localhost:" + port + "/api/products";
        int expectedCount = 5; 
        
    	
    	//WHEN
        //make REST call
        //ResponseEntity<List<Product>> responseEntity =
//        this.testRestTemplate.exchange(url, HttpMethod.GET,
//                null, new ParameterizedTypeReference<List<Product>>() {});
    	//this.testRestTemplate.getForObject(url, null)

        //List<Product> actualProducts = responseEntity.getBody();


        //THEN
        //assertThat(actualProducts).isNotNull();
       // assertThat(actualProducts.size()).isEqualTo(expectedCount);

        //logger.info("in testListAll(): success! customers \n " + actualProducts);
    }
    /**
     * logger.info("in getCustomers(): Calling REST API "
     * + crmRestUrl);
     * // make REST call
     * ResponseEntity<List<Customer>> responseEntity =
     * restTemplate.exchange(crmRestUrl,
     *  HttpMethod.GET, null,
     *  new ParameterizedTypeReference<List<Customer>>() {});
     * // get the list of customers from response
     * List<Customer> customers = responseEntity.getBody();
     * logger.info("in getCustomers(): customers" + customers);
     */
//    @Test
//    public void shouldReturnListOfProducts()
//    {
//        //GIVEN
//        String url = "http://localhost:/" + this.port + "/api/products";
//
//        //WHEN
//        // make REST call
//        ResponseEntity<List<Product>> responseEntity =
//                this.testRestTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>(){});
//
//        List<Product> products = responseEntity.getBody();
//
//        //THEN
//        assertNotNull(products);
//
//    }
//

}
