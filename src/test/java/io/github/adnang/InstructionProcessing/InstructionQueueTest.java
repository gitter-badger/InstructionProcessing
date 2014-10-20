package io.github.adnang.InstructionProcessing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionQueueTest{

    // class under test
    final InstructionQueue instructionQueue = new InstructionQueue();

    //valid and invalid message values
    final int
        VAL_INSTRUCTION_TYPE = 50,  INV_INSTRUCTION_TYPE = 110,
        VAL_PRODUCT_CODE = 10,      INV_PRODUCT_CODE = -10,
        VAL_QUANTITY = 10,          INV_QUANTITY = -10,
        VAL_UOM = 100,              INV_UOM = 300,
        VAL_TIME_STAMP = 1000,      INV_TIME_STAMP = -10;

    /**
     * Tests that the overloaded add() method places an InstructionMessage object in the queue given a set of integers
     * as input
     *
     * @throws Exception
     */
    @Test
    public void test_addInstruction_creates_queue_entry() throws Exception {

        instructionQueue.add(
                VAL_INSTRUCTION_TYPE,
                VAL_PRODUCT_CODE,
                VAL_QUANTITY,
                VAL_UOM,
                VAL_TIME_STAMP
        );
        assertEquals(1, instructionQueue.size());
    }

    /**
     * Tests that an exception is thrown when attempting to add message with invalid type.
     *
     * @throws Exception
     */
    @Test(expected=InvalidMessageException.class)
    public void test_addInstruction_with_invalid_type_throws_inv_msg_exception() throws Exception {

        instructionQueue.add(
                INV_INSTRUCTION_TYPE,
                VAL_PRODUCT_CODE,
                VAL_QUANTITY,
                VAL_UOM,
                VAL_TIME_STAMP
        );
    }

    /**
     * Tests that an exception is thrown when attempting to add message with invalid product code.
     *
     * @throws Exception
     */
    @Test(expected=InvalidMessageException.class)
    public void test_addInstruction_with_invalid_pc_throws_inv_msg_exception() throws Exception {

        instructionQueue.add(
                VAL_INSTRUCTION_TYPE,
                INV_PRODUCT_CODE,
                VAL_QUANTITY,
                VAL_UOM,
                VAL_TIME_STAMP
        );
    }

    /**
     * Tests that an exception is thrown when attempting to add message with invalid quantity.
     *
     * @throws Exception
     */
    @Test(expected=InvalidMessageException.class)
    public void test_addInstruction_with_invalid_quant_throws_inv_msg_exception() throws Exception {

        instructionQueue.add(
                VAL_INSTRUCTION_TYPE,
                VAL_PRODUCT_CODE,
                INV_QUANTITY,
                VAL_UOM,
                VAL_TIME_STAMP
        );
    }

    /**
     * Tests that an exception is thrown when attempting to add message with invalid UOM.
     *
     * @throws Exception
     */
    @Test(expected=InvalidMessageException.class)
    public void test_addInstruction_with_invalid_uom_throws_inv_msg_exception() throws Exception {

        instructionQueue.add(
                VAL_INSTRUCTION_TYPE,
                VAL_PRODUCT_CODE,
                VAL_QUANTITY,
                INV_UOM,
                VAL_TIME_STAMP
        );
    }

    /**
     * Tests that an exception is thrown when attempting to add message with invalid time stamp.
     *
     * @throws Exception
     */
    @Test(expected=InvalidMessageException.class)
    public void test_addInstruction_with_invalid_time_throws_inv_msg_exception() throws Exception {

        instructionQueue.add(
                VAL_INSTRUCTION_TYPE,
                VAL_PRODUCT_CODE,
                VAL_QUANTITY,
                VAL_UOM,
                INV_TIME_STAMP
        );
    }

    /**
     * Tests comparator of message queue works by adding a higher priority message after lower priority message and
     * checking their locations.
     *
     * @throws Exception
     */
    @Test
    public void test_higher_priority_message_moves_ahead_of_queue() throws Exception {
        final int HIGH_PRIORITY_TYPE = 1, LOW_PRIORITY_TYPE = 91;
        InstructionMessage high = new InstructionMessage(HIGH_PRIORITY_TYPE,
                VAL_PRODUCT_CODE, VAL_QUANTITY, VAL_UOM, VAL_TIME_STAMP);

        InstructionMessage low = new InstructionMessage(LOW_PRIORITY_TYPE,
                VAL_PRODUCT_CODE, VAL_QUANTITY, VAL_UOM, VAL_TIME_STAMP);

        instructionQueue.add(low);
        instructionQueue.add(high);

        assertEquals(high, instructionQueue.peek());
    }
}