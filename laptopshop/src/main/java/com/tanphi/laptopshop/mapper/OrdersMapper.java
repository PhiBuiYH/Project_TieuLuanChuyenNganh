package com.tanphi.laptopshop.mapper;
import com.tanphi.laptopshop.entity.Orders;
import com.tanphi.laptopshop.response.orders.GetListOrdersByStatus;
import com.tanphi.laptopshop.response.orders.GetOrdersByStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public static GetListOrdersByStatus toResponseGetListOrdersByStatusIsReviewd(List<Orders> listOrders, String strStatus, Integer status,Map<String,Boolean> mapReviews) {
		GetListOrdersByStatus tmp=new GetListOrdersByStatus();
		List<GetOrdersByStatus> list=new ArrayList<GetOrdersByStatus>();
		for(Orders orders:listOrders)
		{
			GetOrdersByStatus itemTmp=toResponseGetOrdersByStatusIsReviewed(orders,mapReviews);
			list.add(itemTmp);
		}
		tmp.setListOrders(list);
		tmp.setStatus(status);
		tmp.setStrStatus(strStatus);
		return tmp;
	}
	private static GetOrdersByStatus toResponseGetOrdersByStatusIsReviewed(Orders orders,
			Map<String, Boolean> mapReviews) {
		// TODO Auto-generated method stub
		GetOrdersByStatus tmp=new GetOrdersByStatus();
		tmp.setAddress(orders.getAddress());
		tmp.setCustomerNote(orders.getCustomerNote());
		tmp.setOrderDate(orders.getOrderDate());
		tmp.setLstOrdersDetail(OrdersDetailMapper.toResponseGetListOrdersDetailIsReviewed(orders.getOrderDetailSet(), mapReviews));
		tmp.setOrderId(orders.getOrderId());
		tmp.setReceiptDate(orders.getOrderDate());
		tmp.setShipping(orders.getShipping());
		tmp.setTotalAmount(orders.getTotalAmount());
		tmp.setReceiptName(orders.getRecipientname());
		tmp.setPhoneNumber(orders.getPhonenumber());
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
		tmp.setReceiptName(orders.getRecipientname());
		tmp.setPhoneNumber(orders.getPhonenumber());
		return tmp;
	}
}
