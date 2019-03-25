package com.shxh.service.impl;

import com.shxh.service.FirstCxf;

import javax.jws.WebService;

@WebService(name = "hello",targetNamespace="http://service.shxh/hello",serviceName = "hello",portName = "HelloServiceSoap",endpointInterface = "com.shxh.service.FirstCxf")
public class FirstCxfImpl implements FirstCxf {
    @Override
    public String sayHi(String xml) {
        return "等待我的处理...";
    }
}
