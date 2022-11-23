package com.tanphi.laptopshop.response.reviews;

import lombok.Data;

@Data
public class GetReviewsResponse {
	private Integer accountId;
	private String contents;
	private String username;
}
