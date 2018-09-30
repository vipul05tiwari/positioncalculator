package com.pc.domain;

import com.pc.enums.AccountType;
import com.pc.enums.TransactionType;
import org.junit.Test;

import static org.junit.Assert.*;

/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file, 
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
public class PositionTest {

    @Test
    public void buy_internal_updatePosition() {
        Position position = new Position();
        position.setQuantity(200);
        position.setAccountType(AccountType.INTERNAL);

        Transaction transaction = new Transaction();
        transaction.setTransactionQuantity(100);
        transaction.setTransactionType(TransactionType.BUY);

        position.updatePosition(transaction);

        assertEquals(100,position.getQuantity());
        assertEquals(-100,position.getDelta());
    }

    @Test
    public void buy_external_updatePosition() {
        Position position = new Position();
        position.setQuantity(200);
        position.setAccountType(AccountType.EXTERNAL);

        Transaction transaction = new Transaction();
        transaction.setTransactionQuantity(100);
        transaction.setTransactionType(TransactionType.BUY);

        position.updatePosition(transaction);

        assertEquals(300,position.getQuantity());
        assertEquals(100,position.getDelta());
    }

    @Test
    public void sell_internal_updatePosition() {
        Position position = new Position();
        position.setQuantity(200);
        position.setAccountType(AccountType.INTERNAL);

        Transaction transaction = new Transaction();
        transaction.setTransactionQuantity(100);
        transaction.setTransactionType(TransactionType.SELL);

        position.updatePosition(transaction);

        assertEquals(300,position.getQuantity());
        assertEquals(100,position.getDelta());
    }

    @Test
    public void sell_external_updatePosition() {
        Position position = new Position();
        position.setQuantity(200);
        position.setAccountType(AccountType.EXTERNAL);

        Transaction transaction = new Transaction();
        transaction.setTransactionQuantity(100);
        transaction.setTransactionType(TransactionType.SELL);

        position.updatePosition(transaction);

        assertEquals(100,position.getQuantity());
        assertEquals(-100,position.getDelta());
    }
}