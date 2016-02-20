package gildedrose;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class GildedRoseTest {

    @Test
    public void updateQuality_for_default_items() {
        Item[] givenDefaultItems = new Item[]{new Item("default", 30, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("default", 29, 19)};
        GildedRose gildedRose = new GildedRose(givenDefaultItems);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void updateQuality_for_Aged_Brie() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Aged Brie", 30, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Aged Brie", 29, 21)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void updateQuality_for_Backstage() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 30, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 29, 21)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }

    @Test
    public void updateQuality_for_Backstage_with_low_sellin() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 22)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }
    @Test
    public void updateQuality_for_Backstage_with_very_low_sellin() {
        Item[] givenAnAgedBrie = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        Item[] expectedDefaultItems = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 23)};
        GildedRose gildedRose = new GildedRose(givenAnAgedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.getItems())
                .usingFieldByFieldElementComparator()
                .containsExactly(expectedDefaultItems);
    }
}
