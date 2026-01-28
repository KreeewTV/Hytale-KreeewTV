package at.kreeewtv.hycore.listeners;


import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.player.pages.RespawnPage;
import com.hypixel.hytale.server.core.modules.entity.damage.DeathItemLoss;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

//https://github.com/KreeewTV/Hytale-KreeewTV

public class RespawnPageUIOverride extends RespawnPage {
    public RespawnPageUIOverride(PlayerRef playerRef, @Nullable Message deathReason, boolean displayDataOnDeathScreen, DeathItemLoss deathItemLoss) {
        super(playerRef, deathReason, displayDataOnDeathScreen, deathItemLoss);
    }

    public void build(@Nonnull Ref<EntityStore> ref, @Nonnull UICommandBuilder commandBuilder, @Nonnull UIEventBuilder eventBuilder, @Nonnull Store<EntityStore> store) {
    }
}