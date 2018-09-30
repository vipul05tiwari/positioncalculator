/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/

package com.pc.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents Transaction Type<br/>
 * <p>
 * User: vipul<br/>
 * Date: 30/09/18<br/>
 * Time: 11:28 AM<br/>
 */

public enum TransactionType {
    BUY("B"),
    SELL("S");

    private String value;
    private static Map<String, TransactionType> valueMap = new HashMap<String, TransactionType>();

    static {
        TransactionType[] values = TransactionType.values();
        for (TransactionType transactionType : values) {
            valueMap.put(transactionType.getValue(), transactionType);
        }

    }

    private TransactionType(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }


    public TransactionType getTransactionTypeEnum(String transactionType){
        return valueMap.get(transactionType);
    }
}
