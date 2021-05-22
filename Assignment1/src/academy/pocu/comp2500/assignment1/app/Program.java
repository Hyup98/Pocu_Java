package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.Article;
import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.Comment;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        /*
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
         */
        Scanner sc = new Scanner(System.in);
        Blog hyup = new Blog();

        Article tem_1 = new Article("100","123","강동협");
        Article tem_2 = new Article("101","123","강동협");
        Article tem_3 = new Article("102","123","123");
        Article tem_4 = new Article("103","123","강동협");
        Article tem_5 = new Article("104","123","강동협");

        int a = 0;
        hyup.postArticle(tem_1);//100
        //a= sc.nextInt();
        hyup.postArticle(tem_4);//103
        //a= sc.nextInt();
        hyup.postArticle(tem_2);//101
        //a= sc.nextInt();
        hyup.postArticle(tem_3);//102
        //a= sc.nextInt();
        hyup.postArticle(tem_5);//104

        Comment Ctem_1 = new Comment("hello");
        Comment Ctem_2 = new Comment("goodby");

        tem_1.addComment(Ctem_1);
        tem_3.addComment(Ctem_2);

        System.out.print(hyup.getArticleList());
        hyup.sortDescendingByCreatDate();
        System.out.print("/////////////////////\n" + hyup.getArticleList());

        System.out.print(hyup.getArticle(0).getAllComment());


    }
}