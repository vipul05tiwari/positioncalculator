/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/

package com.pc.parsers.impl;

import com.pc.domain.Position;
import com.pc.enums.AccountType;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;


public class CSVPositionParserTest {

    @Test
    public void parsePositionDetail() throws IOException {

        CSVPositionParser csvPositionParser = new CSVPositionParser();
        List<Position> positions = csvPositionParser.parse(new File("src/test/resources/Position.txt"));

        Position position = new Position();
        position.setInstrument("IBM");
        position.setAccount(101);
        position.setAccountType(AccountType.EXTERNAL);
        position.setQuantity(100000);

        assertEquals(positions.size() , 1);

        assertEquals(positions.get(0).getInstrument(), position.getInstrument());
        assertEquals(positions.get(0).getAccount(), position.getAccount());
        assertEquals(positions.get(0).getAccountType(), position.getAccountType());
        assertEquals(positions.get(0).getQuantity(), position.getQuantity());

    }


    @Test(expected = IOException.class)
    public void parsePositionDetailsIOException() throws IOException {

        CSVPositionParser csvPositionParser = new CSVPositionParser ();
        csvPositionParser
                .parse(new File("src/test/resources/Transactions1.txt"));
    }

}