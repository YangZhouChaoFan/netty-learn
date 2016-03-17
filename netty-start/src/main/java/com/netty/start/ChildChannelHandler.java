package com.netty.start;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * 客户端处理类
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel e) throws Exception {
        //打印客户端信息
        System.out.println("发现新客户端");
        System.out.println("IP:" + e.remoteAddress().getHostName());
        System.out.println("Port:" + e.remoteAddress().getPort());

    }

}