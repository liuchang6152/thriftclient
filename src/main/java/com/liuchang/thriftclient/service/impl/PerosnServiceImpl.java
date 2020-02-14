package com.liuchang.thriftclient.service.impl;

import com.liuchang.thrift.Person;
import com.liuchang.thriftclient.common.ThriftClient;
import com.liuchang.thriftclient.service.PersonServiceInter;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:13 2020/2/14
 * @ Description：
 * @ Modified By：
 */
@Service
public class PerosnServiceImpl implements PersonServiceInter {
    @Autowired
    private ThriftClient thriftClient;
    @Override
    public Person getPersonByUserName(String username) {
        try {
            thriftClient.open();
            return thriftClient.getThriftClient().getPersonByUsername("123");
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }finally {
            thriftClient.close();
        }
    }
    @Override
    public void savePerson(Person person) {
        try {
            person=new Person();
            person.setUsername("zhangsan");
            person.setAge(11);
            person.setMarried(false);
            thriftClient.open();
            thriftClient.getThriftClient().savePerson(person);
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            thriftClient.close();
        }
    }
}
