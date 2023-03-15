package com.example.signature2.service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SignService
{
    public static String build(HashMap<String, String> map)
    {
        String signFields = String.valueOf(map.get("signedFields"));
        String[] signedFieldNames = signFields.split(",");
        ArrayList<String> dataToSign = new ArrayList<String>();
        for (String signedFieldName : signedFieldNames)
        {
            dataToSign.add(signedFieldName + "=" + String.valueOf(map.get(signedFieldName)));
        }
        return commaSeparate(dataToSign);
    }

    private static String commaSeparate(ArrayList<String> dataToSign) {
        StringBuilder csv = new StringBuilder();
        for (Iterator<String> it = dataToSign.iterator(); it.hasNext();) {
            csv.append(it.next());
            if (it.hasNext()) {
                csv.append(",");
            }
        }
        return csv.toString();
    }
    public static String sign(String data, String secretKey, String hmac) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), hmac);
        Mac mac = Mac.getInstance(hmac);
        mac.init(secretKeySpec);
        byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
        String signature= DatatypeConverter.printBase64Binary(rawHmac).replace("\n", "");
        return signature;
    }
}
