package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by logan on 2017/4/5.
 */
public class Client {
    public static void main(String[] args) throws Exception {

        String host = "127.0.0.1";
        int port = 8080;

        Socket socket = new Socket(host, port);

        while (true) {
            OutputStream out = socket.getOutputStream();
            BufferedWriter output = new BufferedWriter(new PrintWriter(out));
            Scanner scanner = new Scanner(System.in);
            output.write(scanner.nextLine());
            output.flush();
            System.out.println("发送成功");
        }
    }
}
