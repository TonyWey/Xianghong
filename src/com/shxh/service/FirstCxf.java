package com.shxh.service;

import org.apache.cxf.annotations.WSDLDocumentation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "hello",targetNamespace="http://service.shxh/hello")
@WSDLDocumentation(value = "接口的简单测试",placement = WSDLDocumentation.Placement.SERVICE)
public interface FirstCxf {

    @WebMethod(operationName = "sayHi",action = "http://service.shxh/hello")
    @WSDLDocumentation(value = "方法的测试",placement = WSDLDocumentation.Placement.BINDING_OPERATION)
    @WebResult(name = "sayHiResult")
    String sayHi(@WebParam()String xml);
}
