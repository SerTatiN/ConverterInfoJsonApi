package org.converterinfojsonapi.service;

import org.converterinfojsonapi.logic.IConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/service")
public class ConverterService {
    @Autowired
    private IConverter converter;


    @GetMapping("/ping")
    public @ResponseBody ClassMessage.Message ping(){
        return new ClassMessage.Message("pong");
    }

    @GetMapping("/status")
    public @ResponseBody ClassMessage.Message status(){
        return new ClassMessage.Message("status ok at port 8080");
    }

    @GetMapping("/convert")
    public @ResponseBody ClassMessage.IMessage convert(@RequestBody ClassMessage.InputMessage input){
        ClassMessage.OutputMessage  output = converter.convertor(input);
        if (output == null) {
            return new ClassMessage.ErrorMessage("no corrected input date");
        } else {
            return output;
        }
    }

}
