package com.elegancy.elegancyportail.proxies;

import com.elegancy.elegancyportail.beans.OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ZUUL-SERVER")
public interface OrderProxy {
    @GetMapping(path = "/ordered-service/api/orders")
    public List<OrderBean> allOrders();
    @GetMapping(path = "/ordered-service/api/orders/{id}")
    public OrderBean getOrderById(@PathVariable Long id);
    @PostMapping(path = "/ordered-service/api/orders")
    public OrderBean saveOrder(@RequestBody OrderBean requestDto);
    @PutMapping(path = "/ordered-service/api/orders/{id}")
    public OrderBean updateOrder(@PathVariable Long id,@RequestBody OrderBean requestDto);
    @DeleteMapping(path = "/ordered-service/api/orders/{id}")
    public  void deleteOrder(@PathVariable Long id);
}
