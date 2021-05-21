package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.Article;
import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.Comment;

public class Program {
    public static void main(String[] args) {
        /*
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
         */
        Blog tem = new Blog();
        Article a_1 = new Article("1", "안녕하세요1", "강동협");
        Article a_2 = new Article("2", "안녕하세요2", "강동협");
        Article a_3 = new Article("3", "안녕하세요3", "강동협");
        tem.postArticle(a_1);
        tem.postArticle(a_2);
        tem.postArticle(a_3);
        Comment Ctem_1 = new Comment("1번 댓글");
        Comment Ctem_2 = new Comment("2번 댓글");
        Comment Ctem_3 = new Comment("3번 댓글");
        Comment Ctem_4 = new Comment("4번 댓글");
        Comment Ctem_5 = new Comment("5번 댓글");

        tem.getArticle(0).addComment(Ctem_1);
        tem.getArticle(1).addComment(Ctem_2);
        tem.getArticle(1).addComment(Ctem_3);
        tem.getArticle(1).addComment(Ctem_4);
        tem.getArticle(2).addComment(Ctem_5);

        tem.showArticleAndComment();
        //tem.getArticle(0).getComment(0).showSubComment();

        //tem.getArticle(0).titleUpdater("새로운 제목");
        //tem.showArticle();

    }
}