package com.tanphi.laptopshop.response.orders;

import lombok.Data;

@Data
public class GetOrdersDetailResponse {
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
}
