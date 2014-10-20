package io.github.adnang.InstructionProcessing;

import java.util.PriorityQueue;

/**
 * Represents the Instruction Queue. Extends Priority Queue class for its collection methods, and overrides constructor
 * to provide the comparator.
 *
 * @author Adnan Gazi
 * @since 20/10/14
 * @version 1.0
 */
public class InstructionQueue extends PriorityQueue<InstructionMessage>{

    /**
     * Creates an InstructionMessage object given a set of integers, and places the object in the queue. Throws an
     * InvalidMessageException if values are invalid.
     *
     * @param instructionType
     * @param productCode
     * @param quantity
     * @param uom
     * @param timeStamp
     */
    public void add(int instructionType, int productCode, int quantity, int uom, int timeStamp)
            throws InvalidMessageException
    {
        add(new InstructionMessage(
                    instructionType,
                    productCode,
                    quantity,
                    uom,
                    timeStamp
                )
        );
    }
}
