package org.example.posbackend.service.impl;

import org.example.posbackend.dto.OrderDetailDto;
import org.example.posbackend.dto.OrderDto;
import org.example.posbackend.entity.Item;
import org.example.posbackend.entity.OrderDetail;
import org.example.posbackend.entity.Orders;
import org.example.posbackend.repository.ItemRepository;
import org.example.posbackend.repository.OrderDetailRepository;
import org.example.posbackend.repository.OrderRepository;
import org.example.posbackend.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void placeOrder(OrderDto orderDto) {
        Orders order = new Orders(
                orderDto.getOrderID(),
                orderDto.getDate(),
                orderDto.getCustomerID()
        );
        orderRepository.save(order);


        for(OrderDetailDto detail : orderDto.getOrderDetailDTOList()) {
            OrderDetail orderDetail = new OrderDetail(
                    orderDto.getOrderID(),
                    detail.getItemId(),
                    detail.getItemQty(),
                    detail.getUnitPrice()

            );
            orderDetailRepository.save(orderDetail);

            Item item = itemRepository.findById(detail.getItemId()).get();
            int currentQty = Integer.parseInt(String.valueOf(item.getQuantity()));
            item.setQuantity(Integer.parseInt(String.valueOf(currentQty-detail.getItemQty())));
            itemRepository.save(item);
        }

    }

    @Override
    public List<OrderDto> getOrders() {
        List<Orders> ordersList =orderRepository.findAll();
        return ordersList.stream().map(order -> {
            OrderDto dto = new OrderDto();
            dto.setOrderID(order.getOrderID());
            dto.setDate(order.getDate());
            dto.setCustomerID(order.getCustomerId());

            return dto;
        }).toList();

    }
}

