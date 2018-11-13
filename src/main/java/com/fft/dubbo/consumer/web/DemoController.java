package com.fft.dubbo.consumer.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fft.dubbo.consumer.service.DemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference(version = "1.0.0")
    private DemoService demoService;

    @RequestMapping("/{name}")
    public String say(@PathVariable("name") String name){
        return demoService.sayHello(name);
    }
}
