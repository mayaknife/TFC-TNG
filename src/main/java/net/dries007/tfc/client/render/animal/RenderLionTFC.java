/*
 * Work under Copyright. Licensed under the EUPL.
 * See the project README.md and LICENSE.txt for more information.
 */

package net.dries007.tfc.client.render.animal;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.dries007.tfc.client.model.animal.ModelLionTFC;
import net.dries007.tfc.objects.entity.animal.EntityAnimalTFC;
import net.dries007.tfc.objects.entity.animal.EntityLionTFC;

import static net.dries007.tfc.TerraFirmaCraft.MOD_ID;

@SideOnly(Side.CLIENT)
@ParametersAreNonnullByDefault
public class RenderLionTFC extends RenderLiving<EntityLionTFC>
{
    private static final ResourceLocation LION_TEXTURE = new ResourceLocation(MOD_ID, "textures/entity/animal/lion.png");
    private static final ResourceLocation LIONESS_TEXTURE = new ResourceLocation(MOD_ID, "textures/entity/animal/lioness.png");

    public RenderLionTFC(RenderManager manager)
    {
        super(manager, new ModelLionTFC(), 0.3F);
    }

    @Override
    public void doRender(EntityLionTFC lion, double par2, double par4, double par6, float par8, float par9)
    {
        this.shadowSize = (float) (0.4f + lion.getPercentToAdulthood() * 0.4f);
        super.doRender(lion, par2, par4, par6, par8, par9);
    }


    protected ResourceLocation getEntityTexture(EntityLionTFC lion)
    {
        float percent = (float) lion.getPercentToAdulthood();

        if (lion.getGender() != EntityAnimalTFC.Gender.MALE || percent < .75f)
        {
            return LIONESS_TEXTURE;
        }
        else
        {
            return LION_TEXTURE;
        }
    }


}