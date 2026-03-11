package com.a2z.ecommerce.mapper;


import com.a2z.ecommerce.dto.ReviewRequest;
import com.a2z.ecommerce.dto.ReviewResponse;
import com.a2z.ecommerce.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {CustomerMapper.class,ProductMapper.class})
public interface ReviewMapper {

      @Mapping(target = "reviewId",ignore = true)
      @Mapping(target = "customer",ignore = true)
      @Mapping(target = "product",ignore = true)
      Review toEntity(ReviewRequest reviewRequest);

      ReviewResponse toResponse(Review review);
}
