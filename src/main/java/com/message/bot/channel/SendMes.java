package com.message.bot.channel;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class SendMes {
    public static void mes(String mes) throws IOException{
        String apiToken = "1053123977:AAEl8nvmajSc2Of7MjWBty16xdqwqy2bMTk";
        String chatId = "@mychanelbo";
        URL url = new URL("https://api.telegram.org/bot"+ apiToken +"/sendMessage?chat_id=" + chatId +"&text=" + mes);
        URLConnection conn = url.openConnection();
        StringBuilder sb = new StringBuilder();
        InputStream is = new BufferedInputStream(conn.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }

    }
}