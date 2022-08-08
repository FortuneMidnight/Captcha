package de.fortunemidnight.captcha.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.fortunemidnight.captcha.Captcha;
import net.luency.capricorn.client.component.Component;
import net.luency.capricorn.client.component.Label;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Label("captchatest")
@Component
public class CaptchaTestCommand implements CommandExecutor {
  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    Player player = (Player) sender;
    ByteArrayDataOutput out = ByteStreams.newDataOutput();
    out.writeUTF("Connect");
    out.writeUTF("hub");
    player.sendPluginMessage(Captcha.getInstance(), "BungeeCord", out.toByteArray());
    return true;
  }
}
