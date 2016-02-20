package gildedrose;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		Item[] givenDefaultItems = new Item[]{new Item("default", 30, 20)};
		Item[] expectedDefaultItems = new Item[]{new Item("default", 29, 19)};
		GildedRose gildedRose = new GildedRose(givenDefaultItems);
		gildedRose.updateQuality();
		Assert.assertEquals(gildedRose.getItems(), expectedDefaultItems);
	}
}
