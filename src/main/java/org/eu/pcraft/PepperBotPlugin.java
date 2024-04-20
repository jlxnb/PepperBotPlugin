package org.eu.pcraft;

import me.clip.placeholderapi.PlaceholderAPIPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.eu.pcraft.listener.BotListener;

import java.util.List;

public final class PepperBotPlugin extends JavaPlugin {
    public static PepperBotPlugin instance;
    public PepperConfig config=new PepperConfig();
    BukkitTask botTask;
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        instance=this;
        Bukkit.getLogger().info("Welcome to use PepperBot!");
        Bukkit.getLogger().info("Reading config,please wait...");
        config.getConfig();
        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            Bukkit.getLogger().info("PlaceholderAPI 已连接!");
            config.isPAPILoaded=true;
        }
        else{
            Bukkit.getLogger().info("未找到PlaceholderAPI,关闭PAPI功能!");
            config.isPAPILoaded=false;
        }
        Bukkit.getServer().getPluginManager().registerEvents(new BotListener(), instance);
        botTask = new BotTask().runTaskAsynchronously(this);
        Bukkit.getLogger().info("Done!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
