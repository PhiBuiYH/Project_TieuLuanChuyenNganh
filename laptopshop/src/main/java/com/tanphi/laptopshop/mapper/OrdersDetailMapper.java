package com.tanphi.laptopshop.mapper;

import com.tanphi.laptopshop.entity.OrderDetail;
import com.tanphi.laptopshop.entity.Orders;
import com.tanphi.laptopshop.entity.Product;
import com.tanphi.laptopshop.response.orders.GetListOrdersByStatus;
import com.tanphi.laptopshop.response.orders.GetOrdersByStatus;
import com.tanphi.laptopshop.response.orders.GetOrdersDetailResponse;
import com.tanphi.laptopshop.response.product.GetAllProductPageResponse;
import com.tanphi.laptopshop.response.product.GetProductResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OrdersDetailMapper {
	public static GetOrdersDetailResponse toResponseGetOrdersDetail(OrderDetail orderDetail)
	{
		GetOrdersDetailResponse tmp=new GetOrdersDetailResponse();
		tmp.setOrderId(orderDetail.getOrderDetailIDKey().getOrderId());
		tmp.setProductId(orderDetail.getOrderDetailIDKey().getProductId());
		tmp.setImgLink(orderDetail.getProduct().getImage());
		tmp.setProductName(orderDetail.getProduct().getProductName());;
		tmp.setQuantity(orderDetail.getQuantity());
		return tmp;
	}
	public static List<GetOrdersDetailResponse> toResponseGetListOrdersDetail(Set<OrderDetail> orderDetails)
	{
		List<GetOrdersDetailResponse> tmp=new ArrayList<GetOrdersDetailResponse>();
		for(OrderDetail orderDetail:orderDetails)
		{
			GetOrdersDetailResponse itemTmp=toResponseGetOrdersDetail(orderDetail);
			tmp.add(itemTmp);
		}
		return tmp;
	}
}
