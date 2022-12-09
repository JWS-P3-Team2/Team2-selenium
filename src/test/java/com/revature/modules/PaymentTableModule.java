package com.revature.modules;

import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentTableModule extends TableModule {

    public List<PaymentRowModule> getPaymentRows() {
        return rows.stream().map(row -> {
            return PageFactory.initElements(
                    row,
                    PaymentRowModule.class
            );
        }).collect(Collectors.toList());
    }

}
