package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blog {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Article> articles;

    public Blog() {
        articles = new ArrayList<Article>();
    }

    public void postArticle(Article article) {
        if (!article.getTitle().equals("")) {

            if (!article.getContent().equals("")) {
                article.setCreatedDateTime();
                articles.add(article);
            } else {
                System.out.print("내용이 없습니다");
            }
        } else {
            System.out.print("제목이 없습니다.");
        }
    }

    public void postTitleUpdater(int i, String title) {
        if (!title.equals("")) {
            articles.get(i).setTitle(title);
            articles.get(i).setModifiedDateTime();
        } else {
            System.out.print("바꾸고 싶은 문자열이 비어있습니다.");
        }
    }

    public void PostBodyUpdater(String newBody, int i) {
        if (!newBody.equals("")) {
            articles.get(i).setModifiedDateTime();
            articles.get(i).setContent(newBody);
        } else {
            System.out.print("바꿀 내용이 비어있습니다.");
        }
    }

    public void PostTagAdder(String tag, int i) {
        if (!tag.equals("")) {
            articles.get(i).tagging(tag);
        } else {
            System.out.print("널문자 입니다.");
        }
    }

    public void filteringByAuthor(String author) {
        int tem = 1;
        System.out.print("**********<블로그 글>**********\n");
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getAuthor().equals(author)) {
                System.out.print(tem + ") " + articles.get(i).getTitle() + "\n");
                tem++;
            }
        }

    }

    public void filteringByTag(String tag) {
        int tem = 1;
        System.out.print("**********<블로그 글>**********\n");
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTag().equals(tag)) {
                System.out.print(tem + ") " + articles.get(i).getTitle() + "\n");
                tem++;
            }
        }

    }

    public void sortAscendingByCreatDate() {
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getCreatedDateTime().isAfter(articles.get(j).getCreatedDateTime())) {
                    Collections.swap(articles, i, j);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for (int i = 0; i < articles.size(); i++) {
            System.out.print((i + 1) + ") " + articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }
    }

    public void sortAscendingByModifiedDate() {
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getModifiedDateTime().isAfter(articles.get(j).getModifiedDateTime())) {
                    Collections.swap(articles, i, j);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for (int i = 0; i < articles.size(); i++) {
            System.out.print((i + 1) + ") " + articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }
    }

    public void sortAscendingByTitle() {
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getTitle().compareTo(articles.get(j).getTitle()) > 0) {
                    Collections.swap(articles, i, j);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for (int i = 0; i < articles.size(); i++) {
            System.out.print((i + 1) + ") " + articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }
    }

    public void sortDescendingByCreatDate() {
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getCreatedDateTime().isBefore(articles.get(j).getCreatedDateTime())) {
                    Collections.swap(articles, i, i);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for (int i = 0; i < articles.size(); i++) {
            System.out.print((i + 1) + ") " + articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }

    }

    public void sortDescendingByModifiedDate() {
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getModifiedDateTime().isBefore(articles.get(j).getModifiedDateTime())) {
                    Collections.swap(articles, i, i);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for (int i = 0; i < articles.size(); i++) {
            System.out.print((i + 1) + ") " + articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }

    }

    public void postLoad() {
        Scanner sc = new Scanner(System.in);

        //시간 순으로 불러오기
        //지금은 사전순으로 불러온다
        System.out.print("글 정렬 방법을 설정해 주세요\n");
        System.out.print("1.작성 일시 내림차순\n" +
                "2.작성 일시 오름차순\n" +
                "3.수정 일시 내림차순\n" +
                "4.수정 일시 오름차순\n" +
                "5.제목(사전 순서) 오름차순\n" +
                "6.태크로 필터링 하기\n" +
                "7.글 작성자로 필터링하기\n");

        int type = sc.nextInt();
        switch (type) {
            case 1:
                sortDescendingByCreatDate();
                break;
            case 2:
                sortAscendingByCreatDate();
                break;
            case 3:
                sortDescendingByModifiedDate();
                break;
            case 4:
                sortAscendingByModifiedDate();
                break;
            case 5:
                sortAscendingByTitle();
                break;
            case 6:
                System.out.print("태그를 입력해주세요\n");
                String temTag = sc.next();
                filteringByTag(temTag);
                break;
            case 7:
                System.out.print("작성자를 입력해주세요\n");
                String temAuthor = sc.next();
                filteringByAuthor(temAuthor);
                break;
        }

    }

    public void commentAdder(int i, String comment) {
        articles.get(i).addComment(comment);
    }


    public void showArticle() {
        for (Article tem : articles) {
            System.out.print("* " + tem.getContent() + "\n");
        }
    }

    public void showArticleAndComment() {
        for (int i = 0; i < articles.size(); i++) {
            System.out.print("* " + articles.get(i).getContent() + "\n");
            articles.get(i).showComment();
        }
    }

    public Article getArticle(int i) {
        return articles.get(i);
    }

    public void addReactionToArticle(int type, int i) {
        switch (type) {
            case 1:
                articles.get(i).addGreat();
                break;
            case 2:
                articles.get(i).addSad();
                break;
            case 3:
                articles.get(i).addAngry();
                break;
            case 4:
                articles.get(i).addFun();
                break;
            case 5:
                articles.get(i).addLove();
                break;
            default:
                break;
        }
    }

    public void subReactionToArticle(int type, int i) {
        switch (type) {
            case 1:
                articles.get(i).subGreat();
                break;
            case 2:
                articles.get(i).subSad();
                break;
            case 3:
                articles.get(i).subAngry();
                break;
            case 4:
                articles.get(i).subFun();
                break;
            case 5:
                articles.get(i).subLove();
                break;
            default:
                break;
        }
    }
}





















































