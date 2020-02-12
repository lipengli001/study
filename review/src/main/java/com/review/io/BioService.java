package com.review.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 *
 */
public class BioService {

    private static Charset charset = Charset.forName("UTF-8");

    public static void main (String[] args) {
        int port = 9200;
        ServerSocket ss = null;
        Socket s = null;
        BufferedReader reader = null;
        try {
            ss = new ServerSocket(port);
            while (true) {
                s = ss.accept();
                reader = new BufferedReader(new InputStreamReader(s.getInputStream(), charset));
                String msg = null;
                while ((msg = reader.readLine()) != null) {
                    System.out.println(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
