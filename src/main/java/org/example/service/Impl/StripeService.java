package org.example.service.Impl;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    private static final Logger logger = LoggerFactory.getLogger(StripeService.class);

    @Value("${stripe.api.publishableKey}")
    private String publishableKey;

    public Charge createCharge(String token, double amount) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", (int) (amount * 100)); // Amount in cents
        chargeParams.put("currency", "usd");
        chargeParams.put("source", token);
        chargeParams.put("description", "Charge for product");

        return Charge.create(chargeParams);
    }
}
