package com.stocksense.service;
import com.razorpay.*;import org.json.JSONObject;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Service;import java.math.BigDecimal;import java.util.Map;
@Service public class PaymentService{
 @Value("${razorpay.key-id:}")private String key;@Value("${razorpay.key-secret:}")private String secret;
 public Map<String,Object> createOrder(BigDecimal amount,String currency){if(key==null||key.isBlank()||secret==null||secret.isBlank())throw new IllegalStateException("Razorpay test credentials are not configured");try{RazorpayClient client=new RazorpayClient(key,secret);JSONObject data=new JSONObject();data.put("amount",amount.multiply(new BigDecimal("100")).longValueExact());data.put("currency",currency);data.put("receipt","stocksense-"+System.currentTimeMillis());data.put("payment_capture",1);Order order=client.orders.create(data);return Map.of("id",order.get("id"),"amount",order.get("amount"),"currency",order.get("currency"),"status",order.get("status"),"keyId",key);}catch(Exception e){throw new IllegalStateException("Razorpay order creation failed",e);}}
}
