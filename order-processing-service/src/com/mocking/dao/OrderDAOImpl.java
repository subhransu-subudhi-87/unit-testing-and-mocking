package com.mocking.dao;

import java.sql.SQLException;

import com.mocking.dto.Order;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int createOrder(Order order) throws SQLException {
		return 0;
	}

	@Override
	public Order readOrder(int id) throws SQLException {
		return null;
	}

	@Override
	public int updateOrder(Order order) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOrder(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
