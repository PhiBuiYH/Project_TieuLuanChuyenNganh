package com.tanphi.laptopshop.service;


import java.util.List;

import com.tanphi.laptopshop.entity.Orders;
import com.tanphi.laptopshop.request.orders.OrderCreateRequest;


public interface OrdersService {
	void createOrders(OrderCreateRequest orderCreateRequest);

	List<Orders> getOrdersByStatus(Integer customerID, Integer status);

	void cancleOrders(Integer ordersID);
}
