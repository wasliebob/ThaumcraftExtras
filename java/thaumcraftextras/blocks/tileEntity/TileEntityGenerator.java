/*
package thaumcraftextras.blocks.tileEntity;

import ic2.api.energy.prefab.BasicSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.tiles.TileJarFillable;
import thaumcraftextras.main.Config;

public class TileEntityGenerator extends TileEntity {
        int x;
        int y;
        int z;
        public ForgeDirection orientation;
        private BasicSource energySource = new BasicSource(this, 1000000000, 2);

        public TileEntityGenerator() {
                orientation = ForgeDirection.getOrientation(1);
        }

        @Override
        public void updateEntity() {
                energySource.updateEntity();

                findIgnis();
                TileEntity essentia = super.worldObj.getBlockTileEntity(x, y, z);
                if (essentia != null && (essentia instanceof TileJarFillable)) {
                        if (checkEssentia((TileJarFillable) essentia)) {
                                energySource.addEnergy(6000);
                        }
                }
        }

        @Override
        public void onChunkUnload() {
                energySource.onChunkUnload();
        }

        @Override
        public void invalidate() {
                energySource.invalidate();
                super.invalidate();
        }

        private boolean checkEssentia(TileJarFillable jar) {
               // if (jar.doesContainerContainAmount(GeneratorFunctions.getAllAspects(), 2)) {
                 if(jar.doesContainerContainAmount(Aspect.FIRE, 2))
                 {
        				x = ((TileEntity) (jar)).xCoord;
                        y = ((TileEntity) (jar)).yCoord;
                        z = ((TileEntity) (jar)).zCoord;
                        if (!super.worldObj.isRemote) {
                                jar.takeFromContainer(Aspect.FIRE, 1);
                                super.worldObj
                                                .addBlockEvent(super.xCoord, super.yCoord,
                                                                super.zCoord,
                                                                Config.generatorId, 5, 0);
                        }
                        return true;
                
                 }
                 else if(jar.doesContainerContainAmount(Aspect.ENERGY, 2))
                 {
                	 x = ((TileEntity) (jar)).xCoord;
                     y = ((TileEntity) (jar)).yCoord;
                     z = ((TileEntity) (jar)).zCoord;
                     if (!super.worldObj.isRemote) {
                             jar.takeFromContainer(Aspect.ENERGY, 1);
                             super.worldObj
                                             .addBlockEvent(super.xCoord, super.yCoord,
                                                             super.zCoord,
                                                             Config.generatorId, 5, 0);
                     }
                     return true;
             
              }
                else 
                {
                        return false;
                }
        }

        public void findIgnis() {
                if (x != 0x7fffffff) {
                        TileEntity ja = super.worldObj.getBlockTileEntity(x, y, z);
                        if (ja != null && (ja instanceof TileJarFillable)) {
                                if (checkEssentia((TileJarFillable) ja)) {
                                        return;
                                }
                                x = 0x7fffffff;
                        }
                }
                int xx = 0;
                int yy = 0;
                int zz = 0;
                for (int y = -5; y <= 5; y++) {
                        for (int bb = -5; bb <= 5; bb++) {
                                for (int cc = 1; cc < 6; cc++) {
                                        xx = super.xCoord;
                                        yy = super.yCoord + y;
                                        zz = super.zCoord;
                                        if (orientation.getOpposite().offsetX == 0) {
                                                xx += bb;
                                                zz += cc * orientation.getOpposite().offsetZ;
                                        } else {
                                                zz += bb;
                                                xx += cc * orientation.getOpposite().offsetX;
                                        }
                                        TileEntity te = super.worldObj.getBlockTileEntity(xx, yy,
                                                        zz);
                                        if (te != null && (te instanceof TileJarFillable)
                                                        && checkEssentia((TileJarFillable) te)) {
                                                return;
                                        }
                                }
                        }
                }
        }

        @Override
        public void readFromNBT(NBTTagCompound tag) {
                super.readFromNBT(tag);
                energySource.readFromNBT(tag);
        }

        @Override
        public void writeToNBT(NBTTagCompound tag) {
                super.writeToNBT(tag);
                energySource.writeToNBT(tag);
        }
}

*/
