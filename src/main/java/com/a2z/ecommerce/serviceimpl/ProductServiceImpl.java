package com.a2z.ecommerce.serviceimpl;


import com.a2z.ecommerce.customExceptions.ProductNotFound;
import com.a2z.ecommerce.dto.ProductRequest;
import com.a2z.ecommerce.dto.ProductResponse;
import com.a2z.ecommerce.mapper.ProductRequestMapper;
import com.a2z.ecommerce.mapper.ProductResponseMapper;
import com.a2z.ecommerce.model.Product;
import com.a2z.ecommerce.repository.ProductRepo;
import com.a2z.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final ProductRequestMapper productRequestMapper;

    private  final ProductResponseMapper productResponseMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ProductResponseMapper productResponseMapper,
                              ProductRequestMapper productRequestMapper){
        this.productRepo=productRepo;
        this.productRequestMapper=productRequestMapper;
        this.productResponseMapper=productResponseMapper;
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {

               Product savedProduct = productRepo.save(
                       productRequestMapper.toEntity(productRequest));

               return productResponseMapper.toResponse(savedProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
               return  productResponseMapper.toResponseList(productRepo.findAll());
    }

    @Override
    public ProductResponse updateProduct(Long productId, ProductRequest updatedProductRequest) {

             Product product   =    productRepo.findById(productId).orElseThrow( ()->
                                 new ProductNotFound("product not found with given id "+productId)
                               );
              productRequestMapper.updateFromDto(updatedProductRequest,product);
              return productResponseMapper.toResponse(productRepo.save(product));
    }

    @Override
    public ProductResponse deleteProduct(Long productId) {

      Product product=          productRepo.findById(productId).orElseThrow( ()->
                           new ProductNotFound("product not found with given id "+productId)
                            );
                    productRepo.deleteById(productId);

                    return productResponseMapper.toResponse(product);
    }


}
