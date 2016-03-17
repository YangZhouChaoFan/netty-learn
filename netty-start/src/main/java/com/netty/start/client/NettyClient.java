package com.netty.start.client;

import com.netty.start.server.ChildChannelHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 客户端类.
 */
public class NettyClient {

    public void connect(String host, int port) throws Exception {

        //创建事件循环组
        EventLoopGroup group = new NioEventLoopGroup();

        try {

            //创建引导程序
            Bootstrap b = new Bootstrap();
            //设置消息循环
            b.group(group);
            //设置通道
            b.channel(NioSocketChannel.class);
            //配置通道参数：tcp不延迟
            b.option(ChannelOption.TCP_NODELAY, true);
            //设置通道处理
            b.handler(new ChannelHandler());
            //发起异步链接，等待输入参数
            Channel channel = b.connect(host, port).sync().channel();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                channel.writeAndFlush(in.readLine() + "\r\n");
            }

        } finally {
            //关闭
            group.shutdownGracefully();
        }

    }

}
