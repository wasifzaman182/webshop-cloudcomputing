package org.example.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.example.service.Impl.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
@CrossOrigin(origins = "http://localhost:3000")
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
