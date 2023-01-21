package me.bryang.recoverhealth.modules;

import me.bryang.recoverhealth.RecoverHealth;
import me.bryang.recoverhealth.actions.Action;
import me.bryang.recoverhealth.commands.RecoverHealthCommand;
import me.bryang.recoverhealth.listeners.DamageListener;
import team.unnamed.inject.AbstractModule;
import team.unnamed.inject.key.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class MainModule extends AbstractModule {

    private final RecoverHealth recoverHealth;

    public MainModule(RecoverHealth recoverHealth) {
        this.recoverHealth = recoverHealth;
    }

    @Override
    public void configure() {
        bind(RecoverHealth.class)
                .toInstance(recoverHealth);

        install(new FileModule(recoverHealth));
        install(new ServiceModule());
        bind(new TypeReference<List<Action>>(){})
                .toInstance(new ArrayList<>());

        bind(RecoverHealthCommand.class)
                .singleton();
        bind(DamageListener.class)
                .singleton();
    }
}
