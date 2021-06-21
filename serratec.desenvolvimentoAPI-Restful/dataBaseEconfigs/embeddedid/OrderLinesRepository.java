
package com.residencia.dell.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.OrderLinesId;
import com.residencia.dell.entities.Orders;


@Repository
public interface OrderLinesRepository extends JpaRepository <OrderLines, OrderLinesId> {
}
