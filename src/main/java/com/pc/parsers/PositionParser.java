/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/


package com.pc.parsers;

import com.pc.domain.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


/**
 * {@link PositionParser} use to parse position detail <br/>
 * <p>
 * User: vipul<br/>
 * Date: 28/09/18<br/>
 * Time: 8:53 PM<br/>
 */

public interface PositionParser {

    /**
     * Parses positionFile and returns list of {@link Position}
     * @param positionFile
     * @return list of {@link Position}
     * @throws  IOException
     */
    List<Position> parse(File positionFile) throws IOException;
}
