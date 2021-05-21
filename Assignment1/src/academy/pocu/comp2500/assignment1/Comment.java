package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Comment {
    private int upVoteCount;
    private int downVoteCount;
    private String comment;
    private Comment ancestor;
    private ArrayList<Comment> commentToComment = new ArrayList<Comment>();

    public void CommentSorting() {
        for (int i = 0; i < commentToComment.size() - 1; i++) {
            for (int j = i + 1; j < commentToComment.size(); j++) {
                if (commentToComment.get(i).voteResult() < commentToComment.get(j).voteResult()) {
                    Collections.swap(commentToComment, i, j);
                }
            }
        }
        for (int i = 0; i < commentToComment.size(); i++) {
            commentToComment.get(i).CommentSorting();
        }
    }

    public Comment(String comment) {
        this.comment = comment;
        upVoteCount = 0;
        downVoteCount = 0;
    }

    public void upVoteToComment() {
        upVoteCount++;
    }

    public void downVoteToComment() {
        downVoteCount++;
    }

    public int voteResult() {
        return (upVoteCount - downVoteCount);
    }

    public String getSubComment() {
        StringBuilder sb = new StringBuilder("");

        for (Comment tem : commentToComment) {
            sb.append(tem.getComment() + "\n");
        }
        String answer = sb.toString();
        return answer;

    }

    public String getComment() {
        return comment;
    }

    public void setAncestor(Comment ancestor) {
        this.ancestor = ancestor;
    }

    public void addSubComment(String subComment) {
        if (!subComment.equals("")) {
            Comment tem = new Comment(subComment);
            commentToComment.add(tem);
            tem.setAncestor(this);
        }

    }

    public Comment getSubComment(int i) {
        return commentToComment.get(i);
    }

    public void setComment(String comment) {
        if (!comment.equals("")) {
            this.comment = comment;
        }
    }

    public void showSubComment() {
        System.out.print("* " + comment + "\n");
        for (int i = 0; i < commentToComment.size(); i++) {
            System.out.print("   * " + commentToComment.get(i).getComment() + "\n");
        }
    }

    public void changeComment(String comment) {
        this.comment = comment;
    }


}
