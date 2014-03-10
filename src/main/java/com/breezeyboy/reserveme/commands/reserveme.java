/**
 * 
 */
package com.breezeyboy.reserveme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author breezeyboy
 *
 */
public class reserveme implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("reserveme")){
			if(!(sender instanceof Player)){
				sender.sendMessage("This is a player command.");
			}
			if(sender instanceof Player){
				if(!(sender.hasPermission("reserveme.reserve"))){
					sender.sendMessage("You don't have permission.");
				}else{
					if(com.breezeyboy.reserveme.ReserveMe.instance.reserved.contains(sender.getName())){
						sender.sendMessage("You are already reserved.");
					}else{
						sender.sendMessage("You are now reserved.");
						com.breezeyboy.reserveme.ReserveMe.instance.reserved.add(sender.getName());
					}
				}
			}
		}
		return false;
	}
}
