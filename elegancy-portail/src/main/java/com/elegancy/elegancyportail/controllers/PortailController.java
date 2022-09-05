package com.elegancy.elegancyportail.controllers;

import com.elegancy.elegancyportail.beans.ProductBean;
import com.elegancy.elegancyportail.proxies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PortailController {
    @Autowired
    private ProductProxy productProxy;

    @Autowired
    private ClientProxy clientProxy;

    @Autowired
    private DeliveryProxy deliveryProxy;

    @Autowired
    private OrderProxy orderProxy;

    @Autowired
    private PaymentProxy paymentProxy;

    @Autowired
    private  CategoryProxy categoryProxy;

    @GetMapping("/")
    public String accueil(Model model){
        List<ProductBean> products = productProxy.allProducts();
        model.addAttribute("products", products);
        return "index";
    }

}
