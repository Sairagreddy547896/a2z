package com.a2z.ecommerce.mapper;


import com.a2z.ecommerce.dto.ProductResponse;
import com.a2z.ecommerce.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> product);
}
