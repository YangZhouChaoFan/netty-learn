package com.netty.start.test;

import com.netty.start.client.NettyClient;

/**
 * Created by chenhao on 2016/3/17.
 */
public class ClientTest {

    public static void main(String[] args) throws Exception {

        NettyClient client = new NettyClient();
        client.connect("127.0.0.1", 3000);

    }
}
