package de.fortunemidnight.captcha.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.fortunemidnight.captcha.Captcha;
import net.luency.capricorn.client.component.Component;
import net.luency.capricorn.client.component.Label;
import net.luency.capricorn.client.inventory.ClickableInventory;
import net.luency.capricorn.client.inventory.InventoryFactory;
import net.luency.capricorn.client.util.ItemStackBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

//@Label("captcha")
//@Component
public class CaptchaCommand implements CommandExecutor {
  int valid = 0;

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
    Random random = new Random();
    Player player = (Player) sender;
    setZero();


    ClickableInventory inventory = InventoryFactory
      .getInstance("Captcha", 6, player);
    for (int i = 0; i < inventory.getSize(); i++) {
      inventory.setItem(i, ItemStackBuilder.create(Material.BLACK_STAINED_GLASS_PANE)
        .build(), ((inventoryClickEvent, itemStack) -> {
        sendPlayer(player);
      }));
    }
    int Check1 = (random.nextInt(inventory.getSize()));
    int Check2 = (random.nextInt(inventory.getSize()));
    int Check3 = (random.nextInt(inventory.getSize()));

    inventory.setItem(Check1, ItemStackBuilder.create(Material.CHEST_MINECART)
      .build(), ((inventoryClickEvent, itemStack) -> {
      inventory.setItem(Check1, ItemStackBuilder.create(Material.MINECART).build());
      Bukkit.broadcastMessage(String.valueOf(valid));
      addValid();
      if (valid >= 2) {
        player.closeInventory();
        valid = 0;
      }
    }));
    inventory.setItem(Check2, ItemStackBuilder.create(Material.CHEST_MINECART)
      .build(), ((inventoryClickEvent, itemStack) -> {
      inventory.setItem(Check2, ItemStackBuilder.create(Material.MINECART).build());
      Bukkit.broadcastMessage(String.valueOf(valid));
      addValid();
      if (valid >= 3) {
        player.closeInventory();
        valid = 0;
      }
    }));
    inventory.setItem(Check3, ItemStackBuilder.create(Material.CHEST_MINECART)
      .build(), ((inventoryClickEvent, itemStack) -> {
      inventory.setItem(Check3, ItemStackBuilder.create(Material.MINECART).build());
      Bukkit.broadcastMessage(String.valueOf(valid));
      addValid();
      if (valid >= 3) {
        player.closeInventory();
        valid = 0;
      }
    }));
    inventory.open();
    return true;
  }

  private void sendPlayer(Player player) {
    player.sendMessage("send");
    ByteArrayDataOutput out = ByteStreams.newDataOutput();
    out.writeUTF("Connect");
    out.writeUTF("hub");
    player.sendPluginMessage(Captcha.getInstance(), "BungeeCord", out.toByteArray());
  }

  private void addValid() {
    valid++;
  }

  private void setZero() {
    valid = 0;
  }
}
