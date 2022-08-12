package saereth.milk_of_magnesium.mixins.EntityDistance;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import saereth.milk_of_magnesium.util.DistanceUtility;
import saereth.milk_of_magnesium.config.MagnesiumExtrasConfig;

@Mixin(EntityRenderDispatcher.class)
public class MaxDistanceEntity
{
    @Inject(at = @At("HEAD"), method = "shouldRender", cancellable = true)
    public <E extends Entity> void shouldDoRender(E entity, Frustum clippingHelper, double cameraX, double cameraY, double cameraZ, CallbackInfoReturnable<Boolean> cir)
    {
        if (!MagnesiumExtrasConfig.enableDistanceChecks.get())
            return;

        if (!DistanceUtility.isEntityWithinDistance(
                entity,
                cameraX,
                cameraY,
                cameraZ,
                MagnesiumExtrasConfig.maxEntityRenderDistanceY.get(),
                MagnesiumExtrasConfig.maxEntityRenderDistanceSquare.get()
        ))
        {
            cir.cancel();
        }
    }
}

