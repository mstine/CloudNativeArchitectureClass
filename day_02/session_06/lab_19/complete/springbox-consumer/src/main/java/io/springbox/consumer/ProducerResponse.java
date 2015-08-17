package io.springbox.consumer;

public class ProducerResponse {
    private int value;

    public ProducerResponse() {
    }

    public ProducerResponse(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
