package com.gildedrose.refactored;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GildedRoseCharacterizationTest {
    @Test
    public void normal_item_degrada_1() {
        Item elixir = new Item("Elixir of the Mongoose", 5, 7);
        GildedRose app = new GildedRose(List.of(elixir).toArray(new Item[0]));

        app.updateQuality();

        assertEquals(4, elixir.sellIn); // 5 → 4 (todo dia)
        assertEquals(6, elixir.quality); // 7 → 6 (comum degrada 1/dia)
    }

    @Test
    public void aged_brie_sobe_ate_50() {
        Item brie = new Item("Aged Brie", 2, 49);
        GildedRose app = new GildedRose(List.of(brie).toArray(new Item[0]));

        app.updateQuality();

        assertEquals(1, brie.sellIn);
        assertEquals(50, brie.quality); // teto 50
    }

    @Test
    public void backstage_zera_pos_show() {
        Item pass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);
        GildedRose app = new GildedRose(List.of(pass).toArray(new Item[0]));

        app.updateQuality();

        assertEquals(-1, pass.sellIn);
        assertEquals(0, pass.quality); // pós-show zera
    }

    @Test
    public void sulfuras_nao_muda() {
        Item s = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose app = new GildedRose(List.of(s).toArray(new Item[0]));

        app.updateQuality();

        assertEquals(0, s.sellIn);  // lendário não vence
        assertEquals(80, s.quality); // nem degrada (e 80 > 50 mesmo)
    }

    @Test
    public void conjured_degrada_2x() {
        Item c = new Item("Conjured Mana Cake", 3, 6);
        GildedRose app = new GildedRose(List.of(c).toArray(new Item[0]));

        app.updateQuality();

        System.out.println(c);

        assertEquals(2, c.sellIn);
        assertEquals(4, c.quality); // 6 → 4 (2x mais rápido)
    }

}
