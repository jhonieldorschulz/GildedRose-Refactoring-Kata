package com.gildedrose.refactored.strategy_pattern;


import com.gildedrose.Item;

/**
 * Substitui no original:
 * (Topo, ramo do else "Aged Brie ou Backstage"):
 *   else { if (quality < 50) { quality++; ... } }
 * (Fim, pós-vencido específico para Brie):
 *   if (sellIn < 0) { ... else { // é Aged Brie
 *       if (quality < 50) quality++;
 *   } }
 * Notas:
 * - O teto de 50 é garantido pelo clamp() (remove ifs repetidos).
 */
final class BrieUpdater extends BaseUpdater {

    @Override
    protected void apply(Item item) {
        incQ(item, 1);                 // +1 por dia (ramo "Brie" do topo)
        if (item.sellIn < 0) incQ(item, 1); // +1 extra após vencer (ramo final do Brie)
    }
}
