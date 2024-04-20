package org.eu.pcraft;


import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.eu.pcraft.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

import static org.eu.pcraft.PepperBotPlugin.instance;

public class PepperConfig {
    void
    getConfig(){
        FileConfiguration configuration=instance.getConfig();
        address=configuration.getString("Address");
        QQCode=configuration.getLong("QQCode");
        groupCode=configuration.getLong("GroupCode");
        adminQQCode=configuration.getLong("AdminQQCode");
        enabledChannel=configuration.getString("EnabledChannel");
        serverName=configuration.getString("ServerName");
        ConfigurationSection subConf = configuration.getConfigurationSection("KeywordReply");
        for(String s:subConf.getKeys(true)){
            replyMap.put(StringUtil.toDBC(s),subConf.getString(s));
        }
        subConf = configuration.getConfigurationSection("Pattern");
        assert subConf != null;
        pattern.qq2game=subConf.getString("QQ2Game");
        pattern.game2qq=subConf.getString("Game2QQ");
        pattern.welcome=subConf.getString("Welcome");
        pattern.playerJoin=subConf.getString("PlayerJoin");
        pattern.playerLeave=subConf.getString("PlayerLeave");
        pattern.playerDeath=subConf.getString("PlayerDeath");

    }
    public boolean isPAPILoaded;
    public Map<String,String> replyMap=new HashMap<>();
    public String address;
    public long QQCode;
    public long groupCode;
    public long adminQQCode;
    public String serverName;
    public String enabledChannel;
    public class PatternDTO{
        public String qq2game;
        public String game2qq;
        public String welcome;
        public String playerJoin;
        public String playerLeave;
        public String playerDeath;
    }
    public PatternDTO pattern=new PatternDTO();
}
