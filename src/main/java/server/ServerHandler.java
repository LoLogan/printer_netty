package server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import pojo.UnixTime;

import java.util.Date;

/**
 * Created by logan on 2017/4/5.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public void channelActive(final ChannelHandlerContext ctx) {
        System.out.println("channel active");
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


    public void channelRead(ChannelHandlerContext ctx, Object s) throws Exception {
        System.out.println(s);
        ChannelFuture f = ctx.write(Unpooled.copiedBuffer("Logan", CharsetUtil.UTF_8));
        ctx.flush();
        ChannelFuture f2 = ctx.write(Unpooled.copiedBuffer("Hello", CharsetUtil.UTF_8));
        ctx.flush();
        System.out.println("channel read");
    }
}
