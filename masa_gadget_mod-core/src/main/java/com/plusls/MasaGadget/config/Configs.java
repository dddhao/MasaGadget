package com.plusls.MasaGadget.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.plusls.MasaGadget.ModInfo;
import com.plusls.MasaGadget.gui.GuiConfigs;
import com.plusls.MasaGadget.mixin.accessor.AccessorGuiListBase;
import com.plusls.MasaGadget.util.PcaSyncProtocol;
import com.plusls.MasaGadget.util.SearchMobSpawnPointUtil;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import fi.dy.masa.malilib.gui.widgets.WidgetListConfigOptions;
import fi.dy.masa.malilib.util.JsonUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import top.hendrixshen.magiclib.config.ConfigHandler;
import top.hendrixshen.magiclib.config.ConfigManager;
import top.hendrixshen.magiclib.config.Option;
import top.hendrixshen.magiclib.config.annotation.Config;
import top.hendrixshen.magiclib.config.annotation.Hotkey;
import top.hendrixshen.magiclib.dependency.annotation.Dependencies;
import top.hendrixshen.magiclib.dependency.annotation.Dependency;

import java.util.*;

public class Configs {
    public static final HashMap<String, HashSet<String>> FAVORITES = new HashMap<>();
    private static final int CONFIG_VERSION = 1;
    public static boolean favoritesFilter = false;
    // GENERIC
    @Hotkey
    @Config(category = ConfigCategory.GENERIC)
    public static boolean autoSyncEntityData = true;
    @Config(category = ConfigCategory.GENERIC)
    public static boolean debug = false;
    @Hotkey(hotkey = "G,C")
    @Config(category = ConfigCategory.GENERIC)
    public static ConfigHotkey openConfigGui;
    @Hotkey
    @Config(category = ConfigCategory.GENERIC, dependencies = @Dependencies(and = @Dependency(ModInfo.TWEAKEROO_MOD_ID)))
    public static boolean renderNextRestockTime = true;
    @Hotkey
    @Config(category = ConfigCategory.GENERIC, dependencies = @Dependencies(and = @Dependency(ModInfo.TWEAKEROO_MOD_ID)))
    public static boolean renderTradeEnchantedBook = true;
    @Hotkey
    @Config(category = ConfigCategory.GENERIC, dependencies = @Dependencies(and = @Dependency(ModInfo.TWEAKEROO_MOD_ID)))
    public static boolean renderZombieVillagerConvertTime = true;
    @Hotkey(hotkey = ";")
    @Config(category = ConfigCategory.GENERIC, dependencies = @Dependencies(and = @Dependency(ModInfo.MINIHUD_MOD_ID)))
    public static ConfigHotkey searchMobSpawnPoint;
    @Config(category = ConfigCategory.GENERIC, dependencies = @Dependencies(and = @Dependency(ModInfo.MINIHUD_MOD_ID)))
    public static ArrayList<String> searchMobSpawnPointBlackList = new ArrayList<>();
    @Hotkey
    @Config(category = ConfigCategory.GENERIC)
    public static ConfigHotkey syncAllEntityData;
    // LITEMATICA
    @Hotkey
    @Config(category = ConfigCategory.LITEMATICA, dependencies = @Dependencies(and = @Dependency(ModInfo.LITEMATICA_MOD_ID)))
    public static boolean betterEasyPlaceMode = false;
    @Hotkey
    @Config(category = ConfigCategory.LITEMATICA, dependencies = @Dependencies(and = @Dependency(ModInfo.LITEMATICA_MOD_ID)))
    public static boolean disableLitematicaEasyPlaceFailTip = false;
    @Hotkey
    @Config(category = ConfigCategory.LITEMATICA, dependencies = @Dependencies(and = @Dependency(ModInfo.LITEMATICA_MOD_ID)))
    public static boolean fixAccurateProtocol = false;
    @Hotkey
    @Config(category = ConfigCategory.LITEMATICA, dependencies = @Dependencies(and = @Dependency(ModInfo.LITEMATICA_MOD_ID)))
    public static boolean saveInventoryToSchematicInServer = false;
    @Hotkey
    @Config(category = ConfigCategory.LITEMATICA, dependencies = @Dependencies(and = @Dependency(ModInfo.LITEMATICA_MOD_ID)))
    public static boolean useRelativePath = false;
    // MALILIB
    @Hotkey
    @Config(category = ConfigCategory.MALILIB, dependencies = @Dependencies(and = @Dependency(value = ModInfo.MALILIB_MOD_ID, versionPredicate = "<0.11.4")))
    public static boolean backportI18nSupport = true;
    @Hotkey
    @Config(category = ConfigCategory.MALILIB, dependencies = @Dependencies(and = @Dependency(ModInfo.MODMENU_MOD_ID)))
    public static boolean fastSwitchMasaConfigGui = true;
    @Hotkey
    @Config(category = ConfigCategory.MALILIB)
    public static boolean favoritesSupport = false;
    @Hotkey
    @Config(category = ConfigCategory.MALILIB)
    public static boolean fixConfigWidgetWidth = true;
    @Hotkey
    @Config(category = ConfigCategory.MALILIB)
    public static boolean fixGetInventoryType = true;
    @Hotkey
    @Config(category = ConfigCategory.MALILIB)
    public static boolean optimizeConfigWidgetSearch = true;
    @Hotkey
    @Config(category = ConfigCategory.MALILIB)
    public static boolean showOriginalConfigName = false;
    // MINIHUD
    @Hotkey
    @Config(category = ConfigCategory.MINIHUD, dependencies = @Dependencies(and = {@Dependency(ModInfo.MINIHUD_MOD_ID), @Dependency(ModInfo.TWEAKEROO_MOD_ID)}))
    public static boolean pcaSyncProtocolSyncBeehive = true;
    // TWEAKEROO
    @Hotkey
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = @Dependency(ModInfo.TWEAKEROO_MOD_ID)))
    public static boolean inventoryPreviewSupportComparator = true;
    @Hotkey
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = {@Dependency(ModInfo.TWEAKEROO_MOD_ID), @Dependency(ModInfo.CARPET_TIS_ADDITION_MOD_ID)}))
    public static boolean inventoryPreviewSupportLargeBarrel = true;
    @Hotkey
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = {@Dependency(ModInfo.TWEAKEROO_MOD_ID), @Dependency(ModInfo.CARPET_TIS_ADDITION_MOD_ID)}))
    public static boolean inventoryPreviewSupportPlayer = true;
    @Hotkey
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = {@Dependency(ModInfo.TWEAKEROO_MOD_ID), @Dependency(ModInfo.CARPET_TIS_ADDITION_MOD_ID)}))
    public static boolean inventoryPreviewSupportSelect = true;
    @Hotkey
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = {@Dependency(ModInfo.TWEAKEROO_MOD_ID), @Dependency(ModInfo.CARPET_TIS_ADDITION_MOD_ID)}))
    public static boolean inventoryPreviewSupportShulkerBoxItemEntity = true;
    @Hotkey
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = {@Dependency(ModInfo.TWEAKEROO_MOD_ID), @Dependency(ModInfo.CARPET_TIS_ADDITION_MOD_ID)}))
    public static boolean inventoryPreviewSupportTradeOfferList = true;
    @Hotkey
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = @Dependency(ModInfo.TWEAKEROO_MOD_ID)))
    public static boolean inventoryPreviewSyncData = true;
    @Hotkey
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = {@Dependency(ModInfo.TWEAKEROO_MOD_ID), @Dependency(ModInfo.ITEMSCROLLER_MOD_ID)}))
    public static boolean restockWithCrafting = true;
    @Config(category = ConfigCategory.TWEAKEROO, dependencies = @Dependencies(and = {@Dependency(ModInfo.TWEAKEROO_MOD_ID), @Dependency(ModInfo.ITEMSCROLLER_MOD_ID)}))
    public static ArrayList<String> restockWithCraftingRecipes = new ArrayList<>();

    public static void preDeserialize(ConfigHandler configHandler) {

        JsonObject obj = Objects.requireNonNull(JsonUtils.getNestedObject(configHandler.jsonObject,
                ConfigCategory.MALILIB, true));
        JsonObject favoriteObj = Objects.requireNonNull(JsonUtils.getNestedObject(obj, "favorites", true));
        for (Map.Entry<String, JsonElement> favoriteEntry : favoriteObj.entrySet()) {
            HashSet<String> modFavorites = new HashSet<>();
            favoriteEntry.getValue().getAsJsonArray().forEach(jsonElement -> modFavorites.add(jsonElement.getAsString()));
            FAVORITES.put(favoriteEntry.getKey(), modFavorites);
        }
        favoritesFilter = JsonUtils.getBooleanOrDefault(obj, "favoritesFilter", false);
    }

    public static void postSerialize(ConfigHandler configHandler) {
        JsonObject obj = Objects.requireNonNull(JsonUtils.getNestedObject(configHandler.jsonObject,
                ConfigCategory.MALILIB, true));
        JsonObject favoriteObj = new JsonObject();
        for (Map.Entry<String, HashSet<String>> favoriteEntry : FAVORITES.entrySet()) {
            JsonArray modFavoriteObj = new JsonArray();
            if (!favoriteEntry.getValue().isEmpty()) {
                for (String modFavoriteConfigName : favoriteEntry.getValue()) {
                    modFavoriteObj.add(modFavoriteConfigName);
                }
                favoriteObj.add(favoriteEntry.getKey(), modFavoriteObj);
            }
        }
        obj.add("favorites", favoriteObj);
        obj.add("favoritesFilter", new JsonPrimitive(favoritesFilter));
    }

    public static void init(ConfigManager cm) {

        // GENERIC
        cm.setValueChangeCallback("debug", option -> {
            if (debug) {
                Configurator.setLevel(ModInfo.MOD_ID, Level.toLevel("DEBUG"));
            } else {
                Configurator.setLevel(ModInfo.MOD_ID, Level.toLevel("INFO"));
            }
            GuiConfigs.getInstance().reDraw();
        });

        if (debug) {
            Configurator.setLevel(ModInfo.MOD_ID, Level.toLevel("DEBUG"));
        }

        openConfigGui.getKeybind().setCallback((keyAction, iKeybind) -> {
            Minecraft.getInstance().setScreen(GuiConfigs.getInstance());
            return true;
        });

        searchMobSpawnPoint.getKeybind().setCallback((keyAction, iKeybind) -> {
            if (ModInfo.isModLoaded(ModInfo.MINIHUD_MOD_ID)) {
                SearchMobSpawnPointUtil.search();
            }
            return true;
        });

        // LITEMATICA
        syncAllEntityData.getKeybind().setCallback((keyAction, iKeybind) -> {
            if (!PcaSyncProtocol.enable) {
                return true;
            }
            Minecraft mc = Minecraft.getInstance();
            for (Entity entity : Objects.requireNonNull(mc.level).entitiesForRendering()) {
                PcaSyncProtocol.syncEntity(entity.getId());
            }
            TextComponent text = new TextComponent(ModInfo.translate("message.syncAllEntityDataSuccess"));
            text.withStyle(ChatFormatting.GREEN);
            Objects.requireNonNull(mc.player).displayClientMessage(text, false);
            return true;
        });

        // MALILIB
        cm.setValueChangeCallback("favoritesSupport", Configs::refreshOptions);
        cm.setValueChangeCallback("showOriginalConfigName", Configs::refreshOptions);
    }

    private static void refreshOptions(Option option) {
        if (Minecraft.getInstance().screen instanceof GuiConfigsBase) {
            GuiConfigsBase guiConfigsBase = (GuiConfigsBase) Minecraft.getInstance().screen;
            WidgetListConfigOptions widgetListConfigOptions =
                    (WidgetListConfigOptions) ((AccessorGuiListBase) guiConfigsBase).invokeGetListWidget();
            if (widgetListConfigOptions != null) {
                widgetListConfigOptions.getScrollbar().setValue(0);
                widgetListConfigOptions.refreshEntries();
            }
        }
    }

    public static class ConfigCategory {
        public static final String GENERIC = "generic";
        public static final String LITEMATICA = "litematica";
        public static final String MALILIB = "malilib";
        public static final String MINIHUD = "minihud";
        public static final String TWEAKEROO = "tweakeroo";
    }
}