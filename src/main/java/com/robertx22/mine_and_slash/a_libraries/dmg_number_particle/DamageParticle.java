package com.robertx22.mine_and_slash.a_libraries.dmg_number_particle;

import com.robertx22.mine_and_slash.config.ClientContainer;
import com.robertx22.mine_and_slash.config.ModConfig;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(value = CLIENT)
public class DamageParticle extends Particle {

	protected static final float GRAVITY = 0.15F;
	protected static final float SIZE = 3.0F;
	protected static final int LIFESPAN = 12;
	protected static final double BOUNCE_STRENGTH = 1.3F;

	protected String text;
	protected boolean shouldOnTop = true;
	protected boolean grow = true;
	protected float scale = 0.7F;

	Elements element;

	public DamageParticle(Elements element, String str, World world, double parX, double parY, double parZ,
			double parMotionX, double parMotionY, double parMotionZ) {
		super(world, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
		particleTextureJitterX = 0.0F;
		particleTextureJitterY = 0.0F;
		particleGravity = GRAVITY;
		particleScale = SIZE;
		particleMaxAge = LIFESPAN;
		this.text = str;

		this.element = element;
	}

	protected DamageParticle(Elements element, World worldIn, double posXIn, double posYIn, double posZIn) {
		this(element, "", worldIn, posXIn, posYIn, posZIn, 0, 0, 0);
	}

	@Override
	public void renderParticle(final BufferBuilder renderer, final Entity entity, final float x, final float y,
			final float z, final float dX, final float dY, final float dZ) {
		float rotationYaw = (-Minecraft.getMinecraft().player.rotationYaw);
		float rotationPitch = Minecraft.getMinecraft().player.rotationPitch;

		final float locX = ((float) (this.prevPosX + (this.posX - this.prevPosX) * x - interpPosX));
		final float locY = ((float) (this.prevPosY + (this.posY - this.prevPosY) * y - interpPosY));
		final float locZ = ((float) (this.prevPosZ + (this.posZ - this.prevPosZ) * z - interpPosZ));

		GL11.glPushMatrix();
		if (this.shouldOnTop) {
			GL11.glDepthFunc(519);
		} else {
			GL11.glDepthFunc(515);
		}
		GL11.glTranslatef(locX, locY, locZ);
		GL11.glRotatef(rotationYaw, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(rotationPitch, 1.0F, 0.0F, 0.0F);

		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		GL11.glScaled(this.particleScale * 0.008D, this.particleScale * 0.008D, this.particleScale * 0.008D);
		GL11.glScaled(this.scale, this.scale, this.scale);

		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 0.003662109F);
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDepthMask(true);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDisable(2896);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(3042);
		GL11.glEnable(3008);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		int color = this.ChooseColor(element);

		final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		fontRenderer.drawStringWithShadow(this.text,
				-MathHelper.floor(fontRenderer.getStringWidth(this.text) / 2.0F) + 1,
				-MathHelper.floor(fontRenderer.FONT_HEIGHT / 2.0F) + 1, color);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDepthFunc(515);

		GL11.glPopMatrix();
		if (this.grow) {
			this.particleScale *= 1.08F;
			if (this.particleScale > SIZE * 3.0D) {
				this.grow = false;
			}
		} else {
			this.particleScale *= 0.96F;
		}
	}

	private int ChooseColor(Elements element) {

		if (element.equals(Elements.Water)) {
			return 296935;
		}
		if (element.equals(Elements.Fire)) {
			return 9777215;
		}
		if (element.equals(Elements.Thunder)) {
			return -100;
		}
		if (element.equals(Elements.Nature)) {
			return 444444;
		}
		return -1;
	}

	public int getFXLayer() {
		return 3;
	}

}