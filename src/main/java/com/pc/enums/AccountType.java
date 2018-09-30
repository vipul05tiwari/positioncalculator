/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents Account Type<br/>
 * <p>
 * User: vipul<br/>
 * Date: 30/09/18<br/>
 * Time: 11:28 AM<br/>
 */
public enum AccountType {

    INTERNAL("I"),
    EXTERNAL("E");

    private String value;
    private static Map<String, AccountType> valueMap = new HashMap<String, AccountType>();

    static {
        AccountType[] values = AccountType.values();
        for (AccountType accountType : values) {
            valueMap.put(accountType.getValue(), accountType);
        }

    }

    private AccountType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public static AccountType getAccountTypeEnum(String accountType){
        return valueMap.get(accountType);
    }

}
