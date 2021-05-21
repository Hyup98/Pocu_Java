package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.Article;
import academy.pocu.comp2500.assignment1.Blog;

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

        tem.commentAdder(0, "댓글입니다1");
        tem.commentAdder(0, "댓글입니다2");
        tem.commentAdder(0, "댓글입니다3");

        tem.commentAdder(1, "댓글입니다2");
        tem.commentAdder(1, "댓글입니다3");

        tem.getArticle(0).getComment(0).addSubComment("댓글 1의 댓글입니다.");
        tem.getArticle(0).getComment(0).addSubComment("댓글 1의 댓글입니다.");

        tem.showArticleAndComment();
        tem.getArticle(0).getComment(0).showSubComment();
    }
}