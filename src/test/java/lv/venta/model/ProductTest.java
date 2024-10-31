package lv.venta.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.description;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ProductTest {

    private Product productGood;
    private Product productBad;
    private Product productNull;
    private Product productNullVariables;
    private Product productDefault = new Product("Gurkis", 0.5f, "Zals", 50);

    @BeforeAll
    void  setUp(){
        //productDefault = new Product();
        productGood =  new Product("Burkans", 0.5f, "Oranzs", 50);
        productBad = new Product("asdasads", -1f, "", -31);
        productNull = null;
        productNullVariables = new Product(null, 0, null, 0);

        
    }

   
    @Test
    void testProduct(){
        assertEquals("Gurkis", productDefault.getTitle());
        assertEquals(0.5f, productDefault.getPrice(), 0.001);    
        assertEquals("Zals", productDefault.getDescription());
        assertEquals(50, productDefault.getQuantity());
        
    }

     
    @Test
    void testProductGood(){
        assertEquals("Burkans", productGood.getTitle());
        assertEquals(0.5f, productGood.getPrice(), 0.001);    
        assertEquals("Oranzs", productGood.getDescription());
        assertEquals(50, productGood.getQuantity());
    }
  
}
