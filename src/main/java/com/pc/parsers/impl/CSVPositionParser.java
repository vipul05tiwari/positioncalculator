/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file, 
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.parsers.impl;

import com.opencsv.CSVReader;
import com.pc.domain.Position;
import com.pc.enums.AccountType;
import com.pc.parsers.PositionParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link CSVPositionParser} is implementation of {@link PositionParser}, it writes reads position for csv file<br/>
 * <p>
 * User: vipul<br/>
 * Date: 28/09/18<br/>
 * Time: 11:39 PM<br/>
 */

public class CSVPositionParser implements PositionParser {

    /**
     * Parse the csv file and creates list of Positions
     * @param positionFile
     * @return list of {@link Position}
     * @throws IOException
     */
    public List<Position> parse(File positionFile) throws IOException {

        List<Position> positionList = new ArrayList<Position>();

        CSVReader reader = new CSVReader(new FileReader(positionFile), ',');

        //read line by line
        String[] record = null;
        //skip header row
        reader.readNext();

        while((record = reader.readNext()) != null){
            Position position = new Position(); //Instrument,Account,AccountType,Quantity
            position.setInstrument(record[0]);
            position.setAccount(Long.parseLong(record[1]));
            position.setAccountType(AccountType.getAccountTypeEnum(record[2]));
            position.setQuantity(Long.parseLong(record[3]));

            positionList.add(position);
        }

        reader.close();

        return positionList;
    }
}
