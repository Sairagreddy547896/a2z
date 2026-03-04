package com.a2z.ecommerce.mapper;


import com.a2z.ecommerce.dto.ProductRequest;
import com.a2z.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    Product toEntity(ProductRequest productRequest);

    @Mapping(target = "productId", ignore = true)
    void updateFromDto(ProductRequest request, @MappingTarget Product product);


}
