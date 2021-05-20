package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Comment {
    String writerId;
    private int upVoteCount;
    private int downVoteCount;
    private String comment;
    private Comment ancestor;
    private ArrayList<Comment> CommentToComment = new ArrayList<Comment>();

    public void CommentSorting() {
        for (int i = 0; i < CommentToComment.size() - 1; i++) {
            for (int j = i + 1; j < CommentToComment.size(); j++) {
                if (CommentToComment.get(i).voteResult() < CommentToComment.get(j).voteResult()) {
                    Collections.swap(CommentToComment, i, j);
                }
            }
        }
        for (int i = 0; i < CommentToComment.size(); i++) {
            CommentToComment.get(i).CommentSorting();
        }
    }

    public Comment(String comment, String writerId) {
        this.writerId = writerId;
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

    public String getComment() {
        StringBuilder sb = new StringBuilder("");
        int depth = 1;
        Comment check = this.ancestor;
        while (true) {
            if (check == null) {
                break;
            }

            check = check.ancestor;
            depth++;
        }
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        sb.append("* " + comment + "\n");
        if (CommentToComment.size() != 0) {
            for (Comment subCom : CommentToComment)
                sb.append(subCom.getComment());
        }

        String answer = sb.toString();
        return answer;

    }

    public void setAncestor(Comment ancestor) {
        this.ancestor = ancestor;
    }

    public void addSubComment(String subComment, String writerId) {
        if (!subComment.equals("")) {
            Comment tem = new Comment(subComment, writerId);
            CommentToComment.add(tem);
            tem.setAncestor(this);
        }

    }

    public Comment getSubComment(int index) {
        return CommentToComment.get(index);
    }

    public void setComment(String comment, String writerId) {
        if (writerId.equals(this.writerId)) {
            if (!comment.equals("")) {
                this.comment = comment;
            }
        }
    }

    public String getWriterId() {
        return writerId;
    }


    public void changeSubcomment(int index, String writerId, String comment) {
        if (CommentToComment.get(index).getWriterId().equals(writerId)) {
            CommentToComment.get(index).setComment(comment, writerId);
        }
    }


}
