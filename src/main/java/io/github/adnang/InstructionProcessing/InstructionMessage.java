package io.github.adnang.InstructionProcessing;

/**
 * Holds an Instruction Message attributes with getters.
 */
public class InstructionMessage {
    private final int
            instructionType,
            productCode,
            quantity,
            uom,
            timeStamp;

    public InstructionMessage(int instructionType, int productCode, int quantity, int uom, int timeStamp) {
        this.instructionType = instructionType;
        this.productCode = productCode;
        this.quantity = quantity;
        this.uom = uom;
        this.timeStamp = timeStamp;
    }

    public int getInstructionType() {
        return instructionType;
    }

    public int getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUom() {
        return uom;
    }

    public int getTimeStamp() {
        return timeStamp;
    }
}
