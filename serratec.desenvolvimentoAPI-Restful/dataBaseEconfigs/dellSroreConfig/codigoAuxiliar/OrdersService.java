
package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.vo.ItemOrderLinesVO;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrderLinesVO;
import com.residencia.dell.vo.OrdersVO;

/**
 *
 * @author Dayane
 */
@Service
public class OrdersService {

	@Autowired
	public OrdersRepository ordersRepository;
	
	@Autowired
	public OrderLinesRepository orderLinesRepository;

	public Orders findById(Integer id) {
		// return alunosRepository.getById(id).getNome();
		return ordersRepository.findById(id).get();
	}

	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}

	public List<Orders> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orders> listOrders = null;
		List<Orders> listOrdersComPaginacao = null;

		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = ordersRepository.findAll(page).getContent();

				return listOrdersComPaginacao;
			} else {
				listOrders = ordersRepository.findAll();

				return listOrders;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
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
	
	public NotaFiscalVO emitirNF(Integer orderId) {
		
		Orders orders = ordersRepository.getById(orderId);
		List<OrderLines> listOrderLines = orders.getListOrderLines();

		//List<OrderLines> listOrderLinesII = orderLinesRepository.findByOrders(orders);
		
		NotaFiscalVO notaFiscalVO = new NotaFiscalVO();
		
		notaFiscalVO.setCustomerFirstName(orders.getCustomer().getFirstName());
		notaFiscalVO.setCustomerLastName(orders.getCustomer().getLastName());
		notaFiscalVO.setNetAmount(orders.getNetAmount());
		notaFiscalVO.setOrderDate(orders.getOrderDate());
		notaFiscalVO.setOrderId(orders.getOrderId());
		notaFiscalVO.setTotalAmount(orders.getTotalAmount());

		List<ItemOrderLinesVO> listItemOrderLinesVO = new ArrayList<>();
		for(OrderLines orderlines : listOrderLines) {
			ItemOrderLinesVO itemOrderLinesVO = new ItemOrderLinesVO();
			itemOrderLinesVO.setProdId(orderId);
			//...
			listItemOrderLinesVO.add(itemOrderLinesVO);
		}

		notaFiscalVO.setListItemOrderLinesVO(listItemOrderLinesVO);		
		
		return notaFiscalVO;
	}


	private OrdersVO convertEntidadeParaVO(Orders orders) {
		OrdersVO ordersVO = new OrdersVO();
		List<OrderLinesVO> listOrderLinesVO = new ArrayList<>();

		ordersVO.setNetAmount(orders.getNetAmount());
		ordersVO.setOrderDate(orders.getOrderDate());
		ordersVO.setOrderId(orders.getOrderId());
		ordersVO.setTax(orders.getTax());
		ordersVO.setTotalAmount(orders.getTotalAmount());

		for (OrderLines lOrderLines : orders.getListOrderLines()) {
			OrderLinesVO orderLinesVO = new OrderLinesVO();

			orderLinesVO.setOrderDate(lOrderLines.getOrderDate());
			orderLinesVO.setOrderLineId(lOrderLines.getOrderLineId());
			orderLinesVO.setProdId(lOrderLines.getProdId());
			orderLinesVO.setQuantity(lOrderLines.getQuantity());

			listOrderLinesVO.add(orderLinesVO);
		}

		ordersVO.setListOrderLinesVO(listOrderLinesVO);

		return ordersVO;
	}

	public Long count() {
		return ordersRepository.count();
	}

	public Orders save(Orders orders) {
		Orders newOrders = ordersRepository.save(orders);
		return newOrders;
	}

	public void delete(Integer id) {
		ordersRepository.deleteById(id);
	}

	public Orders update(Integer id, Orders orders) {
		Orders newOrders = ordersRepository.findById(id).get();
		updateDados(newOrders, orders);
		return ordersRepository.save(newOrders);
	}

	private void updateDados(Orders newOrders, Orders orders) {
		newOrders.setOrderDate(orders.getOrderDate());
		newOrders.setCustomer(orders.getCustomer());
		newOrders.setNetAmount(orders.getNetAmount());
		newOrders.setTax(orders.getTax());
		newOrders.setTotalAmount(orders.getTotalAmount());
	}
}
