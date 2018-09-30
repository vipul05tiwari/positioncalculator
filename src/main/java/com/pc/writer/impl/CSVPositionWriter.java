/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file, 
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.writer.impl;

import com.opencsv.CSVWriter;
import com.pc.domain.Position;
import com.pc.writer.PositionWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link CSVPositionWriter} is implementation of PositionWriter, it writes Position detail in csv file<br/>
 * <p>
 * User: vipul<br/>
 * Date: 30/09/18<br/>
 * Time: 11:34 AM<br/>
 */

public class CSVPositionWriter implements PositionWriter {

    /**
     * Writes the details of {@link Position} to outputFilePath
     * @param positionList
     * @param outputFilePath
     */
    public void writePosition(List<Position> positionList , String outputFilePath) {

        File file = new File(outputFilePath,"EOD_Position.txt");

        try {
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[]{"Instrument","Account","AccountType","Quantity","Delta"});
            for (Position position: positionList) {
                data.add(new String[] { position.getInstrument(), Long.toString(position.getAccount()),
                        position.getAccountType().getValue(), Long.toString(position.getQuantity()),
                        Long.toString(position.getDelta())});
            }

            writer.writeAll(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
