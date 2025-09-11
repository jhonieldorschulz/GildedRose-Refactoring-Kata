package com.gildedrose.refactored.strategy_pattern;

import com.gildedrose.Item;

/**
    * Substitui no original:
    * (Topo, bloco "não Brie e não Backstage"):
    *   if (!"Aged Brie" && !"Backstage") {
    *     if (quality > 0) {
    *       if (!"Sulfuras") quality--;
    *     }
    *   }
    * (Fim, pós-vencido para "não Brie e não Backstage"):
    *   if (sellIn < 0) {
    *     if (!"Aged Brie") {
    *       if (!"Backstage") {
    *         if (quality > 0) {
    *           if (!"Sulfuras") quality--;
    *         }
    *       }
    *     }
    *   }
    * Observação: os guardas de quality (>0) viram clamp() central.
 */
final class NormalUpdater extends BaseUpdater{
    @Override
    protected void apply(Item item) {
        decQ(item, 1);               // regra: degrada 1
        if (item.sellIn < 0) decQ(item, 1); // pós-vencimento: degrada 2
    }
}
