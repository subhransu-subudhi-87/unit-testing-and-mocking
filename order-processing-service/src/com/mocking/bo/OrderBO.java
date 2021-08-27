package com.mocking.bo;

import com.mocking.bo.exception.BOException;
import com.mocking.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order)throws BOException;
	boolean cancelOrder(int id)throws BOException;
	boolean deleteOrder(int id)throws BOException;
}
