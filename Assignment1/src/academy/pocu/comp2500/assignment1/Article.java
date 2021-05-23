package academy.pocu.comp2500.assignment1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Article {
    private String articleId;
    private String author;
    private String title;
    private String content;
    private String tag;
    private int great;
    private int sad;
    private int angry;
    private int fun;
    private int love;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;
    private ArrayList<Comment> commentToArticle = new ArrayList<>();

    public void tagging(String tag) {
        this.tag = tag;
    }

    public Article(String title, String content, String author, String articleId) {
        if (!title.equals("")) {
            if (!content.equals("")) {
                if (!author.equals("")) {
                    if (!articleId.equals("")) {
                        this.articleId = articleId;
                        this.author = author;
                        this.title = title;
                        this.content = content;
                        great = 0;
                        sad = 0;
                        angry = 0;
                        fun = 0;
                        love = 0;
                        createdDateTime = null;
                        modifiedDateTime = null;
                    }
                }
            }
        }
    }

    public void showReaction() {
        System.out.print("great - " + great + "\n" +
                "sad - " + sad + "\n" +
                "angry - " + angry + "\n" +
                "fun - " + fun + "\n" +
                "love - " + love + "\n");
    }

    public int getCommentAmmount() {
        return commentToArticle.size();
    }

    public void addComment(Comment comment) {
        commentToArticle.add(comment);
    }

    public void addgreat() {
        great++;
    }

    public void subgreat() {
        if (great > 0) {
            great--;
        }
    }

    public void addsad() {
        sad++;
    }

    public void subsad() {
        if (sad > 0) {
            sad--;
        }
    }

    public void addangry() {
        angry++;
    }

    public void subangry() {
        if (angry > 0) {
            angry--;
        }
    }

    public void addfun() {
        fun++;
    }

    public void subfun() {
        if (fun > 0) {
            fun--;
        }
    }

    public void addlove() {
        love++;
    }

    public void sublove() {
        if (love > 0) {
            love--;
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
            commentToArticle.get(i).commentSorting();
        }

    }

    public void titleUpdater(String title, String articleId) {
        if (articleId.equals(this.articleId)) {
            this.title = title;
        }

    }

    public void bodyUpdater(String body, String articleId) {
        if (articleId.equals(this.articleId)) {
            this.content = body;
        }
    }

    public void tagAdder(String tag, String articleId) {
        if (articleId.equals(this.articleId)) {
            this.tag = tag;
        }
    }

    public void addReaction(int type) {
        switch (type) {
            case 1:
                addgreat();
                break;
            case 2:
                addsad();
                break;
            case 3:
                addangry();
                break;
            case 4:
                addfun();
                break;
            case 5:
                addlove();
                break;
            default:
                break;
        }

    }

    public void subReaction(int type) {
        switch (type) {
            case 1:
                subgreat();
                break;
            case 2:
                subsad();
                break;
            case 3:
                subangry();
                break;
            case 4:
                subfun();
                break;
            case 5:
                sublove();
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
        if (!comment.getCommentCotent().equals("")) {
            commentToArticle.add(comment);
        }
    }

    public Comment getComment(int i) {
        return commentToArticle.get(i);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title, String articleId) {
        if (articleId.equals(this.articleId)) {
            if (!title.equals("")) {
                this.title = title;
            }
        }
    }

    public void setAuthor(String author, String articleId) {
        if (articleId.equals(this.articleId)) {
            if (!author.equals("")) {
                this.author = author;
            }
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content, String articleId) {
        if (articleId.equals(this.articleId)) {
            if (!content.equals("")) {
                this.content = content;
            }
        }
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
        if (tag.equals("")) {
            this.tag = tag;
        }
    }

    public void showComment() {
        //commentSorting();
        System.out.print(getAllComment());
    }

}
