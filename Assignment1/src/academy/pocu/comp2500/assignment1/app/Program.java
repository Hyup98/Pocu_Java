package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.Article;
import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.Comment;
import academy.pocu.comp2500.assignment1.App;
import academy.pocu.comp2500.assignment1.registry.*;

public class Program {
    public static void main(String[] args) {
        /*
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
         */
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

    }
}