package thaumcraftextras.helpers;

import java.util.ArrayList;
import java.util.EnumSet;

import thaumcraftextras.main.Config;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandlerVersion implements IScheduledTickHandler
{

    public static TickHandlerVersion instance = new TickHandlerVersion();

    private static ArrayList<UpdateHelper> modVersionInfo = new ArrayList();
    private static boolean initialized;
    private static boolean sent;
    private static int modIndex = 0;

    public static boolean initialize()
    {
        if (initialized)
        {
            return false;
        }
        initialized = true;
        return true;
    }

    public static boolean isInitialized()
    {
        return initialized;
    }

    public static boolean registerModVersionInfo(UpdateHelper info)
    {
        if (modVersionInfo.contains(info))
        {
            return false;
        }
        modVersionInfo.add(info);
        return true;
    }

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
        if (sent)
        {
            return;
        }

        if (modIndex < modVersionInfo.size())
        {
        	UpdateHelper anInfo = modVersionInfo.get(modIndex);

            if ((!Config.updateNotification || !anInfo.isCriticalUpdate()) && anInfo.isNewVersionAvailable())
            {
                EntityPlayer player = (EntityPlayer) tickData[0];
                player.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "[" + anInfo.modName + "] A new version is available: " + anInfo.getLatestVersion()));
                player.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.AQUA + anInfo.getVersionDescription()));
            }
            modIndex += 1;
        }
        else
        {
            sent = true;
        }
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        if (TickHandlerVersion.sent)
        {
            return EnumSet.noneOf(TickType.class);
        }
        return EnumSet.of(TickType.PLAYER);
    }

    @Override
    public String getLabel()
    {
        return "thaumcraftextras.version";
    }

    @Override
    public int nextTickSpacing()
    {
        if (!sent)
        {
            return 200;
        }
        return 72000;
    }
}