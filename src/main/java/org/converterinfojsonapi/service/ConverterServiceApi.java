package org.converterinfojsonapi.service;

import org.converterinfojsonapi.entity.*;
import org.converterinfojsonapi.logic.IConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/service")
public class ConverterServiceApi {
    @Autowired
    private IConverter converter;

    @GetMapping("/ping")
    public @ResponseBody Message ping(){
    return new Message("pong");
}

    @GetMapping("/status")
    public @ResponseBody Message status(){
        return new Message("status ok at port 8080");
    }


    @PostMapping("/convert")
    public @ResponseBody IMessage convert(@RequestBody InputMessage input) {
        IMessage output = converter.convertor(input);
        if (output == null) {
            return new ErrorMessage("no corrected input date");
        } else {
            return output;
        }
    }

}
