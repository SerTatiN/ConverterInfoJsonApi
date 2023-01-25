package org.converterinfojsonapi.entity;

// входное сообщение
public class InputMessage implements IMessage{

        // входные данные для конвертера
        private String from;
        private String to;
        private Double value;

    public InputMessage() {
        this.from = "";
        this.to = "";
        this.value = null;
    }

    public InputMessage(String from, String to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

}
