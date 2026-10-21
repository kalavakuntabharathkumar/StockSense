package com.stocksense.model;
import jakarta.persistence.*;import jakarta.validation.constraints.*;import java.math.BigDecimal;
@Entity @Table(name="products",indexes={@Index(name="idx_product_name",columnList="name"),@Index(name="idx_product_stock",columnList="quantity,reorder_level")})
public class Product{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)private Long id;
 @Column(nullable=false)@NotBlank private String name;
 @Column(unique=true,nullable=false)@NotBlank private String sku;
 @Column(nullable=false,precision=12,scale=2)@DecimalMin("0.0")private BigDecimal price;
 @Column(nullable=false)@Min(0)private int quantity;
 @Column(name="reorder_level",nullable=false)@Min(0)private int reorderLevel=10;
 protected Product(){} public Product(String n,String s,BigDecimal p,int q,int r){name=n;sku=s;price=p;quantity=q;reorderLevel=r;}
 public Long getId(){return id;}public String getName(){return name;}public String getSku(){return sku;}public BigDecimal getPrice(){return price;}public int getQuantity(){return quantity;}public int getReorderLevel(){return reorderLevel;}public void setName(String v){name=v;}public void setPrice(BigDecimal v){price=v;}public void setQuantity(int v){quantity=v;}public void setReorderLevel(int v){reorderLevel=v;}
}
