package io.github.jason13official.musketmod;

import io.github.jason13official.musketmod.platform.Services;
import java.nio.file.Path;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MusketMod {

    public static final Logger LOG = LoggerFactory.getLogger(Constants.MOD_NAME);
  public static final Path CONFIG_PATH = Services.PLATFORM.getConfigDirectory().resolve("musketmod.txt");

  public static void init() {
  }

  public static ResourceLocation resource(String path) {
    return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
  }

  // TODO re-impl smoke effect
  public static void sendSmokeEffect(ServerLevel level, Vec3 origin, Vec3 direction) {
//    SmokeEffectPacket packet = SmokeEffectPacket.fromVec3(origin, direction);
//    BlockPos blockPos = BlockPos.containing(origin.x, origin.y, origin.z);
//    PacketDistributor.sendToPlayersTrackingChunk(level, new ChunkPos(blockPos), packet);
  }

  public static void disableVelocityUpdate(EntityType.Builder<?> builder) {
    // builder.alwaysUpdateVelocity(false);
  }
}