package com.example.lovro.myapplication.domain;

import com.squareup.moshi.Json;

public class NotificationStyleSuggest extends Notification {

    private Order order;

    public NotificationStyleSuggest(Order order) {
        this.order=order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NotificationStyleSuggest){
            NotificationStyleSuggest help = (NotificationStyleSuggest) obj;
            return help.order.equals(this.order);
        }
        return false;
    }
}
