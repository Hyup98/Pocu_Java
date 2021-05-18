package src.academy.pocu.comp2500.assignment1;
import  java.util.ArrayList;

public class Article {
    public String title;
    public String content;
    public String tag;
    public ArrayList<Reaction> articleReaction = new ArrayList<Reaction>();
    public ArrayList<Comment> CommentToArticle = new ArrayList<Comment>();
    public String Tag;
    public void tagging(String tag){
        this.tag = tag;
    }
    /**
     * 1)댓글보기(추천수 내림차순)
     * 2)글쓰기
     * 3)제목 및 내용 수정
     * 4)
     */

}
