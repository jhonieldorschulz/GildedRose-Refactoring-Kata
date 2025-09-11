package com.gildedrose.refactored.strategy_pattern;

import com.gildedrose.Item;

/**
 * Substitui no original:
 * (Topo, ramo Backstage com bônus por proximidade):
 *   else { if (quality < 50) {
 *     quality++;
 *     if ("Backstage") {
 *       if (sellIn < 11 && quality < 50) quality++;
 *       if (sellIn < 6  && quality < 50) quality++;
 *     }
 *   } }
 * (Fim, pós-vencido Backstage):
 *   if (sellIn < 0) { if (!"Aged Brie") {
 *     if (!"Backstage") { ... } else { quality = 0; }
 *   } }
 * Nota de equivalência: aqui o sellIn já foi decrementado no template.
 * Portanto, os limiares <11 e <6 viram <10 e <5, mantendo o mesmo efeito.
 */
final class BackstageUpdater extends BaseUpdater {
    @Override
    protected void apply(Item it) {
        if (it.sellIn < 0) { it.quality = 0; return; } // zera pós-show (bloco final)
        incQ(it, 1);                 // +1 base (ramo do topo)
        if (it.sellIn < 10) incQ(it, 1); // bonus <11 do original
        if (it.sellIn < 5)  incQ(it, 1); // bonus <6  do original
    }
}
