package com.multi7200.tam.model;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelDisk extends ModelBase
{

    ModelRenderer Disk1;
    ModelRenderer Disk2;
    ModelRenderer Disk3;
  
  public ModelDisk()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Disk1 = new ModelRenderer(this, 0, 0);
      Disk1.addBox(0F, 0F, 0F, 5, 1, 5);
      Disk1.setRotationPoint(0F, 0F, -1F);
      Disk1.setTextureSize(32, 32);
      Disk1.mirror = true;
      setRotation(Disk1, 0F, 0F, 0F);
      Disk2 = new ModelRenderer(this, 0, 0);
      Disk2.addBox(0F, 0F, 0F, 3, 1, 3);
      Disk2.setRotationPoint(1F, -1F, 0F);
      Disk2.setTextureSize(32, 32);
      Disk2.mirror = true;
      setRotation(Disk2, 0F, 0F, 0F);
      Disk3 = new ModelRenderer(this, 0, 0);
      Disk3.addBox(0F, 0F, 0F, 3, 1, 3);
      Disk3.setRotationPoint(1F, 1F, 0F);
      Disk3.setTextureSize(32, 32);
      Disk3.mirror = true;
      setRotation(Disk3, 0F, 0F, 0F);
  }
  
  public void render(net.minecraft.entity.Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Disk1.render(f5);
    Disk2.render(f5);
    Disk3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, net.minecraft.entity.Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
