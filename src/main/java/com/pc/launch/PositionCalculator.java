/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file, 
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.launch;

import com.pc.domain.Position;
import com.pc.domain.Transaction;
import com.pc.parsers.PositionParser;
import com.pc.parsers.TransactionParser;
import com.pc.parsers.impl.CSVPositionParser;
import com.pc.parsers.impl.JSONTransactionParser;
import com.pc.writer.PositionWriter;
import org.apache.commons.cli.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link PositionCalculator} calculates the position based on start of day position and transactions<br/>
 * <p>
 * User: vipul<br/>
 * Date: 29/09/18<br/>
 * Time: 11:56 PM<br/>
 */

public class PositionCalculator {

    private static final Logger logger = LoggerFactory.getLogger(PositionCalculator.class);

    private PositionParser positionParser;
    private TransactionParser transactionParser;
    private PositionWriter positionWriter;

    private File optionFile;
    private File transactionFile;
    private String outputDir;

    private Map<String, List<Position>> instrumentPositionMap;

    public PositionCalculator(String optionFilePath, String transactionFilePath, String outputDir) {
        this.optionFile = new File(optionFilePath);
        this.transactionFile = new File(transactionFilePath);
        this.outputDir = outputDir;
    }

    public void calculatePosition() {
        try {
            instrumentPositionMap = new HashMap<String, List<Position>>();

            logger.info("Parsing start of day position file");
            List<Position> positionList = positionParser.parse(optionFile);
            logger.info("Extracted [{}] position detail", positionList.size());

            logger.info("Parsing transaction file");
            List<Transaction> transactionList = transactionParser.parse(transactionFile);
            logger.info("Extracted [{}] transaction detail", transactionList.size());

            logger.info("Grouping position by instrument");
            for (Position position : positionList) {
                List<Position> positionNewList = null;
                if(instrumentPositionMap.containsKey(position.getInstrument())) {
                    positionNewList = instrumentPositionMap.get(position.getInstrument());
                } else {
                    positionNewList = new ArrayList<Position>();
                    instrumentPositionMap.put(position.getInstrument(), positionNewList);
                }
                positionNewList.add(position);
            }

            logger.info("Calculating position ....");
            for (Transaction transaction: transactionList) {
                List<Position> positionList1 = instrumentPositionMap.get(transaction.getInstrument());
                for (Position  position: positionList1) {
                    position.updatePosition(transaction);
                }
            }

            logger.info("Writing position");
            for (Position position : positionList) {
                logger.info(position.toString());
            }

            positionWriter.writePosition(positionList, outputDir);

        } catch (Exception ex) {
            logger.error("Exeption occurred while calculating position");
        }
    }


    public void setPositionParser(PositionParser positionParser) {
        this.positionParser = positionParser;
    }

    public void setTransactionParser(TransactionParser transactionParser) {
        this.transactionParser = transactionParser;
    }

    public void setPositionWriter(PositionWriter positionWriter) {
        this.positionWriter = positionWriter;
    }
}
