package com.tanphi.laptopshop.service;

import com.tanphi.laptopshop.entity.Accounts;
import com.tanphi.laptopshop.entity.Cart;
import com.tanphi.laptopshop.entity.Product;
import com.tanphi.laptopshop.entity.Reviews;
import com.tanphi.laptopshop.entity.ReviewsIDKey;
import com.tanphi.laptopshop.entity.enums.IsDeleteStatus;
import com.tanphi.laptopshop.exception.BadRequestException;
import com.tanphi.laptopshop.repository.AccountsRepo;
import com.tanphi.laptopshop.repository.CartRepo;
import com.tanphi.laptopshop.repository.OrdersRepo;
import com.tanphi.laptopshop.repository.ProductRepo;
import com.tanphi.laptopshop.repository.ReviewsRepo;
import com.tanphi.laptopshop.request.cart.CartRequest;
import com.tanphi.laptopshop.request.review.CreateReviewRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

@Service
public class ReviewsServiceImpl implements ReviewsService {
	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private AccountsRepo accountsRepo;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private OrdersRepo ordersRepo;
	@Autowired
	private ReviewsRepo reviewsRepo;
	@Override
	public void createReviews(CreateReviewRequest request) {
		try {
			Reviews newReview=new Reviews();
			newReview.setContents(request.getContents());
			newReview.setRate(request.getRate());
			newReview.setReviewsDate(Timestamp.from(Instant.now()));
			newReview.setIsdeleted(IsDeleteStatus.NO.getCode());
			ReviewsIDKey reviewsIDKey=new ReviewsIDKey();
			reviewsIDKey.setAccountId(request.getAccountId());
			reviewsIDKey.setOrderId(request.getOrderId());
			reviewsIDKey.setProductId(request.getProductId());
			newReview.setReviewsIDKey(reviewsIDKey);
			reviewsRepo.save(newReview);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
