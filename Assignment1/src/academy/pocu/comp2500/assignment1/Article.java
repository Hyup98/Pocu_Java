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
    private ArrayList<Comment> commentToArticle = new ArrayList<Comment>();

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

    public int getCommentAmmount() {
        return commentToArticle.size();
    }

    public void addComment(String comment) {
        Comment tem = new Comment(comment);
        commentToArticle.add(tem);
    }

    public void addComment(Comment com) {
        commentToArticle.add(com);
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
        for (int i = 0; i < commentToArticle.size() - 1; i++) {
            for (int j = i + 1; j < commentToArticle.size(); j++) {
                if (commentToArticle.get(i).voteResult() < commentToArticle.get(j).voteResult()) {
                    Collections.swap(commentToArticle, i, j);
                }
            }
        }

        for (int i = 0; i < commentToArticle.size(); i++) {
            commentToArticle.get(i).CommentSorting();
        }

    }

    public Comment getComment(int index) {
        return commentToArticle.get(index);
    }

    public String getArticleComment() {
        StringBuilder sb = new StringBuilder("");
        if (commentToArticle.size() != 0) {
            for (int i = 0; i < commentToArticle.size(); i++) {
                sb.append("   * " + commentToArticle.get(i).getComment() + "\n");
            }
        }
        String answer = sb.toString();
        return answer;
    }

    public void addSubComment(String sub, int i) {
        if (!sub.equals("")) {
            Comment tem = new Comment(sub);
            commentToArticle.add(tem);
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

    public void changeComment( int i, String comment) {
        commentToArticle.get(i).setComment(comment);
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

    public void showComment() {
        //commentSorting();
        System.out.print(getArticleComment());
    }

}
