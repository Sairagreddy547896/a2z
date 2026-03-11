package com.a2z.ecommerce.serviceimpl;

import com.a2z.ecommerce.customExceptions.ProductNotFound;
import com.a2z.ecommerce.dto.ProductRequest;
import com.a2z.ecommerce.dto.ProductResponse;
import com.a2z.ecommerce.mapper.ProductMapper;
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

    private  final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ProductMapper productMapper){
        this.productRepo=productRepo;
        this.productMapper=productMapper;
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {

        Product savedProduct = productRepo.save(
                productMapper.toEntity(productRequest));

        return productMapper.toResponse(savedProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return  productMapper.toResponseList(productRepo.findAll());
    }

    @Override
    public ProductResponse updateProduct(Long productId, ProductRequest updatedProductRequest) {

        Product product   =    productRepo.findById(productId).orElseThrow( ()->
                new ProductNotFound("product not found with given id "+productId)
        );
        productMapper.updateFromDto(updatedProductRequest,product);
        return productMapper.toResponse(productRepo.save(product));
    }

    private Product findProductOrThrow(Long productId){

        return  productRepo.findById(productId).orElseThrow( ()->
                new ProductNotFound("product not found with given id "+productId)
                );
    }

    @Override
    @Transactional
    public ProductResponse deleteProduct(Long productId) {

        Product product=    findProductOrThrow(productId);
        productRepo.delete(product);

        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse getProductById(Long productId) {

          Product  product=    findProductOrThrow(productId);

          return productMapper.toResponse(product);
    }
}
