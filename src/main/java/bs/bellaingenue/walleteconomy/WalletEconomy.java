package bs.bellaingenue.walleteconomy;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public final class WalletEconomy extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Wallet Economy has started up!");

        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public @NotNull Logger getSLF4JLogger() {
        return super.getSLF4JLogger();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        System.out.println("Welcome back to Console!! Economy Added");
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.AQUA+ "Welcome back to BlueSkies, "+ ChatColor.YELLOW+ "Wallet Economy is set up!");
    }

    @Override

    public boolean onCommand(CommandSender sender, Command command, @NotNull String label, String[] args){
        // We want to make the /wallet command to print Points and Money
        if (command.getName().equalsIgnoreCase("wallet")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                player.sendMessage("Testing!");
            }
        }
        return false;


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Wallet Economy has shut down. Bye!");
    }
}
