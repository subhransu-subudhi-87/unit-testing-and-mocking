package com.mocking.bo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.mocking.bo.exception.BOException;
import com.mocking.dao.OrderDAO;
import com.mocking.dto.Order;

class OrderBOImplTest {

	@Mock
	private OrderDAO dao;
	
	@Before
	public void setup() {
		/**
		 * Here OrderBOImplTest's reference is passed 
		 * and at runtime MockitoAnnotations will scan through 
		 * all the Objects present in the class marked with @Mock Annotation.
		 */
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void placeorder_should_create_an_order() throws SQLException, BOException {
      
		OrderBOImpl bo = new OrderBOImpl();
		bo.setOrderDao(dao);
		
		//Setting the expectations as below
		Order order = new Order();
		when(dao.createOrder(order)).thenReturn(new Integer(1));
		
		//Verifying the results as OrderBOImpl returns true for a successful order creation
		boolean result = bo.placeOrder(order);
		assertTrue(result);
		verify(dao).createOrder(order);
	
	}

}
