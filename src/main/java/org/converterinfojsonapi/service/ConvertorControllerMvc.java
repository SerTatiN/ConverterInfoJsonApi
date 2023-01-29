package org.converterinfojsonapi.service;

import org.converterinfojsonapi.entity.*;
import org.converterinfojsonapi.logic.IConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


//@RequestMapping("/contr")
@Controller
public class ConvertorControllerMvc {
    @Autowired
    private IConverter converter;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/ping2")
    public String ping2(Model model){
        Message message = new Message("pong");
        model.addAttribute("message",message);
        return "pong";
    }

     @GetMapping("/status2")
    public String status2(Model model){
        Message message = new Message("status ok at port 8080");
        model.addAttribute("message",message);
        return "status";
    }

    @GetMapping("/service")
    public String serviceForm(){
        System.out.println("servF");
        return "servF";

    }
    @PostMapping("/service-C")
    public String serviceForm(@RequestParam String from,
                              @RequestParam String to,
                              @RequestParam Double value, Model model, RedirectAttributes ra) {

        IMessage output = converter.convertor(new InputMessage(from,to,value));
        if (output!= null) {
            OutputMessage out = (OutputMessage) output;
            System.out.println("value ="+ out.getValue());
           // model.addAttribute("value",out.getValue());
            ra.addFlashAttribute("value", out.getValue());
        }
        else {
            ErrorMessage err = new ErrorMessage("no corrected input date");
           // model.addAttribute("value", err.message);
            ra.addFlashAttribute("value", err.message);
        }
        return "redirect:service";
    }

}
