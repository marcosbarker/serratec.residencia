
package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Customers;
import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.exceptions.EmailException;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.ItemOrderLinesVO;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrderLinesVO;
import com.residencia.dell.vo.OrdersVO;

@Service
public class OrdersService {

	@Autowired
	public OrdersRepository ordersRepository;
	
	@Autowired
	public OrderLinesRepository orderLinesRepository;
	
	@Autowired
	public ProductsRepository productsRepository;
	
	@Autowired
	public CustomersRepository customersRepository;

	@Autowired
	public EmailService emailService;

	public Orders saveVO(OrdersVO ordersVO) {

		Orders orders =  new Orders();
        Customers customer = customersRepository.getById(ordersVO.getCustomerId());

        orders.setNetAmount(ordersVO.getNetAmount());
        orders.setOrderDate(ordersVO.getOrderDate());
        orders.setOrderId(ordersVO.getOrderId());
        orders.setTax(ordersVO.getTax());
        orders.setTotalAmount(ordersVO.getTotalAmount());
        orders.setCustomer(customer);
        
        Orders newOrders = ordersRepository.save(orders);

        Integer contadorOrderlinesId = 1;
        
        List<OrderLines> listNewOrderLines = new ArrayList<>();
        for (OrderLinesVO itemOrderLinesVO : ordersVO.getListOrderLinesVO()) {
            OrderLines orderlines = new OrderLines(
            		contadorOrderlinesId, 
            		newOrders.getOrderId(),
            		itemOrderLinesVO.getProdId(),
            		itemOrderLinesVO.getQuantity(),
            		itemOrderLinesVO.getOrderDate()
            		);
            
            OrderLines newOrderlines = orderLinesRepository.save(orderlines);
            
            listNewOrderLines.add(newOrderlines);
            
            contadorOrderlinesId++;
        }
        
        newOrders.setListOrderLines(listNewOrderLines);

        return newOrders;

    }
   
}
