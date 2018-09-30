/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file, 
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.launch;

import com.pc.parsers.impl.CSVPositionParser;
import com.pc.parsers.impl.JSONTransactionParser;
import com.pc.writer.impl.CSVPositionWriter;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link AppLauncher} is used to launch application<br/>
 * <p>
 * User: vipul<br/>
 * Date: 30/09/18<br/>
 * Time: 11:28 AM<br/>
 */

public class AppLauncher {

    private static final Logger logger = LoggerFactory.getLogger(AppLauncher.class);

    public static void main(String[] args) {
        try {
            // create Options object
            Options options = new Options();

            // add t option
            options.addOption("p","position" ,true, "Position File Full Path");
            options.addOption("t","transaction" ,true, "Transaction File Full Path");
            options.addOption("o","output" ,true, "Output dir File Full Path");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse( options, args);

            logger.info("Position File : [{}]", cmd.getOptionValue("p"));
            logger.info("Transaction File : [{}]", cmd.getOptionValue("t"));
            logger.info("Output directory : [{}]", cmd.getOptionValue("o"));

            if( cmd.hasOption("p")  && cmd.hasOption("t") && cmd.hasOption("o")) {
                PositionCalculator appLauncher = new PositionCalculator(cmd.getOptionValue("p"), cmd.getOptionValue("t"), cmd.getOptionValue("o"));
                appLauncher.setPositionParser(new CSVPositionParser());
                appLauncher.setTransactionParser(new JSONTransactionParser());
                appLauncher.setPositionWriter(new CSVPositionWriter());
                appLauncher.calculatePosition();
                logger.info("Position calculator finished successfully ...");
            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "AppLauncher", options );
            }
        } catch (ParseException e) {
            logger.error("Exception occurred ",e);
        }
    }
}
