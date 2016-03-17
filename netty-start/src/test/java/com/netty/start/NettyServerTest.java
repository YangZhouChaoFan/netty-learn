package com.netty.start;

import com.netty.start.server.NettyServer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServerTest {

    static private Logger logger = LoggerFactory.getLogger(NettyServerTest.class);

    @Test
    public void test() {
        try {
            logger.info("启动netty服务端");
            new NettyServer().start(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
