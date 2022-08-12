package saereth.milk_of_magnesium.features.FrameCounter;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "milk_of_magnesium", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class DebugOverlayImprovements
{
    @SubscribeEvent
    public static void onRenderDebugText(RenderGameOverlayEvent.Pre event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.DEBUG)
            return;

        // cancel rendering text if chart is displaying
        var minecraft = Minecraft.getInstance();
        if (minecraft.options.renderFpsChart)
            event.setCanceled(true);

    }
}
