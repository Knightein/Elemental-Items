package com.knightein.elementalitems.command;

import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandDescription;
import cloud.commandframework.annotations.CommandMethod;
import com.knightein.elementalitems.gameplay.ElementalBow;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetElementalBows {
    public enum BowType {
        LAVA,
        LIGHTNING,
        ICE,
        WIND,
        ENDER,
        CREEPER,
        WOLF,
        NECROMANCER
    }

    @CommandDescription("Get the Elemental Bows")
    @CommandMethod("getelementalbow <elemental-bow>")
    private void giveElementalBow(CommandSender sender, @Argument("elemental-bow") BowType input) {
        ElementalBow bow = new ElementalBow();
        Player player = (Player) sender;
        bow.createBows(player, input);
    }
}
