package org.eu.pcraft.listener;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import me.arasple.mc.trchat.api.event.TrChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.eu.pcraft.event.*;
import org.eu.pcraft.template.MessageRecvClass;
import org.eu.pcraft.template.MessageSendClass;
import org.eu.pcraft.util.QQSendUtil;
import org.eu.pcraft.util.StringUtil;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.eu.pcraft.PepperBotPlugin.instance;
import static org.eu.pcraft.function.BotFunction.*;

public class BotListener implements Listener {
    @EventHandler
    public void onQQCall(AsyncQQCallEvent event){
        if(event.getMessageHead().fromUin!=instance.config.groupCode){//判断群聊是否启用
            return;
        }
        if(event.getMessageHead().senderUin==instance.config.QQCode){//判断是否是机器人自己的消息
            return;
        }
        switch (event.getMessageHead().msgType){
            case 732:
                Bukkit.getPluginManager().callEvent(new AsyncQQRecallCallEvent(event.getData()));
                break;
            case 82:
                Bukkit.getPluginManager().callEvent(new AsyncQQMessageEvent(event.getData()));
                break;
            case 33:
                Bukkit.getPluginManager().callEvent(new AsyncGroupJoinEvent(event.getData()));
                break;
            default:
                Bukkit.getPluginManager().callEvent(new AsyncQQOtherMessagesEvent(event.getData()));
        }
    }

    @EventHandler
    public void onQQMessage(AsyncQQMessageEvent event) throws IOException {
        if (event.getMessageBody().content.indexOf("sudo") == 0) {//命令执行
            runCommand(event.getMessageHead().senderUin,event.getMessageBody().content.substring(4));
            return;
        }

        //关键词回复
        keywordReply(instance.config.groupCode, event.getMessageBody().content);

        //消息转发
        String message = StringUtil.replaceString(instance.config.pattern.qq2game,false,null)
                .replace("{name}",event.getMessageHead().senderNick)
                .replace("{message}", event.getMessageBody().content)
                .replace("{group}",event.getMessageHead().groupInfo.groupName);
        qq2game(message);
        //qq2game(event.getMessageHead().senderNick+":"+event.getMessageBody().content);
    }

    @EventHandler
    public void onChat(TrChatEvent event) throws IOException {
        if(!event.getChannel().getId().equals(instance.config.enabledChannel)){
            return;
        }
        String message=StringUtil.replaceString(instance.config.pattern.game2qq,true,event.getPlayer().getUniqueId())
                .replace("{name}", event.getPlayer().getName())
                .replace("{message}", event.getMessage())
                .replace("{server}",instance.config.serverName);
        //System.out.println(event.getChannel().getId());
        game2qq(instance.config.groupCode,message);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws IOException {
        String message=StringUtil.replaceString(instance.config.pattern.playerJoin,true,event.getPlayer().getUniqueId())
                .replace("{name}", event.getPlayer().getName());
        QQSendUtil.sendQQMessage(message,instance.config.groupCode,QQSendUtil.msgType.Group);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) throws IOException {
        String message=StringUtil.replaceString(instance.config.pattern.playerLeave,true,event.getPlayer().getUniqueId())
                .replace("{name}", event.getPlayer().getName());
        QQSendUtil.sendQQMessage(message,instance.config.groupCode,QQSendUtil.msgType.Group);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) throws IOException{
        String message=StringUtil.replaceString(instance.config.pattern.playerDeath, true, event.getEntity().getUniqueId())
                .replace("{name}", event.getEntity().getName())
                .replace("{message}", event.getDeathMessage());
        QQSendUtil.sendQQMessage(message, instance.config.groupCode, QQSendUtil.msgType.Group);
    }

    @EventHandler
    public void onGroupJoin(AsyncGroupJoinEvent event) throws IOException {
        System.out.println(event.getData());
        MessageSendClass message=new MessageSendClass();
        message.cgiRequest.atUinLists.add(
                new MessageSendClass.CgiRequestDTO.AtUinListsDTO(
                                event.getMessageHead().senderUin,
                                event.getMessageHead().senderNick));
        message.cgiRequest.content=StringUtil
                .replaceString(instance.config.pattern.welcome, false, null)
                .replace("{name}", '@'+event.getMessageHead().senderNick);
        QQSendUtil.sendQQMessage(message, instance.config.groupCode, QQSendUtil.msgType.Group);
    }
}
