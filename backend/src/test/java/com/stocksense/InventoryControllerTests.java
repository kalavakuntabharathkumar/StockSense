package com.stocksense;
import com.stocksense.model.Product;import org.junit.jupiter.api.Test;import java.math.BigDecimal;import static org.junit.jupiter.api.Assertions.*;
class InventoryControllerTests{@Test void productRetainsInventoryFields(){var p=new Product("Coffee","CF-01",new BigDecimal("12.50"),7,10);assertEquals("CF-01",p.getSku());assertTrue(p.getQuantity()<=p.getReorderLevel());assertEquals(new BigDecimal("12.50"),p.getPrice());}}
