package com.tocker.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CommonController {

    @GetMapping
    @ResponseBody
    public Object home() {
        return "hello";
    }

    @GetMapping("/inside")
    @ResponseBody
    public Object inside() {
        return "hello inside";
    }

}
