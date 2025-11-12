package io.github.jason13official.musketmod.impl.common;

import io.github.jason13official.musketmod.MusketMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public record SmokeEffectPacket(Vector3f origin, Vector3f direction) implements CustomPacketPayload {
    public static final Type<SmokeEffectPacket> TYPE =
        new Type<>(MusketMod.resource("smoke"));
    public static final StreamCodec<ByteBuf, SmokeEffectPacket> CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VECTOR3F, SmokeEffectPacket::origin,
            ByteBufCodecs.VECTOR3F, SmokeEffectPacket::direction,
            SmokeEffectPacket::new
        );

    public static SmokeEffectPacket fromVec3(Vec3 origin, Vec3 direction) {
        return new SmokeEffectPacket(
            new Vector3f((float)origin.x, (float)origin.y, (float)origin.z),
            new Vector3f((float)direction.x, (float)direction.y, (float)direction.z)
        );
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
