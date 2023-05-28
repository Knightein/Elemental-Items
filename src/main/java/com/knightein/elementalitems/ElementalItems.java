package com.knightein.elementalitems;

import cloud.commandframework.annotations.AnnotationParser;
import cloud.commandframework.execution.AsynchronousCommandExecutionCoordinator;
import cloud.commandframework.meta.SimpleCommandMeta;
import cloud.commandframework.paper.PaperCommandManager;
import com.knightein.elementalitems.command.GetElementalBows;
import com.knightein.elementalitems.gameplay.ElementalBow;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Function;

public final class ElementalItems extends JavaPlugin {
    private static ElementalItems instance;

    public static ElementalItems getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        try {
            PaperCommandManager<CommandSender> commandManager = new PaperCommandManager<>(
                    this,
                    AsynchronousCommandExecutionCoordinator.<CommandSender>builder().build(),
                    Function.identity(),
                    Function.identity()
            );

            AnnotationParser<CommandSender> parser = new AnnotationParser<>(
                    commandManager,
                    CommandSender.class,
                    p -> SimpleCommandMeta.empty()
            );

            // All new commands go down here
            parser.parse(new GetElementalBows());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        getServer().getPluginManager().registerEvents(new ElementalBow.Events(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
