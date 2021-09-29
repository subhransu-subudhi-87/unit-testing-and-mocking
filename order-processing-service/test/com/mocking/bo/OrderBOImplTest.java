package com.mocking.bo;

import org.junit.Before;
import org.junit.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.mocking.bo.exception.BOException;
import com.mocking.dao.OrderDAO;
import com.mocking.dto.Order;

public class OrderBOImplTest {

	@Mock
	private OrderDAO dao;
	private OrderBOImpl bo;
	
	@Before
	public void setup() {
		/**
		 * Here OrderBOImplTest's reference is passed 
		 * and at runtime MockitoAnnotations will scan through 
		 * all the Objects present in the class marked with @Mock Annotation.
		 */
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setOrderDao(dao);
	}
	
	@Test
	public void placeorder_should_create_an_order() throws SQLException, BOException {
      
		
		//Setting the expectations as below
		Order order = new Order();
		when(dao.createOrder(order)).thenReturn(new Integer(1));
		
		//Verifying the results as OrderBOImpl returns true for a successful order creation
		boolean result = bo.placeOrder(order);
		assertTrue(result);
		verify(dao).createOrder(order);
	
	}

	@Test(expected=BOException.class)
	public void placeorder_should_throw_BOException() throws SQLException, BOException {
      
		
		//Setting the expectations as below
		Order order = new Order();
		when(dao.createOrder(order)).thenThrow(SQLException.class);
		
		//Verifying the results as OrderBOImpl returns true for a successful order creation
		boolean result = bo.placeOrder(order);
			
	}

}
