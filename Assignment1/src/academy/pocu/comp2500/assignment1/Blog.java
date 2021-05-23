package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blog {
    private ArrayList<Article> articles = new ArrayList<>();
    private int printType;
    private String blogId;

    public Blog(String blogId) {
        this.blogId = blogId;
        printType = 0;
    }

    public void postArticle(Article article) {
        if (article != null) {
            if (!article.getTitle().equals("")) {
                if (!article.getContent().equals("")) {
                    if (!article.getAuthor().equals("")) {
                        article.setCreatedDateTime();
                        articles.add(article);
                    }
                }
            }
        }
    }

    /*
    public void postTitleUpdater(Article wantChange,String ) {
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

     */

    public void filteringByAuthor(String author) {
        int tem = 1;
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getAuthor().equals(author)) {
                System.out.print(tem + ") " + articles.get(i).getTitle() + "\n");
                tem++;
            }
        }

    }

    public void filteringByTag(String tag) {
        int tem = 1;
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTag().equals(tag)) {
                System.out.print(tem + ") " + articles.get(i).getTitle() + "\n");
                tem++;
            }
        }

    }

    public void sortAscendingByCreatDate() {
        printType = 1;
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getCreatedDateTime().isAfter(articles.get(j).getCreatedDateTime())) {
                    Collections.swap(articles, i, j);
                }
            }
        }
    }

    public void sortAscendingByModifiedDate() {
        printType = 1;
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getModifiedDateTime().isAfter(articles.get(j).getModifiedDateTime())) {
                    Collections.swap(articles, i, j);
                }
            }
        }
    }

    public void sortAscendingByTitle() {
        printType = 1;
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getTitle().compareTo(articles.get(j).getTitle()) > 0) {
                    Collections.swap(articles, i, j);
                }
            }
        }
    }

    public void sortDescendingByCreatDate() {
        printType = 1;
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getCreatedDateTime().isBefore(articles.get(j).getCreatedDateTime())) {
                    Collections.swap(articles, i, j);
                }
            }
        }
    }

    public void sortDescendingByModifiedDate() {
        printType = 1;
        for (int i = 0; i < articles.size() - 1; i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if (articles.get(i).getModifiedDateTime().isBefore(articles.get(j).getModifiedDateTime())) {
                    Collections.swap(articles, i, j);
                }
            }
        }
        /*
        for (int i = 0; i < articles.size(); i++) {
            System.out.print((i + 1) + ") " + articles.get(i).getTitle() + "\n");
        }
         */
    }

    public void setSrotingType() {

        Scanner sc = new Scanner(System.in);

        //시간 순으로 불러오기
        //지금은 사전순으로 불러온다
        System.out.print("글 정렬 방법을 설정해 주세요\n");
        System.out.print("1.작성 일시 내림차순\n" + "2.작성 일시 오름차순\n" + "3.수정 일시 내림차순\n" + "4.수정 일시 오름차순\n" + "5.제목(사전 순서) 오름차순\n" + "6.태크로 필터링 하기\n" + "7.글 작성자로 필터링하기\n");

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

    public void showArticle() {
        System.out.print(getArticleList());
    }

    public String getArticleList() {
        StringBuilder sb = new StringBuilder("");

        if (printType == 0) {
            sortAscendingByCreatDate();
        }

        if (articles.size() != 0) {
            for (int i = 0; i < articles.size(); i++) {
                sb.append("   * " + articles.get(i).getTitle() + "\n");
            }
        }
        String answer = sb.toString();
        return answer;

    }

    public void showArticleAndComment() {
        for (int i = 0; i < articles.size(); i++) {
            System.out.print("* " + articles.get(i).getTitle() + "\n");
            articles.get(i).showComment();
        }
    }

    public Article getArticle(int i) {
        return articles.get(i);
    }
}





















































