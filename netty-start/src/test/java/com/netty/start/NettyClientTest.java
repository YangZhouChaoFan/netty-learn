package com.netty.start;

import com.netty.start.client.NettyClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端测试类.
 */
public class NettyClientTest {

    static private Logger logger = LoggerFactory.getLogger(NettyClientTest.class);

    @Test
    public void test() {
        try {
            logger.info("启动netty客户端");
            new NettyClient().connect("127.0.0.1", 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
