package com.netty.start.client;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketAddress;

/**
 * 客户端处理类.
 */
public class NettyClientHandler extends ChannelHandlerAdapter {

    static private Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);

    /**
     * 连接通道.
     *
     * @param ctx
     * @param remoteAddress
     * @param localAddress
     * @param promise
     * @throws Exception
     */
    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        logger.info(remoteAddress + "：连接通道");
        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    /**
     * 活跃通道.
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info(ctx.channel().remoteAddress() + "：通道激活");
        super.channelActive(ctx);
    }

    /**
     * 非活跃通道.
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info(ctx.channel().remoteAddress() + "：通道失效");
        super.channelInactive(ctx);
    }

    /**
     * 接收消息.
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info(ctx.channel().remoteAddress() + "：" + msg);
    }

    /**
     * 接收完毕.
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    /**
     * 关闭通道.
     *
     * @param ctx
     * @param promise
     * @throws Exception
     */
    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        super.close(ctx, promise);
    }

    /**
     * 异常处理.
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("异常信息：" + cause.getMessage());
    }
}
