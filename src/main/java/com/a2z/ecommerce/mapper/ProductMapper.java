package com.a2z.ecommerce.mapper;


import com.a2z.ecommerce.dto.ProductRequest;
import com.a2z.ecommerce.dto.ProductResponse;
import com.a2z.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRequest productRequest);

    @Mapping(target = "productId", ignore = true)
    void updateFromDto(ProductRequest request, @MappingTarget Product product);

    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> product);

}
