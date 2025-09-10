package com.gildedrose.refactored.strategy_pattern;

import com.gildedrose.Item;

abstract public class BaseUpdater implements Updater {

    protected void decSellIn(Item item) { item.sellIn--; }

    protected void incQ(Item item, int d) { item.quality += d; }
    protected void decQ(Item item, int d) { item.quality -= d; }

    protected void clamp(Item item) {
        // Por que a exceção?
        // Porque "Sulfuras" tem quality = 80 e não deve ser forçado a 50.
        if (!item.name.startsWith("Sulfuras")) {
            if (item.quality < 0)  item.quality = 0;
            if (item.quality > 50) item.quality = 50;
        }
    }

    @Override
    public void update(Item item) {
        // Ordem pedagógica importante:
        // 1) diminuir o prazo
        decSellIn(item);

        // 2) aplicar regra específica
        apply(item);

        // 3) garantir invariantes (pós-condição)
        clamp(item);
    }

    protected abstract void apply(Item item); // “o que muda” em cada tipo


}
