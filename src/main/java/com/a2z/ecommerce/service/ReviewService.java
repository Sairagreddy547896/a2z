package com.a2z.ecommerce.service;

import com.a2z.ecommerce.dto.ReviewRequest;
import com.a2z.ecommerce.dto.ReviewResponse;

public interface ReviewService {


            ReviewResponse addReview(ReviewRequest reviewRequest);

}
