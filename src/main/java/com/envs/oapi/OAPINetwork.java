package com.envs.oapi;

import com.envs.middle.Environment;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class OAPINetwork {
    private Socket socket;
    private SSLContext sslContext;
    private PrintWriter out;
    private BufferedReader in;

    private Environment e;


    public OAPINetwork(Environment e) {
        this.e = e;
        try {
            openConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getMessage() {
        String s = null;
        try {
            Thread.sleep(80);
            s = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("get message: " + s);
        return s;
    }

    public void sendMessage(String s) {
        System.out.println("send message: " + s);
        out.println(s);
    }

    private void openConnection() throws Exception {
        sslContext = SSLContext.getDefault();
        InetSocketAddress socketAddress = new InetSocketAddress(e.getOapiAddress(), e.getPort());
        SSLSocketFactory sslFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslFactory.createSocket(socketAddress.getAddress(), e.getPort());
        sslSocket.setUseClientMode(true);

        socket = sslSocket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
}
