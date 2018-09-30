/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file, 
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.domain;

import com.pc.enums.AccountType;
import com.pc.enums.TransactionType;

/**
 * {@link Position} represents position of instrument <br/>
 * <p>
 * User: vipul<br/>
 * Date: 28/09/18<br/>
 * Time: 8:20 PM<br/>
 */

public class Position {

    private String instrument;
    private long account;
    private AccountType accountType;
    private long quantity;
    private long delta;


    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getDelta() {
        return delta;
    }

    public void setDelta(long delta) {
        this.delta = delta;
    }

    @Override
    public String toString() {
        return "Position{" +
                "instrument='" + instrument + '\'' +
                ", account=" + account +
                ", accountType=" + accountType +
                ", quantity=" + quantity +
                ", delta=" + delta +
                '}';
    }

    public void updatePosition(Transaction transaction) {
        if((transaction.getTransactionType() == TransactionType.BUY && this.accountType == AccountType.EXTERNAL)
        ||(transaction.getTransactionType() == TransactionType.SELL && this.accountType == AccountType.INTERNAL)){
            quantity += transaction.getTransactionQuantity();
            delta += transaction.getTransactionQuantity();

        } else if((transaction.getTransactionType() == TransactionType.BUY && this.accountType == AccountType.INTERNAL)
                ||(transaction.getTransactionType() == TransactionType.SELL && this.accountType == AccountType.EXTERNAL)){
            quantity -= transaction.getTransactionQuantity();
            delta -= transaction.getTransactionQuantity();
        }

    }
}
