package com.tanphi.laptopshop.repository;

import com.tanphi.laptopshop.entity.Accounts;
import com.tanphi.laptopshop.entity.Orders;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Orders,Integer> {
	List<Orders> findOrdersByStatusAndAccounts(Integer status,Accounts accounts);
	Orders findOrdersByOrderId(Integer id);
	Page<Orders> findOrdersByStatusOrderByReceiptDateDesc(Integer status,Pageable pageable);
}
