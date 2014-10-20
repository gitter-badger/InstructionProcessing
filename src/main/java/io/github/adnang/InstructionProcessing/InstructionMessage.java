package io.github.adnang.InstructionProcessing;

/**
 * Holds an Instruction Message attributes with getters.
 */
public class InstructionMessage implements Comparable<InstructionMessage>{
    private final int
            instructionType,
            productCode,
            quantity,
            uom,
            timeStamp;

    /**
     * Validates constructor parameters as determined by spec.
     *
     * @param instructionType
     * @param productCode
     * @param quantity
     * @param uom
     * @param timeStamp
     * @throws InvalidMessageException
     */
    public InstructionMessage(int instructionType, int productCode, int quantity, int uom, int timeStamp)
        throws InvalidMessageException
    {

        if (instructionType <= 0 || instructionType >= 100)
            throw new InvalidMessageException();
        if (productCode <= 0 || quantity <= 0 || timeStamp <= 0)
            throw new InvalidMessageException();
        if (uom < 0 || uom >= 256)
            throw new InvalidMessageException();

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

    /**
     * Returns 1 for high priority, 0 for medium priority, -1 for low priority.
     * @return
     */
    public int getPriority(){
        if (instructionType > 0 && instructionType < 11)
            return 1;
        if (instructionType > 10 && instructionType < 91)
            return 0;
        return -1;
    }

    /**
     * Allows priority queue to compare its objects based on the instruction type priorities
     * @param m
     * @return
     */
    @Override
    public int compareTo(InstructionMessage m) {
        if (getPriority() > m.getPriority()) //this has higher priority, push ahead in queue
            return -1;
        else if (getPriority() < m.getPriority()) //this has lower priority, push behind in queue
            return 1;
        else return 0; //has same priority, do nothing
    }

    /**
     * Prints objects to console by their priority and type value.
     *
     * @return
     */
    @Override
    public String toString() {
        String out = "";
        if (getPriority() == 1) out+= "high ";
        if (getPriority() == 0) out+= "medium ";
        if (getPriority() == -1) out+= "low ";
        return out += instructionType;
    }
}
