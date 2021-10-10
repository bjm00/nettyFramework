package com.netty.simpleSocket;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("客户端启动成功！");
                while (true){
                    try {
                        String message = "hello world";
                        System.out.println("客户端发送数据"+message);
                        socket.getOutputStream().write(message.getBytes());
                    } catch (IOException e) {
                        System.out.println("写数据出错！");
                    }
                    sleep();
                }


            }
        }).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
