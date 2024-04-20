package org.eu.pcraft.event;

import org.bukkit.event.HandlerList;
import org.eu.pcraft.template.MessageRecvClass;
import org.eu.pcraft.template.MessageRecvClass.CurrentPacketDTO;
import org.jetbrains.annotations.NotNull;

import org.eu.pcraft.template.MessageRecvClass.CurrentPacketDTO.*;

public class AsyncQQMessageEvent extends AsyncQQCallEvent {
    private static final HandlerList handlers = new HandlerList();
    public AsyncQQMessageEvent(EventDataDTO eventData) {
        super(eventData);
    }
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}