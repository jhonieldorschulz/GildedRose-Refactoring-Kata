package com.gildedrose.refactored.strategy_pattern;

import com.gildedrose.Item;

/**
 * Substitui no original:
 * - Todos os pontos onde há `if (!"Sulfuras")`:
 *   * no topo (não mexer na quality de Sulfuras),
 *   * no meio (`if (!"Sulfuras") sellIn--`),
 *   * no fim (não degradar quality).
 * Aqui, NÃO herdamos BaseUpdater:
 * - não decrementa sellIn,
 * - não aplica clamp (mantém quality=80).
 */
final class LegendaryUpdater implements Updater {
    @Override
    public void update(Item it) {
        // nada acontece (Sulfuras é imutável no kata)
    }


}
