package saereth.milk_of_magnesium.mixins.BorderlessFullscreen;

import com.mojang.blaze3d.platform.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Window.class)
public interface MainWindowAccessor
{
    @Accessor("dirty")
    public void setDirty(boolean value);
}