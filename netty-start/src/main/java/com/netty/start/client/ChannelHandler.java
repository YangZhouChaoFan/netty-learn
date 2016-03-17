package com.netty.start.client;

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
 * 通道处理类.
 */
public class ChannelHandler extends ChannelInitializer<SocketChannel> {

    static private Logger logger = LoggerFactory.getLogger(ChannelHandler.class);

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        logger.info("客户端链接到服务端");
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 以("\n")为结尾分割的 解码器
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(1024, Delimiters.lineDelimiter()));
        // 字符串解码 和 编码
        pipeline.addLast("decoder", new StringDecoder(Charset.forName("GBK")));
        pipeline.addLast("encoder", new StringEncoder(Charset.forName("UTF-8")));
        socketChannel.pipeline().addLast(new NettyClientHandler());

    }
}
