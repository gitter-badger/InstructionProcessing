package io.github.adnang.InstructionProcessing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionQueueTest{

    //valid and invalid message values
    final int
        VAL_INSTRUCTION_TYPE = 50,  INV_INSTRUCTION_TYPE = 110,
        VAL_PRODUCT_CODE = 10,      INV_PRODUCT_CODE = -10,
        VAL_QUANTITY = 10,          INV_QUANTITY = -10,
        VAL_UOM = 100,              INV_UOM = 300,
        VAL_TIME_STAMP = 1000,      INV_TIME_STAMP = -10;

    /**
     * Tests that the addInstruction() method places an InstructionMessage object in the queue given a set of integers
     * as input
     *
     * @throws Exception
     */
    @Test
    public void test_addInstruction_creates_queue_entry() throws Exception {

        InstructionQueue instructionQueue = new InstructionQueue();
        instructionQueue.addInstruction(
                VAL_INSTRUCTION_TYPE,
                VAL_PRODUCT_CODE,
                VAL_QUANTITY,
                VAL_UOM,
                VAL_TIME_STAMP
        );
        assertEquals(1,instructionQueue.getQueue().size());
    }

    @Test(expected=InvalidMessageException.class)
    public void test_addInstruction_with_invalid_type_throws_inv_msg_exception() throws Exception {

    }
}