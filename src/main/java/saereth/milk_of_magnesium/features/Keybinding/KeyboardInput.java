package saereth.milk_of_magnesium.features.Keybinding;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import saereth.milk_of_magnesium.MagnesiumExtras;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class KeyboardInput
{
    public static final KeyMapping zoomKey = new KeyMapping(MagnesiumExtras.MODID + "key.zoom" ,
            KeyConflictContext.IN_GAME,
            KeyModifier.NONE,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_C,
            MagnesiumExtras.MODID + "key.category");

}
