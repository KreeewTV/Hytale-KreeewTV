package at.kreeewtv.hycore.listeners;

import at.kreeewtv.hycore.api.ColorUtil;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.protocol.packets.interface_.Page;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.entities.player.pages.PageManager;
import com.hypixel.hytale.server.core.modules.entity.damage.Damage;
import com.hypixel.hytale.server.core.modules.entity.damage.DeathComponent;
import com.hypixel.hytale.server.core.modules.entity.damage.DeathSystems;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nonnull;

public class InstantRespawn extends DeathSystems.OnDeathSystem {

    //https://github.com/KreeewTV/Hytale-KreeewTV

    //Register in MAIN
    //this.getEntityStoreRegistry().registerSystem(new InstantRespawn());


    @Override
    public void onComponentAdded(@Nonnull Ref ref, @Nonnull DeathComponent component, @Nonnull Store store, @Nonnull CommandBuffer commandBuffer) {
        
        PlayerRef playerRefComponent = (PlayerRef) commandBuffer.getComponent(ref, PlayerRef.getComponentType());
        
        Universe.get().sendMessage(ColorUtil.parse("§7Death player: §c" + playerRefComponent.getUsername()));

        Player playerComponent = (Player) store.getComponent(ref, Player.getComponentType());

        Damage deathInfo = component.getDeathInfo();
        Message deathMessage = deathInfo != null ? deathInfo.getDeathMessage(ref, commandBuffer) : null;

        PageManager pageManager = playerComponent.getPageManager();
        pageManager.openCustomPage(ref, store, new RespawnPageUIOverride(playerRefComponent, deathMessage, component.displayDataOnDeathScreen(), component.getDeathItemLoss()));
        component.setShowDeathMenu(false);
        World world = playerComponent.getWorld();

        if (world == null ) return;

        playerComponent.getWorld().execute(() -> {
                playerComponent.getPageManager().setPage(ref, store, Page.None);

                //teleport is in the background of RespawnPageUIOverride/RespawnPage
                // -> DeathComponent.respawn(store, ref);
            });



/**
        boolean isDead = store.getArchetype(ref).contains(DeathComponent.getComponentType());
        if (isDead) {
            assert playerComponent != null;
            DeathComponent.respawn(store, ref);
        }
*/










    }


    @NullableDecl
    @Override
    public Query<EntityStore> getQuery() {
        return Query.any();
    }



}
