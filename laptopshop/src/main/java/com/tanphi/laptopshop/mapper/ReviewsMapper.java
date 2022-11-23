package com.tanphi.laptopshop.mapper;

import com.tanphi.laptopshop.entity.Reviews;

import com.tanphi.laptopshop.response.reviews.GetReviewsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReviewsMapper {
    public static List<GetReviewsResponse> toResponeGetListReviews(Set<Reviews> reviewsList)
    {
        List<GetReviewsResponse> list=new ArrayList<>();
        for(Reviews reviews:reviewsList) {
        	GetReviewsResponse tmp=toResponeGetReviews(reviews);
            list.add(tmp);
        }
        return list;
    }
    public static GetReviewsResponse toResponeGetReviews(Reviews reviews)
    {
    	GetReviewsResponse tmp=new GetReviewsResponse();
    	tmp.setAccountId(reviews.getAccounts().getAccountId());
    	tmp.setContents(reviews.getContents());
    	tmp.setUsername(reviews.getAccounts().getUsername());
        return tmp;
    }
}
