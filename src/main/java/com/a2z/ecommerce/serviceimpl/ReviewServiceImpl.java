package com.a2z.ecommerce.serviceimpl;


import com.a2z.ecommerce.customExceptions.CustomerNotFound;
import com.a2z.ecommerce.customExceptions.ProductNotFound;
import com.a2z.ecommerce.customExceptions.ReviiewAlreadyExistExceptiom;
import com.a2z.ecommerce.dto.ReviewRequest;
import com.a2z.ecommerce.dto.ReviewResponse;
import com.a2z.ecommerce.mapper.ReviewMapper;
import com.a2z.ecommerce.model.Customer;
import com.a2z.ecommerce.model.Product;
import com.a2z.ecommerce.model.Review;
import com.a2z.ecommerce.repository.CustomerRepo;
import com.a2z.ecommerce.repository.ProductRepo;
import com.a2z.ecommerce.repository.ReviewRepo;
import com.a2z.ecommerce.service.ProductService;
import com.a2z.ecommerce.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {


            private final ReviewRepo reviewRepo;

            private final ReviewMapper reviewMapper;

            private final ProductRepo productRepo;

            private final CustomerRepo customerRepo;

            public ReviewServiceImpl(ReviewRepo reviewRepo, ReviewMapper reviewMapper,
                                     ProductRepo productRepo, CustomerRepo customerRepo){

                this.reviewRepo=reviewRepo;
                this.reviewMapper=reviewMapper;
                this.productRepo=productRepo;
                this.customerRepo=customerRepo;
            }

    @Override
    public ReviewResponse addReview(ReviewRequest reviewRequest) {

                if(reviewRepo.existByCustomerIdAndProductId(reviewRequest.getCustomerId(),
                        reviewRequest.getProductId())){
                    throw new ReviiewAlreadyExistExceptiom("Customer already reviewed this product");
                }
             Review review= reviewMapper.toEntity(reviewRequest);

             review.setProduct(findProductOrThrow(reviewRequest.getProductId()));

            review.setCustomer(findCustomerOrThrow(reviewRequest.getCustomerId()));

           return  reviewMapper.toResponse(reviewRepo.save(review));
    }

    private Product findProductOrThrow(Long productId){

             return   productRepo.findById(productId).orElseThrow(()->
                        new ProductNotFound("product not found with given Id"+productId));
    }

    private Customer findCustomerOrThrow(Long customerId){

             return   customerRepo.findById(customerId).orElseThrow(()->
                            new CustomerNotFound("customer not found with given Id"+customerId));
    }
}
