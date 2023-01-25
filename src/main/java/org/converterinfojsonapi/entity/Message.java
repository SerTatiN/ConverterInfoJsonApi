package org.converterinfojsonapi.entity;

import java.util.Date;

public class Message implements IMessage{
    // класс простого сообщения

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
