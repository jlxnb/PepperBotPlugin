package org.eu.pcraft.util;

import com.google.gson.Gson;
import okhttp3.*;
import org.eu.pcraft.template.MessageSendClass;

import java.io.IOException;
import java.util.ArrayList;

import static org.eu.pcraft.PepperBotPlugin.instance;

public class QQSendUtil {
    static MediaType mediaType = MediaType.parse("application/json");
    static OkHttpClient client=new OkHttpClient();
    public enum msgType{
        Null,Private,Group,PrivateVoice
    }
    public static void sendQQMessage(String msg, Long QQGroupCode,msgType type) throws IOException {
        MessageSendClass message = new MessageSendClass();
        message.cgiRequest.content = msg;
        message.cgiRequest.toUin = QQGroupCode;
        message.cgiRequest.toType= type.ordinal();
        Gson json=new Gson();
        //System.out.println(json.toJson(message));
        RequestBody body = RequestBody.create(json.toJson(message), mediaType);
        Request messageRequest = new Request.Builder()
                .url(String.format("http://%s/v1/LuaApiCaller?funcname=MagicCgiCmd&timeout=10&qq=%d", instance.config.address, instance.config.QQCode))
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(messageRequest).execute();
    }
    public static void sendQQMessage(MessageSendClass message, Long QQGroupCode, msgType type) throws IOException {
        message.cgiRequest.toUin = QQGroupCode;
        message.cgiRequest.toType= type.ordinal();
        Gson json=new Gson();
        //System.out.println(json.toJson(message));
        RequestBody body = RequestBody.create(json.toJson(message), mediaType);
        Request messageRequest = new Request.Builder()
                .url(String.format("http://%s/v1/LuaApiCaller?funcname=MagicCgiCmd&timeout=10&qq=%d", instance.config.address, instance.config.QQCode))
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(messageRequest).execute();
        response.close();
    }
}
