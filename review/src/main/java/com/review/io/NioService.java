package com.review.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class NioService {

    public static ExecutorService service = Executors.newFixedThreadPool(3);


    public static void main (String[] args) throws Exception {

        //创建一个selector
        Selector selector = Selector.open();
        //创建一个channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(9200));
        //非阻塞
        channel.configureBlocking(false);
        //将channel注册到selector上
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //select()可以被中断
            int selectCount = selector.select();
            if (selectCount == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    //链接进来了
                    SocketChannel sc = channel.accept();
                    //注册到selector
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    //数据已经发过来了
                    service.execute(new SocketProcess(key));
                    key.cancel();
                } else if (key.isWritable()) {
                    //可以发送了
                }
                //处理完，一定需要移除
                iterator.remove();
            }
        }
    }

    private static Charset charset = Charset.forName("UTF-8");

    private static CharsetDecoder decoder = charset.newDecoder();

    static class SocketProcess implements Runnable {

        SelectionKey key;

        public SocketProcess (SelectionKey key) {
            this.key = key;
        }

        @Override
        public void run () {
            SocketChannel channel = (SocketChannel) key.channel();
            //读数据
            //1.创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                //读取
                while (channel.read(buffer) > 0) {
                    channel.read(buffer);
                    //将buffer转为读模式
                    buffer.flip();
                    System.out.println(decoder.decode(buffer).toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //关闭
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
