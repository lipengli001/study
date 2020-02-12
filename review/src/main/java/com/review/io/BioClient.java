package com.review.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 *
 */
public class BioClient implements Runnable {

    public static void main (String[] args) {
        BioClient client = new BioClient("localhost", 9200);
        client.run();
    }

    private String host;

    private int port;

    private Charset charset = Charset.forName("UTF-8");

    public BioClient (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run () {
        Socket socket = null;
        OutputStream out = null;
        try {
            socket = new Socket(host, port);
            out = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入：");
                String msg = scanner.nextLine();
                out.write(msg.getBytes(charset));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
