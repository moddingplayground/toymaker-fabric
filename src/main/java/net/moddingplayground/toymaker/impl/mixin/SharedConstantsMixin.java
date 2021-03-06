package net.moddingplayground.toymaker.impl.mixin;

import com.mojang.bridge.game.GameVersion;
import net.minecraft.MinecraftVersion;
import net.minecraft.SharedConstants;
import net.moddingplayground.toymaker.Toymaker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SharedConstants.class)
public class SharedConstantsMixin {
    @Inject(method = "getGameVersion", at = @At("HEAD"), cancellable = true)
    private static void fixNullGameVersion(CallbackInfoReturnable<GameVersion> cir) {
        if (Boolean.parseBoolean(System.getProperty(Toymaker.MOD_ID + ".datagen"))) {
            cir.setReturnValue(MinecraftVersion.CURRENT);
        }
    }
}
