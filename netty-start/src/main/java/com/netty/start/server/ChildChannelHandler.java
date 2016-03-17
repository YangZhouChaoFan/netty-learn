package com.netty.start.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * 客户端通道处理类.
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    static private Logger logger = LoggerFactory.getLogger(ChildChannelHandler.class);

    @Override
    protected void initChannel(SocketChannel e) throws Exception {

        logger.info(e.remoteAddress() + "：进入通道");
        ChannelPipeline pipeline = e.pipeline();
        // 以("\n")为结尾分割的 解码器
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(1024, Delimiters.lineDelimiter()));
        // 字符串解码 和 编码
        pipeline.addLast("decoder", new StringDecoder(Charset.forName("GBK")));
        pipeline.addLast("encoder", new StringEncoder(Charset.forName("UTF-8")));
        //添加消息处理
        e.pipeline().addLast(new NettyServerHandler());

    }

}