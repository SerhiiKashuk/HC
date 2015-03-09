package server;


import java.sql.SQLException;

import stat.DBConnection;
import io.netty.bootstrap.*;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Main server class. Contains server configuration and main method.
 * 
 * 
 * 
 */

public class Server {
  
	private static DBConnection connect= new DBConnection();
    /**
     * Port that server will use.
     */
    private final int port;

    public Server(int port) {
	this.port = port;
    }

    public void run() throws Exception {
	/*
	 * Start database
	 */
	DBConnection.getConnection();
	/*
	 * Configure server
	 */
	EventLoopGroup bossGroup = new NioEventLoopGroup();
	EventLoopGroup workerGroup = new NioEventLoopGroup();
	try {
	    ServerBootstrap b = new ServerBootstrap();
	    b.option(ChannelOption.SO_BACKLOG, 1024);
	     Channel ch =null;
	    // ch= b.bind(port).sync().channel();
	    ch.closeFuture().sync();
	    b.group(bossGroup, workerGroup)
		    .channel(NioServerSocketChannel.class)
		    .childHandler(new ServerInitializer());
	   
	} finally {
	    bossGroup.shutdown();
	    workerGroup.shutdown();
	}
	
    }

    public static void main(String[] args) throws Exception {
	int port;
	if (args.length > 0) {
	    port = Integer.parseInt(args[0]);
	} else {
	    port = 80;
	}
	/*
	 * Shut down database on server stop
	 */
	Runtime.getRuntime().addShutdownHook(new Thread() {
	    public void run() {
		 try {	       
		    DBConnection.shutdownDb();
		} catch (SQLException e) {
		}
	    }
	});
	new Server(port).run();
    }

    public static DBConnection getDao() {
	return dao;
    }

    public static void setConnect(DBConnection connect) {
	Server.connect = connect;
    }

}
