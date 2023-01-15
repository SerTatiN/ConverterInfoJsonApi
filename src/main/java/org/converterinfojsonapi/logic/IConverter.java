package org.converterinfojsonapi.logic;

import org.apache.logging.log4j.message.Message;
import org.converterinfojsonapi.service.ClassMessage;
import org.springframework.stereotype.Component;

@Component
public interface IConverter {
    ClassMessage.OutputMessage convertor(ClassMessage.InputMessage inputMessage);

}
