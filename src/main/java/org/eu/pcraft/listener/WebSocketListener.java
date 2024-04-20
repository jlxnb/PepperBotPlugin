package org.eu.pcraft.listener;

import com.google.gson.Gson;
import okhttp3.Response;
import okhttp3.WebSocket;
import org.bukkit.Bukkit;
import org.eu.pcraft.event.AsyncQQCallEvent;
import org.eu.pcraft.template.MessageRecvClass;

public class WebSocketListener extends okhttp3.WebSocketListener {
    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        // 链接成功捏
        Bukkit.getLogger().info("成功链接WS服务器！");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        Gson json=new Gson();
        MessageRecvClass message = json.fromJson(text, MessageRecvClass.class);
        Bukkit.getServer().getPluginManager().callEvent(new AsyncQQCallEvent(message.currentPacket.eventData));
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        // 处理连接关闭事件
        Bukkit.getLogger().info("链接结束！");
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        // 处理连接失败事件
        Bukkit.getLogger().info("WebSocket维持失败！");
        System.out.println(t);
        System.out.println(response);
    }
}
