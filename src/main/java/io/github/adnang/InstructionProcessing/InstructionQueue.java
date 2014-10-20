package io.github.adnang.InstructionProcessing;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Represents the Instruction Queue. Contains a Priority queue object and a factory method for Instruction Messages.
 *
 * @author Adnan Gazi
 * @since 20/10/14
 * @version 1.0
 */
public class InstructionQueue {

    private final PriorityQueue<InstructionMessage> queue = new PriorityQueue<>();

    /**
     * Gets the instruction queue object (for testing purposes)
     *
     * @return the PriorityQueue object
     */
    public Queue getQueue() {
        return queue;
    }

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
    public void addInstruction(int instructionType, int productCode, int quantity, int uom, int timeStamp) {
        queue.add(new InstructionMessage(
                instructionType,
                productCode,
                quantity,
                uom,
                timeStamp));
    }
}
