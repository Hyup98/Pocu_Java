package academy.pocu.comp2500.assignment1;

import javax.crypto.CipherInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.OffsetDateTime;
import java.util.Collections;

public class Article {
    private String author;
    private String title;
    private String content;
    private String tag;
    private int Great;
    private int Sad;
    private int Angry;
    private int Fun;
    private int Love;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;
    private ArrayList<Comment> CommentToArticle = new ArrayList<Comment>();

    public void tagging(String tag) {
        this.tag = tag;
    }

    public Article(String title, String content, String author) {
        this.author = author;
        this.title = title;
        this.content = content;
        Great = 0;
        Sad = 0;
        Angry = 0;
        Fun = 0;
        Love = 0;

    }

    public void showReaction() {
        System.out.print("Great - " + Great + "\n" +
                "Sad - " + Sad + "\n" +
                "Angry - " + Angry + "\n" +
                "Fun - " + Fun + "\n" +
                "Love - " + Love + "\n");

    }

    public int getCommentAmmount(){
        return CommentToArticle.size();
    }

    public void addComment(String comment, String writeId) {
        Comment tem = new Comment(comment, writeId);
        CommentToArticle.add(tem);
    }

    public void addComment(Comment com) {
        CommentToArticle.add(com);
    }

    public void addGreat() {
        Great++;
    }

    public void subGreat() {
        if (Great > 0) {
            Great--;
        }
    }

    public void addSad() {
        Sad++;
    }

    public void subSad() {
        if (Sad > 0) {
            Sad--;
        }
    }

    public void addAngry() {
        Angry++;
    }

    public void subAngry() {
        if (Angry > 0) {
            Angry--;
        }
    }

    public void addFun() {
        Fun++;
    }

    public void subFun() {
        if (Fun > 0) {
            Fun--;
        }
    }

    public void addLove() {
        Love++;
    }

    public void subLove() {
        if (Love > 0) {
            Love--;
        }
    }

    public void commentSorting() {
        for (int i = 0; i < CommentToArticle.size() - 1; i++) {
            for (int j = i + 1; j < CommentToArticle.size(); j++) {
                if (CommentToArticle.get(i).voteResult() < CommentToArticle.get(j).voteResult()) {
                    Collections.swap(CommentToArticle, i, j);
                }
            }
        }

        for (int i = 0; i < CommentToArticle.size(); i++) {
            CommentToArticle.get(i).CommentSorting();
        }

    }

    public Comment getComment(int index){
        return CommentToArticle.get(index);
    }

    public String getArticleComment() {
        StringBuilder sb = new StringBuilder("");
        if (CommentToArticle.size() != 0) {
            for(int  i = 0; i<CommentToArticle.size();i++){
                sb.append("   * "+CommentToArticle.get(i).getComment()+"\n");
            }
        }
        String answer = sb.toString();
        return answer;
    }

    public void addSubComment(String sub, int i, String writerId) {
        if (!sub.equals("")) {
            Comment tem = new Comment(sub, writerId);
            CommentToArticle.add(tem);
            tem.setAncestor(null);
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void changeComment(String writeId, int i, String comment) {
        CommentToArticle.get(i).setComment(comment, writeId);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;

    }

    public void setCreatedDateTime() {
        createdDateTime = LocalDateTime.now();
    }

    public void setModifiedDateTime() {
        modifiedDateTime = LocalDateTime.now();
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public LocalDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void showComment(){
        //commentSorting();
        System.out.print(getArticleComment());
    }

}
