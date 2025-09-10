package com.gildedrose.refactored.strategy_pattern;

import com.gildedrose.Item;

public class NormalUpdater extends BaseUpdater{
    @Override
    protected void apply(Item item) {
        decQ(item, 1);               // regra: degrada 1
        if (item.sellIn < 0) decQ(item, 1); // pós-vencimento: degrada 2
    }
}
