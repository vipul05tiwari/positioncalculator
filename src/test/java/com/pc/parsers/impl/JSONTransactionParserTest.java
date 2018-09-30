/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/

package com.pc.parsers.impl;

import com.pc.domain.Transaction;
import com.pc.enums.TransactionType;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JSONTransactionParserTest {

    @Test
    public void parseTransactionDetails() throws IOException {

        JSONTransactionParser jsonTransactionParser = new JSONTransactionParser();
        List<Transaction> transactions = jsonTransactionParser
                .parse(new File("src/test/resources/Transactions.txt"));


        Transaction transaction = new Transaction();
        transaction.setInstrument("IBM");
        transaction.setTransactionId(1);
        transaction.setTransactionQuantity(1000);
        transaction.setTransactionType(TransactionType.BUY);

        assertEquals(transactions.size(), 1);
        assertEquals(transactions.get(0).getInstrument(), transaction.getInstrument());
        assertEquals(transactions.get(0).getTransactionId(), transaction.getTransactionId());
        assertEquals(transactions.get(0).getTransactionQuantity(), transaction.getTransactionQuantity());
        assertEquals(transactions.get(0).getTransactionType(), transaction.getTransactionType());
    }


    @Test(expected = IOException.class)
    public void parseTransactionDetailsIOException() throws IOException {

        JSONTransactionParser jsonTransactionParser = new JSONTransactionParser();
        List<Transaction> transactions = jsonTransactionParser
                .parse(new File("src/test/resources/Transactions1.txt"));
    }
}