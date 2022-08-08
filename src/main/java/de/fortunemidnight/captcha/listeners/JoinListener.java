package de.fortunemidnight.captcha.listeners;

import de.fortunemidnight.captcha.commands.CaptchaCommand;
import net.luency.capricorn.client.component.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@Component
public class JoinListener implements Listener {
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
  }
}
