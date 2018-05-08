package com.devil.netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 *@authur fengzhenghua 2017年10月29日 下午11:48:41
 *@ClassName NettyClient
 *@Describtion
 */
public class NettyClient {
	
	private final String host;
	private final int port;
	public NettyClient(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	
	public void start() throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group);
			b.channel(NioSocketChannel.class);
			b.remoteAddress(new InetSocketAddress(host, port));
			b.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new ClientHandler());
				}
				
			});
			 ChannelFuture f = b.connect().sync();  
	         f.addListener(new ChannelFutureListener() {

				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					if(future.isSuccess()){  
                        System.out.println("client connected");  
                    }else{  
                        System.out.println("server attemp failed");  
                        future.cause().printStackTrace();  
                    }  
				}
	        	 
	         });
	         f.channel().closeFuture().sync();
		}catch (Exception e) {
		}finally {
			 group.shutdownGracefully().sync(); 
		}
	}
	public static void main(String[] args) throws InterruptedException {
		new NettyClient("127.0.0.1",8888).start();
	}
}
