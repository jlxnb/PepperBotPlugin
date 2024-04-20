package org.eu.pcraft.event;

import org.bukkit.event.HandlerList;
import org.eu.pcraft.template.MessageRecvClass;
import org.eu.pcraft.template.MessageRecvClass.CurrentPacketDTO.EventDataDTO;
import org.jetbrains.annotations.NotNull;

public class AsyncQQOtherMessagesEvent extends AsyncQQCallEvent {
    private static final HandlerList handlers = new HandlerList();
    public AsyncQQOtherMessagesEvent(EventDataDTO eventData) {
        super(eventData);
    }

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
