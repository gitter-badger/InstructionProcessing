package io.github.adnang.InstructionProcessing;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionQueueTest{



    /**
     * Tests that the addInstruction() method places an InstructionMessage object in the queue given a set of integers
     * as input
     *
     * @throws Exception
     */
    @Test
    public void test_addInstruction_creates_queue_entry() throws Exception {
        final int //arbitrary values
                INSTRUCTION_TYPE = 50,
                PRODUCT_CODE = 10,
                QUANTITY = 10,
                UOM = 100,
                TIME_STAMP = 1000;

        InstructionQueue instructionQueue = new InstructionQueue();
        instructionQueue.addInstruction(INSTRUCTION_TYPE,PRODUCT_CODE,QUANTITY,UOM,TIME_STAMP);
        assertEquals(1,instructionQueue.getQueue().size());
    }
}