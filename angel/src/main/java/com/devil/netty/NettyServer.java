package com.devil.netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 *@authur fengzhenghua 2017年10月28日 下午9:55:24
 *@ClassName NettyServer
 *@Describtion
 */
public class NettyServer {
	private int port ;
	
	public NettyServer(int port) {
		this.port = port;
	}
	
	public void start() {
		
		ServerBootstrap b = new ServerBootstrap();// 引导辅助程序  
		//事件循环组
		EventLoopGroup group = new NioEventLoopGroup();// 通过nio方式来接收连接和处理连接
		try {
			b.group(group);
			b.channel(NioServerSocketChannel.class);// 设置nio类型的channel
			b.localAddress(new InetSocketAddress( port));// 设置监听端口  
			b.childHandler(new ChannelInitializer<SocketChannel>() {//有连接到达时会创建一个channel

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast("my handler",new ServerHandler());
				}
			} );
			// 配置完成，开始绑定server，通过调用sync同步方法阻塞直到绑定成功 
			ChannelFuture f = b.bind().sync();
			System.out.println(NettyServer.class.getName() + " started and listen on " + f.channel().localAddress()); 
			f.channel().closeFuture().sync();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		
		new NettyServer(8888).start();
		
	}
}
