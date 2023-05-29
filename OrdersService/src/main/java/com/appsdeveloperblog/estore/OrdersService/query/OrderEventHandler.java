package com.appsdeveloperblog.estore.OrdersService.query;

import com.appsdeveloperblog.estore.OrdersService.core.data.OrderEntity;
import com.appsdeveloperblog.estore.OrdersService.core.data.OrdersRepository;
import com.appsdeveloperblog.estore.OrdersService.core.events.OrderCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderEventHandler {

    private final OrdersRepository ordersRepository;

    public OrderEventHandler(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event) {

        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(event, orderEntity);

        ordersRepository.save(orderEntity);
    }
}
