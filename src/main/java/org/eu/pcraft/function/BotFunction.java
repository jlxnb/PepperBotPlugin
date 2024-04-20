package org.eu.pcraft.function;

import org.bukkit.Bukkit;
import org.eu.pcraft.util.QQSendUtil;
import org.eu.pcraft.util.StringUtil;

import java.io.IOException;
import java.util.Map;

import static org.eu.pcraft.PepperBotPlugin.instance;

public class BotFunction {
    public static void runCommand(Long senderUin,String command) throws IOException {
        if (senderUin != instance.config.adminQQCode) {
            QQSendUtil.sendQQMessage("你TM没权限!",instance.config.groupCode, QQSendUtil.msgType.Group);
            return;
        }
        Bukkit.getScheduler().runTask(instance, () -> {
            Bukkit.getServer().dispatchCommand(
                    Bukkit.getServer().getConsoleSender(),
                    command);
        });
        QQSendUtil.sendQQMessage("执行成功!",instance.config.groupCode, QQSendUtil.msgType.Group);
    }
    public static void keywordReply(Long groupCode,String message) throws IOException {
        for(Map.Entry<String,String> entry:instance.config.replyMap.entrySet()){
            if(message.contains(entry.getKey())){
                QQSendUtil.sendQQMessage(entry.getValue(),groupCode, QQSendUtil.msgType.Group);
            }
        }
    }
    public static void game2qq(Long groupCode,String message) throws IOException {
        QQSendUtil.sendQQMessage(message,groupCode,QQSendUtil.msgType.Group);
    }
    public static void qq2game(String message){
        Bukkit.broadcastMessage(message);
    }
}
