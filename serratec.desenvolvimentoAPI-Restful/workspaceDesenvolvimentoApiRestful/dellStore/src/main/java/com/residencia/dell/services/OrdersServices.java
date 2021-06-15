package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrderlinesVO;
import com.residencia.dell.vo.OrdersVO;

@Service
public class OrdersServices {
	
	@Autowired 
	public OrdersRepository ordersRepository;
	
	@Autowired
	public ProductsRepository productsRepository;
	
	public Orders findById(Integer id) {
		return ordersRepository.findById(id).get();
	}
	
	public OrdersVO findByIdVO(Integer id) {
		Orders orders = ordersRepository.findById(id).get();
		return convertEntidadeParaVO(orders);
	}
	
	public List<Orders> findAll(){
		return ordersRepository.findAll();
	}
	
	public List<Orders> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orders> listOrders = null;
		List<Orders> listOrdersComPaginacao = null;
		List<OrdersVO> listOrdersVO = new ArrayList<>();
		
		try {
			if(null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = ordersRepository.findAll(page).getContent();
						
				return listOrdersComPaginacao;		
			} else {
				listOrders = ordersRepository.findAll();
				return listOrders;
			}
		} catch (Exception e) {
			throw new Exception ("Não foi possível recuperar a lista de pedido::" +e.getMessage());
		}
	}
	
	public List<OrdersVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orders> listOrders = null;
		List<Orders> listOrdersComPaginacao = null;
		List<OrdersVO> listOrdersVO = new ArrayList<>();
		
		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = ordersRepository.findAll(page).getContent();
				
				for (Orders lOrders : listOrdersComPaginacao) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}
			} else {
				listOrders = ordersRepository.findAll();
				
				for (Orders lOrders : listOrders) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listOrdersVO;
	}
	
	private OrdersVO convertEntidadeParaVO(Orders orders) {
		OrdersVO ordersVO = new OrdersVO();
		List<OrderlinesVO> listOrderlinesVO = new ArrayList<>();

		ordersVO.setNetAmount(orders.getNetAmount());
		ordersVO.setOrderDate(orders.getOrderDate());
		ordersVO.setOrderId(orders.getOrderId());
		ordersVO.setTax(orders.getTax());
		ordersVO.setTotalAmount(orders.getTotalAmount());

		for (Orderlines lOrderLines : orders.getListOrderlines()) {
			OrderlinesVO orderlinesVO = new OrderlinesVO();

			orderlinesVO.setOrderDate(lOrderLines.getOrderDate());
			orderlinesVO.setOrderlineId(lOrderLines.getOrderLineId());
			orderlinesVO.setProdId(lOrderLines.getProdId());
			orderlinesVO.setQuantity(lOrderLines.getQuantity());

			listOrderlinesVO.add(orderlinesVO);
		}

		ordersVO.setListOrderlinesVO(listOrderlinesVO);

		return ordersVO;
	}
	
	public NotaFiscalVO emitirNF(Integer orderId) {
		Orders orders = ordersRepository.getById(orderId);
		List<Orderlines> listOrderlines = orders.getListOrderlines();
		
		NotaFiscalVO notaFiscalVO = new NotaFiscalVO();
		if (orders.getCustomers() != null){	
			notaFiscalVO.setCustomerFirstName(orders.getCustomers().getFirstName());
			notaFiscalVO.setCustomerLastName(orders.getCustomers().getLastName());
		 }else {
			notaFiscalVO.setCustomerFirstName(null);
			notaFiscalVO.setCustomerLastName(null);}
		
		notaFiscalVO.setNetAmount(orders.getNetAmount());
		notaFiscalVO.setOrderDate(orders.getOrderDate());
		notaFiscalVO.setOrderId(orders.getOrderId());
		notaFiscalVO.setTotalAmount(orders.getTotalAmount());
		
		List<OrderlinesVO> listItemOrderlinesVO = new ArrayList<>();
		for(Orderlines orderlines : listOrderlines) {
			OrderlinesVO itemOrderlinesVO = new OrderlinesVO();
			itemOrderlinesVO.setProdId(orderlines.getProdId());
			
			Products products = productsRepository.findById(orderlines.getProdId()).get();
			if (products != null)
				itemOrderlinesVO.setProdTitle(products.getTitle());
			else 
				itemOrderlinesVO.setProdTitle(null);
			
			itemOrderlinesVO.setQuantity(orderlines.getQuantity());
			listItemOrderlinesVO.add(itemOrderlinesVO);
		}
		notaFiscalVO.setListOrderlinesVO(listItemOrderlinesVO);
		
		return notaFiscalVO;
		
	}
	
	public Long count() {
		return ordersRepository.count();
	}
	
	public Orders save(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	public Orders update(Integer id, Orders orders) {
		orders.setOrderId(id);
		return ordersRepository.save(orders);
	}
	
	public void delete(Integer id) {
		ordersRepository.deleteById(id);
	}
	
}