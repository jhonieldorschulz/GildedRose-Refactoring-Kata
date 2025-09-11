package com.gildedrose.refactored.strategy_pattern;

import com.gildedrose.Item;

/**
 * Extensão comum do kata (NÃO existe no original clássico).
 * Regra adotada: "Conjured" degrada 2x (antes e depois do vencimento).
 * Não mapeia ifs existentes; é um requisito adicional.
 */
final class ConjuredUpdater extends BaseUpdater {
    @Override
    protected void apply(Item it) {
        decQ(it, 2);                 // -2 por dia
        if (it.sellIn < 0) decQ(it, 2); // -2 extra após vencer
    }
}
