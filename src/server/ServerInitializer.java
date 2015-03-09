package server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;


public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
	ChannelPipeline p = ch.pipeline();
	p.addLast("codec", new HttpServerCodec());
	p.addLast("traffic", new HChannelTrafficShapingHandler(
		AbstractTrafficShapingHandler.DEFAULT_CHECK_INTERVAL));
	p.addLast("handler", new ServerHandler());
    }

}