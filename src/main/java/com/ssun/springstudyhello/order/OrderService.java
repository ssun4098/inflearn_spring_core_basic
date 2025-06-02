package com.ssun.springstudyhello.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
