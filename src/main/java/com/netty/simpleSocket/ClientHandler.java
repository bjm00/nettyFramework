package com.netty.simpleSocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler {
    private final Socket socket;

    public ClientHandler(Socket client) {
        this.socket = client;
    }

    public void start() {
        System.out.println("新客户端接入");
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                byte[] data = new byte[128];
                int len;

                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来信息" + message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
