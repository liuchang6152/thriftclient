package com.liuchang.thriftclient.service;

import com.liuchang.thrift.Person;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:11 2020/2/14
 * @ Description：
 * @ Modified By：
 */
public interface PersonServiceInter {

    public Person getPersonByUserName(String username);

    public void savePerson(Person person);
}
