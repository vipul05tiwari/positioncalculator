/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file, 
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.parsers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pc.domain.Transaction;
import com.pc.parsers.TransactionParser;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * {@link JSONTransactionParser} is implementation of {@link TransactionParser}, it reads transaction file and return list of Transaction <br/>
 * <p>
 * User: vipul<br/>
 * Date: 28/09/18<br/>
 * Time: 9:19 PM<br/>
 */

public class JSONTransactionParser implements TransactionParser {

    private ObjectMapper mapper = new ObjectMapper();

    public List<Transaction> parse(File transactionFile) throws IOException {

        List<Transaction> transactions = Arrays.asList(mapper.readValue(transactionFile, Transaction[].class));

        return transactions;
    }
}
