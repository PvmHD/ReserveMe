/**
 * 
 */
package com.breezeyboy.reserveme.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.breezeyboy.reserveme.ReserveMe;

/**
 * @author breezeyboy
 *
 */
public class LoginListener implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerLogin(PlayerLoginEvent event){
		if(Bukkit.getServer().getOnlinePlayers().length + ReserveMe.instance.reserved.size() >= Bukkit.getServer().getMaxPlayers()){
			Player player = event.getPlayer();
			if(!(ReserveMe.instance.reserved.contains(player.getName()))){
				event.setKickMessage("That slot is reserved.");
				event.setResult(Result.KICK_WHITELIST);
			}else{
				player.sendMessage("You are no longer reserved.");
			    ReserveMe.instance.reserved.remove(player.getName());
			}
		}
	}
}
