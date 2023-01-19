package org.converterinfojsonapi.service;

import java.util.Date;

// класс сообщений
public class ClassMessage {
    public interface IMessage{}


    // класс простого сообщения
    public static class Message implements IMessage {
        public String message;  // строка сообщения
        public Date time;       // время сообщения

        public Message(String message) {
            this.message = message;
            this.time = new Date(); // записываем время создания сообщения
        }

        @Override
        public String toString() {
            return time + ": " + message;
        }
    }

    // входное сообщение
    public static class InputMessage implements IMessage {
        // входные данные для конвертера
        private String from;
        private String to;
        private double value;

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
//ИЗМЕНЕНИЕ ТИПА РЕЗУЛЬТАТА- возвращаем только значение
    // сообщение результата -
    public static class OutputMessage implements IMessage {
       // private String from;
       // private String to;
        private double value; //может только его и передавать

//        public OutputMessage(String from, String to, double value) {
//            this.from = from;
//            this.to = to;
//            this.value = value;
 //       }
        public OutputMessage(double value) {
            this.value = value;
        }
//        public String getFrom() {
//            return from;
//        }
//
//        public void setFrom(String from) {
//            this.from = from;
//        }
//
//        public String getTo() {
//            return to;
//        }
//
//        public void setTo(String to) {
//            this.to = to;
//        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    // сообщение ошибки
    public static class ErrorMessage extends Message{
        public ErrorMessage(String error) {
            super(error);
        }
    }



}
