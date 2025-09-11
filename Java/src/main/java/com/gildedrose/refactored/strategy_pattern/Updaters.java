package com.gildedrose.refactored.strategy_pattern;

import com.gildedrose.Item;

import java.util.Map;

/**
 * Substitui no original:
 * - A seleção por nome espalhada em vários ifs:
 * "É Brie?", "É Backstage?", "É Sulfuras?".
 * Centraliza a escolha da estratégia por nome.
 * Nota: "Conjured" é extensão -> detectado por substring (kata).
 */
public final class Updaters {
    private static final Updater NORMAL = new NormalUpdater();
    private static final Updater BRIE = new BrieUpdater();
    private static final Updater BACKSTAGE = new BackstageUpdater();
    private static final Updater LEGENDARY = new LegendaryUpdater();
    private static final Updater CONJURED = new ConjuredUpdater();

    private static final Map<String, Updater> REGISTRY = Map.of(
        "Aged Brie", BRIE,
        "Backstage passes to a TAFKAL80ETC concert", BACKSTAGE,
        "Sulfuras, Hand of Ragnaros", LEGENDARY
    );

    public static Updater of(Item it) {
        String n = it.name == null ? "" : it.name;
        if (n.toLowerCase().contains("conjured")) return CONJURED; // extensão
        return REGISTRY.getOrDefault(n, NORMAL); // default cobre o bloco "não Brie/Backstage/Sulfuras"
    }

    private Updaters() {
    }
}
