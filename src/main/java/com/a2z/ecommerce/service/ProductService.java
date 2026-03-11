package com.a2z.ecommerce.service;


import com.a2z.ecommerce.dto.ProductRequest;
import com.a2z.ecommerce.dto.ProductResponse;

import java.util.List;

public interface ProductService {

        ProductResponse addProduct(ProductRequest productRequest);

        List<ProductResponse> getAllProducts();

        ProductResponse updateProduct(Long productId, ProductRequest updatedProductRequest);

        ProductResponse deleteProduct(Long productId);

        ProductResponse getProductById(Long productId);

}
