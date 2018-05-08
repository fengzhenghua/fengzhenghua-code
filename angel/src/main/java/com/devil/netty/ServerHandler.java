package com.devil.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *@authur fengzhenghua 2017年10月28日 下午10:31:59
 *@ClassName ServerHandler
 *@Describtion
 */
/* Sharable表示此对象在channel间共享 
* handler类是我们的具体业务类 
* */  
public class ServerHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("server receive data:" + msg);
		ctx.write(msg);//写回数据
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);//flush掉所有写回的数据
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();//捕捉异常
		ctx.close();//出现异常时关闭channel
	}
	
	
}
