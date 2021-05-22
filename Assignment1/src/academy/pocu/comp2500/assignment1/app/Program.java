package academy.pocu.comp2500.assignment1.app;
import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        Blog hyup = new Blog();

        Article tem_1 = new Article("100","123","강동협");
        Article tem_2 = new Article("101","123","강동협");
        Article tem_3 = new Article("102","123","123");
        Article tem_4 = new Article("103","123","강동협");
        Article tem_5 = new Article("104","123","강동협");

        int a=  0;
        hyup.postArticle(tem_1);//100
        System.out.print("시간차\n");
        a= sc.nextInt();
        hyup.postArticle(tem_4);//103
        System.out.print("시간차\n");
        a= sc.nextInt();
        hyup.postArticle(tem_2);//101
        System.out.print("시간차\n");
        a= sc.nextInt();
        hyup.postArticle(tem_3);//102
        System.out.print("시간차\n");
        a= sc.nextInt();
        hyup.postArticle(tem_5);//104
        System.out.print(hyup.getArticleList());
        hyup.sortDescendingByCreatDate();
        System.out.print("/////////////////////\n"+hyup.getArticleList());


    }
}