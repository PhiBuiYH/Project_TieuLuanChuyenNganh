package com.tanphi.laptopshop.service;


import com.tanphi.laptopshop.entity.Cart;
import com.tanphi.laptopshop.request.cart.CartRequest;
import com.tanphi.laptopshop.request.review.CreateReviewRequest;

import java.util.List;

import javax.validation.Valid;


public interface ReviewsService {
	void createReviews(CreateReviewRequest request);
}
