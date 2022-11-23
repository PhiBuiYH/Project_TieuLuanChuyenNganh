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

public class OrdersMapper {
	public static GetListOrdersByStatus toResponseGetListOrdersByStatus(List<Orders> listOrders, String strStatus, Integer status) {
		GetListOrdersByStatus tmp=new GetListOrdersByStatus();
		List<GetOrdersByStatus> list=new ArrayList<GetOrdersByStatus>();
		for(Orders orders:listOrders)
		{
			GetOrdersByStatus itemTmp=toResponseGetOrdersByStatus(orders);
			list.add(itemTmp);
		}
		tmp.setListOrders(list);
		tmp.setStatus(status);
		tmp.setStrStatus(strStatus);
		return tmp;
	}
	public static GetOrdersByStatus toResponseGetOrdersByStatus(Orders orders)
	{
		GetOrdersByStatus tmp=new GetOrdersByStatus();
		tmp.setAddress(orders.getAddress());
		tmp.setCustomerNote(orders.getCustomerNote());
		tmp.setOrderDate(orders.getOrderDate());
		tmp.setLstOrdersDetail(OrdersDetailMapper.toResponseGetListOrdersDetail(orders.getOrderDetailSet()));
		tmp.setOrderId(orders.getOrderId());
		tmp.setReceiptDate(orders.getOrderDate());
		tmp.setShipping(orders.getShipping());
		tmp.setTotalAmount(orders.getTotalAmount());
		return tmp;
	}
}
