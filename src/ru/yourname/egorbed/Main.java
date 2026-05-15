package ru.yourname.egorbed;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Регистрация команды при запуске
        if (this.getCommand("Egor") != null) {
            this.getCommand("Egor").setExecutor(this);
        }
        getLogger().info("Плагин EgorBed успешно включен!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Проверяем, что команду ввел игрок, а не консоль
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cЭта команда доступна только игрокам!");
            return true;
        }

        Player player = (Player) sender;

        // Создаем фиолетовую кровать (в API называется PURPLE_BED)
        ItemStack purpleBed = new ItemStack(Material.PURPLE_BED, 1);

        // Добавляем в инвентарь игрока
        player.getInventory().addItem(purpleBed);
        player.sendMessage("§dВы получили Фиолетовую кровать!");

        return true;
    }
}
