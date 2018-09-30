/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file, 
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pc.enums.TransactionType;

/**
 * {@link Transaction} represents transaction detail <br/>
 * <p>
 * User: vipul<br/>
 * Date: 28/09/18<br/>
 * Time: 8:53 PM<br/>
 */

public class Transaction {

    @JsonProperty("TransactionId")
    private long transactionId;

    @JsonProperty("Instrument")
    private String instrument;

    @JsonProperty("TransactionType")
    private TransactionType transactionType;

    @JsonProperty("TransactionQuantity")
    private long transactionQuantity;


    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public long getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(long transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", instrument='" + instrument + '\'' +
                ", transactionType=" + transactionType +
                ", transactionQuantity=" + transactionQuantity +
                '}';
    }
}
