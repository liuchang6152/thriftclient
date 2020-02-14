package com.liuchang.thriftclient.controller;

import com.liuchang.thrift.Person;
import com.liuchang.thriftclient.service.PersonServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 12:52 2020/2/14
 * @ Description：
 * @ Modified By：
 */
@CrossOrigin
@RestController
@RequestMapping("api/ap/thrift")
public class ThriftController {
    @Autowired
    private PersonServiceInter personServiceInter;
    @GetMapping
    public Person getPersonByUsername(String username){
       return personServiceInter.getPersonByUserName(username);
    }

}
