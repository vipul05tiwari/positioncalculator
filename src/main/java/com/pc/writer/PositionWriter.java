/*******************************************************************************************************
 *
 * Copyright (C) Vipul Tiwari,
 * All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential.
 *
 *******************************************************************************************************/
package com.pc.writer;

import com.pc.domain.Position;

import java.util.List;

/**
 * It writes Position detail i n file<br/>
 * <p>
 * User: vipul<br/>
 * Date: 30/09/18<br/>
 * Time: 11:34 AM<br/>
 */
public interface PositionWriter {

    /**
     * Writes the list of {@link Position} to outputFilePath
     *
     * @param positionList
     * @param outputFilePath
     */
    public void writePosition(List<Position> positionList, String outputFilePath);
}
