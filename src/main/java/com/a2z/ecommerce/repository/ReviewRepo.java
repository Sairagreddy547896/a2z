package com.a2z.ecommerce.repository;

import com.a2z.ecommerce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {


    boolean existByCustomerIdAndProductId(Long customerId,Long productId);
}
