package bs.bellaingenue.walleteconomy.commands;

import bs.bellaingenue.walleteconomy.WalletEconomy;
import net.milkbowl.vault.economy.Economy;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.sql.SQLOutput;


public class WalletCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        // We want to make the /wallet command to print Points and Money
        if (sender instanceof Player){

            Player player = (Player) sender;
            Economy economy = WalletEconomy.getEconomy();
            if (command.getName().equalsIgnoreCase("wallet")){

                if(player.hasPermission("bs.wallet")) {
                    player.sendMessage(ChatColor.GREEN + "Your Current Balance is: "+ economy.format(economy.getBalance(player)));
                }
                else{
                    player.sendMessage(ChatColor.YELLOW + "You need the right permissions to execute this command!");
                }
            }

            else{
                System.out.println("You need to be a player to execute this command!");
            }
        }

        return true;


    }
}
