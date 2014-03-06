package thaumcraftextras.client;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import thaumcraftextras.helpers.MainHelper;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler {

        public static int elapsedTicks;
        private final Minecraft mc;


        public ClientTickHandler() {
        	mc = Minecraft.getMinecraft();
        }

        @Override
        public void tickStart(EnumSet<TickType> type, Object... tickData) {
        }

        @Override
        public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        	 HudHandler.clientTick();
        	 ++elapsedTicks;
        }

        
        @Override
        public EnumSet<TickType> ticks() {
                return EnumSet.of(TickType.CLIENT);
        }

        @Override
        public String getLabel() {
                return MainHelper.modName;
        }

}

