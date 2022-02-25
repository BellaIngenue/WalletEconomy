package bs.bellaingenue.walleteconomy;

import bs.bellaingenue.walleteconomy.commands.WalletCommand;
import net.milkbowl.vault.economy.Economy;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.data.type.Wall;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.security.Permission;
import java.sql.SQLOutput;

public final class WalletEconomy extends JavaPlugin implements Listener {

    private static Economy econ;
    private PlayerPointsAPI ppAPI;
    private Permission perms;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        if (!setupEconomy()) {
            System.out.println("Disabled Wallet Economy due to no Vault Dependency found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        System.out.println("Wallet Economy has started up!");
        getCommand("wallet").setExecutor(new WalletCommand());

        getServer().getPluginManager().registerEvents(this, this);
        if (Bukkit.getPluginManager().isPluginEnabled("PlayerPoints")) {
            this.ppAPI = PlayerPoints.getInstance().getAPI();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Wallet Economy has shut down. Bye!");
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);

        System.out.println(economyProvider);
        if (economyProvider != null) {
            econ = (Economy) economyProvider.getProvider();
        }
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        System.out.println("Welcome back to Console!! Economy Added");
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.AQUA + "Welcome back to BlueSkies, " + ChatColor.YELLOW + "Wallet Economy is set up!");
    }
}

