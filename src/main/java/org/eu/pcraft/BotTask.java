package org.eu.pcraft;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.bukkit.scheduler.BukkitRunnable;
import org.eu.pcraft.listener.WebSocketListener;

import static org.eu.pcraft.PepperBotPlugin.instance;

public class BotTask extends BukkitRunnable {
    public void run() {
        Request request = new Request.Builder()
                .get().url("ws://"+instance.config.address+"/ws")
                .build();
        OkHttpClient client = new OkHttpClient();
        WebSocket webSocket = client.newWebSocket(request, new WebSocketListener());
    }
}