package com.robertx22.mine_and_slash.config;

import net.minecraftforge.common.config.Config;

public class DropRatesContainer {

  @Config.Name("Loot Boxes Droprate")
  @Config.LangKey("")
  @Config.Comment("")
  public float LOOTBOX_DROPRATE = 0.03F;

  @Config.Name("Runed Gear Droprate")
  @Config.LangKey("mmorpg.config.runed_gear_droprate")
  @Config.Comment("")
  public float RUNED_GEAR_DROPRATE = 1.8F;

  @Config.Name("Rune Droprate")
  @Config.LangKey("mmorpg.config.rune_droprate")
  @Config.Comment("Runes that can be socketed into items and create runewords!")
  public float RUNE_DROPRATE = 1.25F;

  @Config.Name("Map Droprate")
  @Config.LangKey("mmorpg.config.map_droprate")
  @Config.Comment("Adventure maps, temporary items that create a temporary world to kill mobs in")
  public float MAP_DROPRATE = 1;

  @Config.Name("Gear Droprate")
  @Config.LangKey("mmorpg.config.gear_droprate")
  @Config.Comment("")
  public float GEAR_DROPRATE = 7.5F;

  @Config.Name("Compatible Items Droprate")
  @Config.LangKey("mmorpg.config.compatible_items_droprate")
  @Config.Comment("")
  public float COMPATIBLE_ITEMS_DROPRATE = 2.5F;

  @Config.Name("Unique  Droprate")
  @Config.LangKey("mmorpg.config.unique_droprate")
  @Config.Comment("Unique gear items that drop from maps only")
  public float UNIQUE_DROPRATE = 0.15F;

  @Config.Name("Spell Droprate")
  @Config.LangKey("mmorpg.config.spell_droprate")
  @Config.Comment("")
  public float SPELL_DROPRATE = 4;

  @Config.Name("Currency Droprate")
  @Config.LangKey("mmorpg.config.currency_droprate")
  @Config.Comment("Currency, or items you use to modify gear")
  public float CURRENCY_DROPRATE = 3;

  @Config.Name("Awaken RuneWord Droprate")
  @Config.LangKey("mmorpg.config.awaken_runeword_droprate")
  @Config.Comment("These Items Awaken The dormant RuneWord combination of an item")
  public float AWAKEN_RUNEWORD_DROPRATE = 0.25F;

}