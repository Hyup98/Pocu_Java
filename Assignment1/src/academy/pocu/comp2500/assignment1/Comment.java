package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Comment {
    private String commentId;
    private int upVoteCount;
    private int downVoteCount;
    private String comment;
    private Comment ancestor;
    private ArrayList<Comment> commentToComment = new ArrayList<>();

    public Comment(String comment, String commentId) {
        if (!comment.equals("")) {
            if (!commentId.equals("")) {
                this.comment = comment;
                this.commentId = commentId;
                upVoteCount = 0;
                downVoteCount = 0;
            }
        }
    }

    public void commentSorting() {
        for (int i = 0; i < commentToComment.size() - 1; i++) {
            for (int j = i + 1; j < commentToComment.size(); j++) {
                if (commentToComment.get(i).voteResult() < commentToComment.get(j).voteResult()) {
                    Collections.swap(commentToComment, i, j);
                }
            }
        }
        for (int i = 0; i < commentToComment.size(); i++) {
            commentToComment.get(i).commentSorting();
        }
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

    public String getCommentCotent() {
        return comment;
    }

    public void setAncestor(Comment ancestor) {
        this.ancestor = ancestor;
    }

    public void addSubComment(Comment comment) {
        commentToComment.add(comment);
        comment.setAncestor(this);

    }

    public Comment getComment(int i) {
        return commentToComment.get(i);
    }

    public void setComment(String comment, String commentId) {
        if (commentId.equals(this.commentId)) {
            if (!comment.equals("")) {
                this.comment = comment;
            }
        }
    }

    public void showSubComment() {
        System.out.print(getSubComment());
    }

    public String getSubComment() {
        StringBuilder sb = new StringBuilder("");
        if (commentToComment.size() != 0) {
            for (int i = 0; i < commentToComment.size(); i++) {
                sb.append("   * " + commentToComment.get(i).getCommentCotent() + "\n");
            }
        }
        String answer = sb.toString();
        return answer;

    }

    public void changeComment(String comment, String commentId) {
        if (commentId.equals(this.commentId)) {
            if (comment.equals("")) {
                this.comment = comment;
            }
        }
    }


}
