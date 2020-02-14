package com.liuchang.thriftclient.common;

import com.liuchang.thrift.PersonService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 13:13 2020/2/14
 * @ Description：
 * @ Modified By：
 */
public class ThriftClient {
    private PersonService.Client thriftClient;
    private TTransport tTransport;
    private TProtocol protocol;
    private String host;
    private int port;

    public PersonService.Client getThriftClient() {
        return thriftClient;
    }

    public void setThriftClient(PersonService.Client thriftClient) {
        this.thriftClient=thriftClient;
    }

    public TTransport gettTransport() {
        return tTransport;
    }

    public void settTransport(TTransport tTransport) {
        this.tTransport=tTransport;
    }

    public TProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(TProtocol protocol) {
        this.protocol=protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host=host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port=port;
    }

    public void init() {
        tTransport = new TFastFramedTransport(new TSocket(host, port),600);
        protocol =  new TCompactProtocol(tTransport);
        thriftClient = new PersonService.Client(protocol);
    }
    public  void  open() throws TTransportException {
        if(!tTransport.isOpen())
           tTransport.open();
    }

    public  void  close(){
        tTransport.close();
    }
}
