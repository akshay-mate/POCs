package com.example.signature2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Getter
@Setter
public class RequestFields
{
    @JsonProperty("customerFirstName")
    private String customerFirstName;
    @JsonProperty("customerLastName")
    private String customerLastName;
    @JsonProperty("paymentRequestId")
    private String paymentRequestId;
    @JsonProperty("country")
    private String country;
    @JsonProperty("vendorName")
    private String vendorName;
    @JsonProperty("referenceNumber")
    private String referenceNumber;
    @JsonProperty("signedFields")
    private String signedFields;
    @JsonProperty("SecretKey")
    private String SecretKey;
    @JsonProperty("transactionUuid")
    private String transactionUuid;
    @JsonProperty("requestTimestamp")
    private String requestTimestamp;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("taxAmount")
    private String taxAmount;
    @JsonProperty("requestType")
    private String requestType;
    @JsonProperty("recurringFrequency")
    private String recurringFrequency;
    @JsonProperty("recurringAmount")
    private String recurringAmount;
    @JsonProperty("recurringInstallments")
    private String recurringInstallments;
    @JsonProperty("customerIpaddress")
    private String customerIpaddress;
    @JsonProperty("customerCookiesAccepted")
    private String customerCookiesAccepted;
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("orderId")
    private String orderId;
    @JsonProperty("orderDate")
    private String orderDate;
    @JsonProperty("billToCompanyName")
    private String billToCompanyName;
    @JsonProperty("billToPhone")
    private String billToPhone;
    @JsonProperty("billtoEmail")
    private String billtoEmail;
    @JsonProperty("billToAddressLine1")
    private String billToAddressLine1;
    @JsonProperty("billToAddressLine2")
    private String billToAddressLine2;
    @JsonProperty("billToAddressCity")
    private String billToAddressCity;
    @JsonProperty("billToAddressState")
    private String billToAddressState;
    @JsonProperty("billToAddressCountry")
    private String billToAddressCountry;
    @JsonProperty("billToAddressPostalCode")
    private String billToAddressPostalCode;




}