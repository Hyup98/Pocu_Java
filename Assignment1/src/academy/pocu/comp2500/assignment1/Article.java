package academy.pocu.comp2500.assignment1;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private ArrayList<Comment> commentToArticle = new ArrayList<>();

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

    public void addComment(Comment comment) {
        commentToArticle.add(comment);
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

    public void titleUpdater(String title) {
        this.title = title;
    }

    public void bodyUpdater(String body) {
        this.content = body;
    }

    public void tagAdder(String tag) {
        this.tag = tag;
    }

    public void addReaction(int type){
        switch (type) {
            case 1:
                addGreat();
                break;
            case 2:
                addSad();
                break;
            case 3:
                addAngry();
                break;
            case 4:
                addFun();
                break;
            case 5:
                addLove();
                break;
            default:
                break;
        }

    }

    public void subReaction(int type) {
        switch (type) {
            case 1:
                subGreat();
                break;
            case 2:
                subSad();
                break;
            case 3:
                subAngry();
                break;
            case 4:
                subFun();
                break;
            case 5:
                subLove();
                break;
            default:
                break;
        }
    }

    public String getAllComment() {
        StringBuilder sb = new StringBuilder("");
        if (commentToArticle.size() != 0) {
            for (int i = 0; i < commentToArticle.size(); i++) {
                sb.append("   * " + commentToArticle.get(i).getCommentCotent() + "\n");
            }
        }
        String answer = sb.toString();
        return answer;
    }

    public void addSubComment(Comment comment) {
        if(!comment.getCommentCotent().equals("")){
            commentToArticle.add(comment);
        }
    }

    public Comment getComment(int i){
        return commentToArticle.get(i);
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
        System.out.print(getAllComment());
    }

}
