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
     * InvalidMessageException otherwise.
     *
     * @param instructionType
     * @param productCode
     * @param quantity
     * @param uom
     * @param timeStamp
     */
    public void addInstruction(int instructionType, int productCode, int quantity, int uom, int timeStamp)
            throws InvalidMessageException
    {

        if (instructionType <= 0 || instructionType >= 100) throw new InvalidMessageException();
        if (productCode <= 0 || quantity <= 0) throw new InvalidMessageException();
        if (uom < 0 || uom >= 256) throw new InvalidMessageException();

        add(new InstructionMessage(
                instructionType,
                productCode,
                quantity,
                uom,
                timeStamp));
    }
}
