package org.converterinfojsonapi.logic;

//import org.converterinfojsonapi.entity.ClassMessage;
import org.converterinfojsonapi.entity.IMessage;
import org.converterinfojsonapi.entity.InputMessage;
import org.converterinfojsonapi.entity.OutputMessage;
import org.springframework.stereotype.Component;

@Component
public interface IConverter {
    IMessage convertor(InputMessage inputMessage);

}
