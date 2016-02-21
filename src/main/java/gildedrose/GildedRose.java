package gildedrose;

import java.util.Arrays;
import java.util.List;


public class GildedRose {


    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";
    private static final int QUALITY_ROOF = 50;
    private static final int QUALITY_FLOOR = 0;
    private static final int SELLIN_LOW = 10;
    private static final int SELLIN_VERY_LOW = 5;
    private List<Item> items = null;

    public GildedRose(Item... items) {
        this.items = Arrays.asList(items);
    }

    Item[] getItems() {
        return (Item[]) items.toArray();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");
        GildedRose gildedRose = new GildedRose(
                new Item("+5 Dexterity Vest", 10, 20),
                new Item(AGED_BRIE, 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item(SULFURAS, 0, 80),
                new Item(BACKSTAGE, 15, 20),
                new Item(CONJURED, 3, 6));

        gildedRose.updateQuality();
    }


    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            switch (item.getName()) {
                case AGED_BRIE:
                    if (item.getQuality() < QUALITY_ROOF) {
                        item.setQuality(item.getQuality() + 1);
                    }
                    if (item.getSellIn() <= 0) {
                        incrementQuality(item);
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    break;
                case BACKSTAGE:
                    if (item.getSellIn() <= 0) {
                        item.setQuality(QUALITY_FLOOR);
                    } else {
                        incrementQuality(item);
                        if (item.getSellIn() <= SELLIN_LOW) {
                            incrementQuality(item);
                        }
                        if (item.getSellIn() <= SELLIN_VERY_LOW) {
                            incrementQuality(item);
                        }
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    break;
                case SULFURAS:
                    break;
                case CONJURED:
                    decrementQuality(item);
                    decrementQuality(item);
                    if (item.getSellIn() <= 0) {
                        decrementQuality(item);
                        decrementQuality(item);
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    break;
                default:
                    decrementQuality(item);
                    if (item.getSellIn() <= 0) {
                        decrementQuality(item);
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    break;
            }
        }
    }

    private void decrementQuality(Item item) {
        if (item.getQuality() > QUALITY_FLOOR) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private void incrementQuality(Item item) {
        if (item.getQuality() < QUALITY_ROOF) {
            item.setQuality(item.getQuality() + 1);
        }
    }

}