package com.netty.start;

import org.junit.Test;

public class NettyServerTest {

    @Test
    public void test() {
        try {
            System.out.println("启动netty服务端");
            new NettyServer().start(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
