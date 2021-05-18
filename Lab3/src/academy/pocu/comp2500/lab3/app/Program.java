package academy.pocu.comp2500.lab3.app;

import academy.pocu.comp2500.lab3.ListItem;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        ListItem item1 = new ListItem("This is item1", '1');
        ListItem item2 = new ListItem("This is item2", '2');

        System.out.print(item1.toString());
/*
1 This is item1

*/

        System.out.print(item2.toString());
/*
2 This is item2

*/
    }
}
