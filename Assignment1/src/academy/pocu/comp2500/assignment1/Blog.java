package academy.pocu.comp2500.assignment1;

import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.stream.StreamSupport;

public class Blog {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Article> articles;
    private String blogId;

    public Blog(String blogId) {
        this.blogId = blogId;
        articles = new ArrayList<Article>();
    }

    public void postArticle(Article article, String blogId) {

        if (blogId.equals(this.blogId)) {

            if (!article.getTitle().equals("")) {

                if (!article.getContent().equals("")) {
                    article.setCreatedDateTime();
                    articles.add(article);
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

    public void postArticle(Article article, String blogId, String tag) {

        if (blogId.equals(this.blogId)) {

            if (!article.getTitle().equals("")) {

                if (!article.getContent().equals("")) {
                    if (!tag.equals("")) {
                        article.setCreatedDateTime();
                        article.setTag(tag);
                        articles.add(article);
                    }
                } else {
                    System.out.print("내용이 없습니다");
                }
            } else {
                System.out.print("제목이 없습니다.");
            }
        } else {
            System.out.print("블로그 호스트만 글을 작성할 수 있습니다.");
        }
    }

    public void postTitleUpdater(String blogId,int index,String title) {

        if (blogId.equals(this.blogId)) {

            if (!title.equals("")) {
                articles.get(index).setTitle(title);
                articles.get(index).setModifiedDateTime();
            }
            else {
                System.out.print("바꾸고 싶은 문자열이 비어있습니다.");
            }
        } else {
            System.out.print("블로그 주인만 제목을 수정할 수 있습니다.");
        }
    }

    public void PostBodyUpdater(String blogId, String newBody,int index) {
        if (blogId.equals(this.blogId)) {
            if (!newBody.equals("")) {
                articles.get(index).setModifiedDateTime();
                articles.get(index).setContent(newBody);
            } else {
                System.out.print("바꿀 내용이 비어있습니다.");
            }
        }
        else {
            System.out.print("블로그 주인만 글을 수정할 수 있습니다.");
        }
    }

    public void PostTagAdder(String blogId, String tag, int index){
        if(blogId.equals(this.blogId)){
            if(!tag.equals("")){
                articles.get(index).tagging(tag);
            }
            else{
                System.out.print("널문자 입니다.");
            }
        }
        else{
            System.out.print("블로그 주인만 테그를 추가할 수 있습니다.");
        }
    }

    public void filteringByAuthor(String author){
        int tem =1;
        System.out.print("**********<블로그 글>**********\n");
        for (int i = 0;i< articles.size();i++){
            if(articles.get(i).getAuthor().equals(author)){
                System.out.print(tem+") " + articles.get(i).getTitle() + "\n");
                tem++;
            }
        }

    }

    public void filteringByTag(String tag){
        int tem =1;
        System.out.print("**********<블로그 글>**********\n");
        for (int i = 0;i< articles.size();i++){
            if(articles.get(i).getTag().equals(tag)){
                System.out.print(tem+") " + articles.get(i).getTitle() +"\n");
                tem++;
            }
        }

    }

    public void sortAscendingByCreatDate(){
        for(int i = 0;i < articles.size() - 1;i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if(articles.get(i).getCreatedDateTime().isAfter(articles.get(j).getCreatedDateTime())){
                    Collections.swap(articles,i , j);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for(int i = 0;i<articles.size(); i++){
            System.out.print((i+1) +") "+articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }
    }

    public void sortAscendingByModifiedDate(){
        for(int i = 0;i < articles.size() - 1;i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if(articles.get(i).getModifiedDateTime().isAfter(articles.get(j).getModifiedDateTime())){
                    Collections.swap(articles,i , j);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for(int i = 0;i<articles.size(); i++){
            System.out.print((i+1) +") "+articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }
    }

    public void sortAscendingByTitle(){
        for(int i = 0;i < articles.size() - 1;i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if(articles.get(i).getTitle().compareTo(articles.get(j).getTitle()) > 0){
                    Collections.swap(articles,i , j);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for(int i = 0;i<articles.size(); i++){
            System.out.print((i+1) +") "+articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }
    }

    public void sortDescendingByCreatDate(){
        for(int i = 0;i < articles.size() - 1;i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if(articles.get(i).getCreatedDateTime().isBefore(articles.get(j).getCreatedDateTime())){
                    Collections.swap(articles,i , i);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for(int i = 0;i<articles.size(); i++){
            System.out.print((i+1) +") "+articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }

    }

    public void sortDescendingByModifiedDate(){
        for(int i = 0;i < articles.size() - 1;i++) {
            for (int j = i + 1; j < articles.size(); j++) {
                if(articles.get(i).getModifiedDateTime().isBefore(articles.get(j).getModifiedDateTime())){
                    Collections.swap(articles,i , i);
                }
            }
        }
        System.out.print("**********<블로그 글>**********\n");

        for(int i = 0;i<articles.size(); i++){
            System.out.print((i+1) +") "+articles.get(i).getTitle() + "\n");
            System.out.print(articles.get(i).getCreatedDateTime() + "\n");
        }

    }

    public void postLoad(){
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

    public void commentAdder(int index, String comment,String writeId){
        articles.get(index).addComment(comment,writeId);
    }

    public void showComment(int index){
        articles.get(index).commentSorting();
        System.out.print(articles.get(index).getContent() + "\n");
        String answer = articles.get(index).getComment();
        System.out.print(answer);
    }

    public void showReactionArticle(int index){
        articles.get(index).showReaction();
    }

    public Article getArticle(int index){
        return articles.get(index);
    }

    public void addReactionToArticle(int type,int index){
        switch (type){
            case 1:
                articles.get(index).addGreat();
                break;
            case 2:
                articles.get(index).addSad();
                break;
            case 3:
                articles.get(index).addAngry();
                break;
            case 4:
                articles.get(index).addFun();
                break;
            case 5:
                articles.get(index).addLove();
                break;
            default:
                break;
        }
    }

    public void subReactionToArticle(int type,int index){
        switch (type){
            case 1:
                articles.get(index).subGreat();
                break;
            case 2:
                articles.get(index).subSad();
                break;
            case 3:
                articles.get(index).subAngry();
                break;
            case 4:
                articles.get(index).subFun();
                break;
            case 5:
                articles.get(index).subLove();
                break;
            default:
                break;
        }
    }
}





















































