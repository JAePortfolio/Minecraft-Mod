package com.JAePortfolio.tutorialmod;

import com.JAePortfolio.tutorialmod.proxy.CommonProxy;
import com.JAePortfolio.tutorialmod.tab.CreativeTabTutorial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION, name = TutorialMod.NAME)
// Tells forge mod loader this is a MOD

public class TutorialMod
{
    public static final String MODID = "tutorialmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Tutorial Mod";

    @SidedProxy(clientSide = "com.JAePortfolio.tutorialmod.proxy.ClientProxy", serverSide = "com.JAePortfolio.tutorialmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static TutorialMod instance;

    public static CreativeTabTutorial tabTutorial;

    // Pre Init
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        tabTutorial = new CreativeTabTutorial(CreativeTabs.getNextID(), "tab_tutorial");
        proxy.preInit(event);
    }

    // Init
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    //Post Init
    @EventHandler
    public void init(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}
