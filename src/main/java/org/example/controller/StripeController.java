package org.example.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.example.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class StripeController {
    @Autowired
    private StripeService stripeService;

    @PostMapping("/charge")
    public String charge(@RequestParam("token") String token, @RequestParam("amount") double amount) {
        try {
            Charge charge = stripeService.createCharge(token, amount);
            return "Charge created: " + charge.getId();
        } catch (StripeException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
