package com.devil.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 *@authur fengzhenghua 2017年10月29日 下午11:55:23
 *@ClassName ClientHandler
 *@Describtion
 */
public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.write(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));  
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext arg0, ByteBuf in) throws Exception {
		System.out.println("Client received: " + ByteBufUtil.hexDump(in.readBytes(in.readableBytes()))); 
		
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		 cause.printStackTrace();  
	        ctx.close();  
	}

}
