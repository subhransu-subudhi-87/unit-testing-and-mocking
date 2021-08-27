package com.mocking.bo;

import java.sql.SQLException;

import com.mocking.bo.exception.BOException;
import com.mocking.dao.OrderDAO;
import com.mocking.dto.Order;

public class OrderBOImpl implements OrderBO {

	private OrderDAO orderDao;

	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int createOrderRes = orderDao.createOrder(order);
			if (createOrderRes == 0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = orderDao.readOrder(id);
			order.setStatus("Cancelled");
			int updateOrderRes = orderDao.updateOrder(order);
			if(updateOrderRes == 0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int deleteOrderRes = orderDao.deleteOrder(id);
			if(deleteOrderRes == 0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public OrderDAO getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}
}
