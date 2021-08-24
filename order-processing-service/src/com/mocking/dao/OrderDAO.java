package com.mocking.dao;

import java.sql.SQLException;

import com.mocking.dto.Order;

public interface OrderDAO {

	int createOrder(Order order)throws SQLException;
	Order readOrder(int id)throws SQLException;
	int updateOrder(Order order)throws SQLException;
	int deleteOrder(int id)throws SQLException;
	
}
