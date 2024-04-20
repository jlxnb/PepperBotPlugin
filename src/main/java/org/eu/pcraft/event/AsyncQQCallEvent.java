package org.eu.pcraft.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.eu.pcraft.template.MessageRecvClass;
import org.jetbrains.annotations.NotNull;

public class AsyncQQCallEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private MessageRecvClass.CurrentPacketDTO.EventDataDTO data;

    public AsyncQQCallEvent(MessageRecvClass.CurrentPacketDTO.EventDataDTO eventData) {
        super(true);
        data = eventData;
    }

    public MessageRecvClass.CurrentPacketDTO.EventDataDTO getData() {
        return data;
    }

    public MessageRecvClass.CurrentPacketDTO.EventDataDTO.MsgBodyDTO getMessageBody() {
        return data.msgBody;
    }

    public MessageRecvClass.CurrentPacketDTO.EventDataDTO.MsgHeadDTO getMessageHead() {
        return data.msgHead;
    }

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}