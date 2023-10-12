package com.kavya.kavya_springboot_session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test {
    @Value("${milkPrice}")
    private int milkPrice;
    @Value("${gstPercentage}")
    private int gstPercentage;

    public void milkPriceRate() {
        Model model = new Model();
        if (milkPrice > 0) {
            model.setMessage("Hurray I got the Price");
            model.setStatus("200");
        }
        System.out.println("Milk Price: " + milkPrice + " " + model.getStatus());
        System.out.println("GST Percentage: " + gstPercentage + " " + model.getMessage());
        System.out.println("Total Price: " + (milkPrice + gstPercentage));
    }
}
