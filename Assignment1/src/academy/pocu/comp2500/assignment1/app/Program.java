package src.academy.pocu.comp2500.assignment1.app;
import src.academy.pocu.comp2500.assignment1.*;

import javax.swing.text.html.HTMLEditorKit;
import java.util.*;
public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        while(true){
            int wantmenu;
            System.out.print("----------------블로그-----------------");
            System.out.print("   안녕하세요 원하는 기능을 골라주세요");
            System.out.print("            1)블로그 만들기");
            System.out.print("            2)블로그 글쓰기");
            System.out.print("            3)블로그 글 목록 불러오기 및 선택");
            System.out.print("            4)태그로 블로그글 필터링");
            System.out.print("            5)여러 정렬 방법으로 글 받아오기");
            System.out.print("            6)블로그 제목 수정");
            System.out.print("            7)글 수정하기");
            System.out.print("            8)(블로그 주인)글에 태그 달기");
            System.out.print("            9)글에 달린 댓글 불러오기");
            System.out.print("            10)댓글을 추천 비추천순으로 불러오기");
            System.out.print("            11)댓글에 대댓글 달기");
            System.out.print("            12)글에 리액션 달기");
            System.out.print("            13)댓글에 추천 비추천 하기");
            System.out.print("            14)시스템 종료");
            wantmenu = sc.nextInt();

            if(wantmenu == 1){
                String ID;
                System.out.print("호스트 ID를 입력해주세요");
                ID = sc.next();
                Blog new_1 = new Blog(ID);
            }

            else if(wantmenu == 2){

            }
        {


        Blog tem = new Blog("123");
        Article a = new Article("가나다라", "자바 과제 테스트","강동협");
        a.addComment("a의 댓글입니다");
        Comment temCom = new Comment("tem");
        temCom.AddSubComment("서브입니다.");
        temCom.AddSubComment("asdfasdfasdf");
        a.addComment(temCom);
        a.addComment("123");
        a.addComment("456");

        //System.out.print(temCom.getComment());


        Article c = new Article("asdfasdf" , "wwesdfs","Tim");
        Article b = new Article("마바사","자바 테스트","강동협");

        tem.postArtlcle(b,"123","업무");
        System.out.print("//////////////시간차 내기//////////////\n");
        int t = 0;
        t = sc.nextInt();
        tem.postArtlcle(a,"123","휴가");
        tem.postArtlcle(c,"123","휴가");

        tem.getArticle(1).getComment(1).GetSubComment(0).AddSubComment("서브의 서브입니다1");
        tem.getArticle(1).getComment(1).GetSubComment(0).AddSubComment("서브의 서브입니다2");
        tem.getArticle(1).getComment(1).GetSubComment(0).AddSubComment("서브의 서브입니다3");
        tem.getArticle(1).getComment(1).GetSubComment(0).AddSubComment("서브의 서브입니다4");
        tem.getArticle(1).getComment(1).GetSubComment(0).AddSubComment("서브의 서브입니다5");

        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).UpVoteToComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).UpVoteToComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).UpVoteToComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).UpVoteToComment();

        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(2).UpVoteToComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(2).UpVoteToComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(2).UpVoteToComment();

        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(4).UpVoteToComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(4).UpVoteToComment();

        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(1).UpVoteToComment();

        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).DownVoteComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).DownVoteComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).DownVoteComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).DownVoteComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).DownVoteComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).DownVoteComment();
        tem.getArticle(1).getComment(1).GetSubComment(0).GetSubComment(0).DownVoteComment();

        tem.showComment(1);

        System.out.print("\n\n\n\n\n");

        tem.getArticle(0).addGreat();
        tem.getArticle(0).addGreat();
        tem.getArticle(0).addGreat();

        tem.getArticle(0).addSad();
        tem.getArticle(0).addSad();

        tem.showReactionArticle(0);

        System.out.print("\n\n\n\n\n");
        tem.getArticle(0).subSad();
        tem.getArticle(0).subSad();
        tem.getArticle(0).subSad();
        tem.getArticle(0).subSad();

        tem.showReactionArticle(0);




        //tem.PostLoad();



         */




    }
}
