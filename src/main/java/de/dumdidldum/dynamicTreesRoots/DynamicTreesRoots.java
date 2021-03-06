package de.dumdidldum.dynamicTreesRoots;

import de.dumdidldum.dynamicTreesRoots.proxy.CommonProxy;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DynamicTreesRoots.MODID, name = DynamicTreesRoots.NAME, version = DynamicTreesRoots.VERSION,  dependencies = DynamicTreesRoots.DEPENDENCIES)
public class DynamicTreesRoots {
	public static final String MODID = "dynamictreesroots";
	public static final String NAME = "Dynamic Trees Roots";
	public static final String VERSION = "0.2.1";
	public static final String DEPENDENCIES = "required-after:dynamictrees@[1.12.2-0.9.6,);required-after:roots;required-before:mysticallib";
	public static ModContainer CONTAINER = null;
	
    @Instance
    public static DynamicTreesRoots instance;

    @SidedProxy(clientSide = "de.dumdidldum.dynamicTreesRoots.proxy.ClientProxy", serverSide = "de.dumdidldum.dynamicTreesRoots.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CONTAINER = Loader.instance().activeModContainer();
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        proxy.postInit(event);
    }

}