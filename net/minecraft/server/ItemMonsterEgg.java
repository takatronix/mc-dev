package net.minecraft.server;

public class ItemMonsterEgg extends Item {

    public ItemMonsterEgg(int i) {
        super(i);
        this.e(1);
        this.a(true);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, int i, int j, int k, int l) {
        if (world.isStatic) {
            return true;
        } else {
            i += Facing.b[l];
            j += Facing.c[l];
            k += Facing.d[l];
            Entity entity = EntityTypes.a(itemstack.getData(), world);

            if (entity != null) {
                if (!entityhuman.abilities.canInstantlyBuild) {
                    --itemstack.count;
                }

                entity.setPositionRotation((double) i + 0.5D, (double) j, (double) k + 0.5D, 0.0F, 0.0F);
                world.addEntity(entity);
            }

            return true;
        }
    }
}