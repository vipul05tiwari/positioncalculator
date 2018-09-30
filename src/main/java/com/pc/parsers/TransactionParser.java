/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/

package com.pc.parsers;

import com.pc.domain.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * {@link TransactionParser} use to parse transaction detail <br/>
 * <p>
 * User: vipul<br/>
 * Date: 28/09/18<br/>
 * Time: 8:53 PM<br/>
 */

public interface TransactionParser {
    /**
     * Parses transactionFile and returns list of {@link Transaction}
     *
     * @param transactionFile
     * @return
     * @throws IOException
     */
    List<Transaction> parse(File transactionFile) throws IOException;
}
