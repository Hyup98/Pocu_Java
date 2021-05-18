package src.academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Article> articles;
    private String hostID;

    public Blog(String hostId) {
        this.hostID = hostId;
    }

    public int articleFindtotitle(String title) {
        int answer = -1;
        for (int i = 0; i < articles.size(); i++)
        {
            if(articles.get(i).title.equals(title)){
                answer = i;
                break;
            }
        }
        return answer;
    }

    public void PostArticle(Article article, String hostID) {

        if (hostID.equals(this.hostID)) {

            if (!article.title.equals("")) {

                if (!article.content.equals("")) {
                    if(articleFindtotitle(article.title) == -1)
                    {
                        articles.add(article);
                    }
                    else{
                        System.out.print("중복되는 이름이 존재합니다.");
                    }

                }

                else {
                    System.out.print("내용이 없습니다");
                }

            }
            else {
                System.out.print("제목이 없습니다.");
            }
        }
        else {
            System.out.print("블로그 호스트만 글을 작성할 수 있습니다.");
        }
    }

    public void PostTitleUpdater(String hostID, String title) {

        if (hostID.equals(this.hostID)) {

            if (title.equals("")) {

                if (articleFindtotitle(title) != -1) {
                    int temIndex = articleFindtotitle(title);
                    articles.get(temIndex).title = title;
                } else {
                    System.out.print("일치하는 제목이 없습니다.");
                }
            } else {
                System.out.print("바꾸고 싶은 문자열이 비어있습니다.");
            }
        } else {
            System.out.print("블로그 주인만 제목을 수정할 수 있습니다.");
        }
    }

    public void registerPostBodyUpdater(String hostID, String newBody, String title) {
        if (hostID.equals(this.hostID)) {
            if (!newBody.equals("")) {
                if (articleFindtotitle(title) != -1) {
                    int temIndex = articleFindtotitle(title);
                    articles.get(temIndex).content = newBody;
                }
                else {
                    System.out.print("일치하는 제목이 없습니다.");
                }
            }
            else {
                System.out.print("바꿀 내용이 비어있습니다.");
            }
        }

        else {
            System.out.print("블로그 주인만 글을 수정할 수 있습니다.");
        }
    }

    public void PostTagAdder(String hostID, String tag, String title){
        if(hostID.equals(this.hostID)){
            if(tag.equals("")){
                if(articleFindtotitle(title) != -1){
                    articles.get(articleFindtotitle(title)).Tag = tag;
                }
                else{
                    System.out.print("제목이 존재하지 않습니다.");
                }

            }
            else{
                System.out.print("널문자 입니다.");
            }

        }

        else{
            System.out.print("블로그 주인만 테그를 추가할 수 있습니다.");
        }
    }





}
