/**
 * 
 */
package com.breezeyboy.reserveme;

import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.breezeyboy.reserveme.listeners.LoginListener;

/**
 * @author breezeyboy
 *
 */
public class ReserveMe extends JavaPlugin{
	public Logger log = Bukkit.getServer().getLogger();
	public PluginManager pm = Bukkit.getServer().getPluginManager();
	public static ReserveMe instance;
	public HashSet<String> reserved = new HashSet<String>();
	
	@Override
	public void onEnable(){
		this.registerEvents();
	}
	
	@Override
	public void onDisable(){
		reserved.clear();
	}
	
	public void registerEvents(){
		ReserveMe.instance = this;
		this.getCommand("reserveme").setExecutor(new com.breezeyboy.reserveme.commands.reserveme());
		pm.registerEvents(new LoginListener(), this);
	}
}

