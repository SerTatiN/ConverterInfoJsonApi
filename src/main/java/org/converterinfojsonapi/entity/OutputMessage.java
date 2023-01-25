package org.converterinfojsonapi.entity;

public class OutputMessage implements IMessage{
    private Double value; //может только его и передавать

    public OutputMessage() {
        this.value = null;
    }
    public OutputMessage(double value) {
        this.value = value;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
