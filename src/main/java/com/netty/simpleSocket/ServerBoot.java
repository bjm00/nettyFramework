package com.netty.simpleSocket;


public class ServerBoot {
    public static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}
