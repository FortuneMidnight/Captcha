package de.fortunemidnight.captcha;

import de.fortunemidnight.captcha.commands.CaptchaTestCommand;
import net.luency.capricorn.client.CapricornClientPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class Captcha extends JavaPlugin {
  private static Captcha plugin;

  public static Captcha getInstance() {
    return plugin;
  }

  @Override
  public void onEnable() {
    plugin = this;
    CapricornClientPlugin.getInstance().injectPlugin(this, getClassLoader());
    this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
