package org.marthinwurer.germination;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

import java.util.EnumSet;
import java.util.Set;

public class SaplingDespawnListener implements Listener {
    private static final Set<Material> allSaplings = EnumSet.of(
            Material.ACACIA_SAPLING,
            Material.BIRCH_SAPLING,
            Material.DARK_OAK_SAPLING,
            Material.JUNGLE_SAPLING,
            Material.OAK_SAPLING,
            Material.SPRUCE_SAPLING
    );

    @EventHandler
    public void onItemDespawn(ItemDespawnEvent event) {
        Material material = event.getEntity().getItemStack().getType();
        // only do the other stuff if it's a sapling
        if (allSaplings.contains(material)) {
            Location location = event.getLocation();

            Block block = location.getBlock();

            // make sure that the block is free
            if (block.getType() != Material.AIR) {
                Bukkit.getLogger().info("Block is " + block.getType());
                return;
            }

            // make sure that there are growable blocks underneath it
            Block underneath = block.getRelative(BlockFace.DOWN);
            if (underneath.getType() == Material.DIRT || underneath.getType() == Material.GRASS_BLOCK) {
                Bukkit.getLogger().info("Placing sapling!");
                block.setType(material);
                block.getState().update();
            }
            else{
                Bukkit.getLogger().info("underneath is " + underneath.getType());
            }
        }
    }
}
