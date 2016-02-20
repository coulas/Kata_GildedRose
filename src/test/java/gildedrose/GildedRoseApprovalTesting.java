package gildedrose;

import com.github.approval.Approvals;
import com.github.approval.Reporter;
import com.github.approval.reporters.MacOSReporters;
import com.github.approval.reporters.Reporters;
import com.github.approval.reporters.WindowsReporters;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.stream.XMLReporter;
import java.nio.file.Paths;

public class GildedRoseApprovalTesting {
    private Item[] items;

    @BeforeClass
    public static void setUpOnce() {
        Approvals.setReporter(Reporters.firstWorking(
                WindowsReporters.beyondCompare(),
                WindowsReporters.notepadPlusPlus(),
                WindowsReporters.tortoiseImage(),
                WindowsReporters.tortoiseText(),
                WindowsReporters.winMerge(),
                Reporters.imageMagick(),
                Reporters.fileLauncherWithoutInteraction(),
                Reporters.gvim(),
                Reporters.fileLauncher(),
                Reporters.console(),
                Reporters.gedit(),
                MacOSReporters.diffMerge(),
                MacOSReporters.ksdiff(),
                MacOSReporters.p4merge(),
                MacOSReporters.tkdiff()));
    }

    @Before
    public void setUp() {
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6),
                new Item("default item", 40, 45)
        };
    }

    @Test
    public void should_have_no_regression_compared_to_golden_master() {

        GildedRose app = new GildedRose(items);

        int days = 30;
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < days; i++) {
            actual.append("-------- day " + i + " --------\n");
            actual.append("name, sellIn, quality\n");
            for (Item item : items) {
                actual.append(item).append(System.lineSeparator());
            }
            actual.append("\n");
            app.updateQuality();
        }

        Approvals.verify(actual.toString(), Paths.get("target/test-classes/gildedrose/golden-master.txt"));

    }
}
