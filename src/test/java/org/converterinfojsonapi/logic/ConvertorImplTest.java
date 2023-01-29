package org.converterinfojsonapi.logic;

//import org.converterinfojsonapi.entity.ClassMessage;
import org.converterinfojsonapi.entity.IMessage;
import org.converterinfojsonapi.entity.InputMessage;
import org.converterinfojsonapi.entity.OutputMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertorImplTest {

    @Test
    void convertor() {
        String from = "kb";
        String to = "b";
        double value = 1;
        ConvertorImpl conv = new ConvertorImpl();
        InputMessage input = new InputMessage(from, to, value);
        OutputMessage res = (OutputMessage) conv.convertor(input);
        assertEquals(res.getValue(),1024);

        from = "b";
        to = "kb";
        value = 1038;

        input = new InputMessage(from, to, value);
        res = (OutputMessage) conv.convertor(input);
        assertEquals(res.getValue(),1.013665,0.00001);
        assertEquals(res.getValue(),1.01367,0.00001);
        assertEquals(res.getValue(),1.0136818,0.00001);

        from = "ib";
        to = "b";
        value = 1;

        input = new InputMessage(from, to, value);
        res = (OutputMessage) conv.convertor(input);
        assertNull(res);

        from = "kb";
        to = "b";
        value = -1;

        input = new InputMessage(from, to, value);
        res = (OutputMessage) conv.convertor(input);
        assertNull(res);
    }
}