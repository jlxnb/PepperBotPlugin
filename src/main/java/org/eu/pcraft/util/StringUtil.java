package org.eu.pcraft.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.eu.pcraft.PepperBotPlugin.instance;

public class StringUtil {
    public static String toDBC(String val) {
        char[] chars = val.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\u3000') {
                chars[i] = ' ';
            } else if (chars[i] > '\uFF00' && chars[i] < '\uFF5F') {
                chars[i] = (char) (chars[i] - 65248);
            }
        }
        return new String(chars);
    }

    public static String replaceString(String s, boolean replacePAPI, UUID playerUUID) {
        if(replacePAPI&&instance.config.isPAPILoaded){
            s=PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayer(playerUUID).getPlayer(), s);
        }
        return s.replace('&', '§');
    }
}
