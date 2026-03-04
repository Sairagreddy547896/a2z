package com.a2z.ecommerce.controller;


import com.a2z.ecommerce.dto.ProductRequest;
import com.a2z.ecommerce.dto.ProductResponse;
import com.a2z.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {



       private final ProductService productService;

       @Autowired
       public ProductController(ProductService productService){
           this.productService=productService;
       }

       @PostMapping("/add-product")
       public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){

               return new ResponseEntity<>(productService.addProduct(productRequest), HttpStatus.CREATED);
       }

       @GetMapping("/get-all-products")
       public ResponseEntity<List<ProductResponse>>  allProducts(){

            return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
       }

       @PutMapping("/update-product/{productId}")
       public ResponseEntity<ProductResponse> updateProduct(@PathVariable("productId") Long productId,
                                                           @RequestBody ProductRequest productRequest){

           return new ResponseEntity<>(productService.updateProduct(productId,productRequest),HttpStatus.OK);
       }

       @DeleteMapping("/delete-product/{productId}")
      public ResponseEntity<ProductResponse> deleteProduct(@PathVariable("productId") Long productId){

        return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.OK);
      }

}
