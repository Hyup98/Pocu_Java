package academy.pocu.comp2500.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListItemTest {

    @Test
    public void testListItemString() {
        ListItem item1 = new ListItem("This is item1");
        String s = item1.toString();
        assertEquals("* This is item1\r\n", s);
    }

    @Test
    public void testListItemStringChar() {
        ListItem item1 = new ListItem("This is item1", '1');
        String s = item1.toString();
        assertEquals("1 This is item1\r\n", s);
    }

    @Test
    public void testAddSublistItem() {
        ListItem item1 = new ListItem("This is item1");

        item1.addSublistItem(new ListItem("This is sublist item1"));
        String s = item1.toString();
        assertEquals("* This is item1\r\n    * This is sublist item1\r\n", s);
    }

    @Test
    public void testGetSublistItem() {
        ListItem item1 = new ListItem("This is item1");

        item1.addSublistItem(new ListItem("This is sublist item1"));

        ListItem sublistItem1 = item1.getSublistItem(0);
        String s = sublistItem1.getText(); // s: This is sublist item1
        System.out.println(s);
        assertEquals("This is sublist item1", s);
    }

    @Test//
    public void testRemoveSublistItem() {
        ListItem item = new ListItem("This is item");

        item.addSublistItem(new ListItem("This is sublist item1"));
        item.addSublistItem(new ListItem("This is sublist item2"));

        String s = item.toString();
        /*
         * This is item
         * This is sublist item1
         * This is sublist item2
         */
        System.out.println(s);
        item.removeSublistItem(0);

        s = item.toString();
        /*
         * This is item
         * This is sublist item2
         */
        System.out.println(s);

        /*
        assertEquals(
                "* This is item\r\n" +
                        "    * This is sublist item2\r\n", s);

         */
    }

    @Test
    public void testGetText() {
        ListItem item1 = new ListItem("This is item1");
        String s = item1.getText(); // s: This is item1
        System.out.println(s);
        assertEquals("This is item1", s);
    }

    @Test
    public void testSetText() {
        ListItem item1 = new ListItem("This is item1");
        String s = item1.getText(); // s: This is item1

        item1.setText("This is updated item1");
        s = item1.getText(); // s: This is updated item1
        System.out.println(s);
        assertEquals("This is updated item1", s);
    }

    @Test
    public void testGetBulletStyle() {
        ListItem item1 = new ListItem("This is item1");
        char c = item1.getBulletStyle(); // c: *
        System.out.println(c);
        assertEquals('*', c);
    }

    @Test
    public void testSetBulletStyle() {
        ListItem item1 = new ListItem("This is item1");
        char c = item1.getBulletStyle(); // s: This is item1
        item1.setBulletStyle('>');
        c = item1.getBulletStyle(); // c: >
        System.out.println(c);
        assertEquals('>', c);
    }

    @Test
    public void testToString() {
        ListItem item1 = new ListItem("This is item1");
        ListItem sublistItem1 = new ListItem("This is sublist item1");
        ListItem subSublistItem1 = new ListItem("This is sub-sublist item1");
        ListItem subSublistItem2 = new ListItem("This is sub-sublist item2");

        sublistItem1.addSublistItem(subSublistItem1);
        sublistItem1.addSublistItem(subSublistItem2);
        item1.addSublistItem(sublistItem1);

        String s = item1.toString();
        System.out.println(s);
        assertEquals(
                "* This is item1\r\n" +
                        "    * This is sublist item1\r\n" +
                        "        * This is sub-sublist item1\r\n" +
                        "        * This is sub-sublist item2\r\n", s);
    }

}