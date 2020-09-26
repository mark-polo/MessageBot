package com.message.bot.channel;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendMes {
    public static void mes(String mes) throws IOException{

        String chatId = null;
        String mess = null;

        Pattern p = Pattern.compile("(@)\\w+");
        Matcher m = p.matcher(mes);
        if(m.find()) {
            chatId = m.group();
        }
        Pattern pattern = Pattern.compile("( )\\w+");
        Matcher matcher = pattern.matcher(mes);
        if(matcher.find()) {
            mess = matcher.group();
        }

        String apiToken = "1053123977:AAEl8nvmajSc2Of7MjWBty16xdqwqy2bMTk";
        assert mess != null;
        URL url = new URL("https://api.telegram.org/bot"+ apiToken +"/sendMessage?chat_id=" + chatId +"&text=" + mess.trim());
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