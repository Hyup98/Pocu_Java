package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;


public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");
        registry.registerBlogCreator("Blog");// 블로그를 생성하는 생성자를 등록한다.
        registry.registerTagFilterSetter("Blog", "filteringByTag");// 태그 필터를 설정하는 메서드를 등록한다.
        registry.registerAuthorFilterSetter("Blog", "filteringByAuthor");// 작성자 필터를 설정하는 메서드를 등록한다.
        registry.registerPostOrderSetter("Blog", "setSrotingType");// 블로그 글의 정렬 방법을 설정하는 메서드를 등록한다.
        registry.registerPostListGetter("Blog", "getArticleList");// 블로그 글 목록을 가져오는 메서드를 등록한다.
        registry.registerPostAdder("Blog", "postArticle");// 블로그에 글을 추가하는 메서드를 등록한다.
        registry.registerPostTitleUpdater("Article", "titleUpdater");// 발행된 블로그 글의 제목을 바꾸는 메서드를 등록한다.
        registry.registerPostBodyUpdater("Article", "bodyUpdater");//발행된 블로그 글의 본문을 바꾸는 메서드를 등록한다.
        registry.registerPostTagAdder("Article", "tagAdder");//블로그 글에 태그를 추가하는 메서드를 등록한다.
        registry.registerCommentAdder("Article", "addComment");// 블로그 글에 댓글을 추가하는 메서드를 등록한다.
        registry.registerSubcommentAdder("Comment", "addSubComment");// 댓글에 하위 댓글을 추가하는 메서드를 등록한다.
        registry.registerCommentUpdater("Comment", "changeComment");// 댓글의 내용을 바꾸는 메서드를 등록한다.
        registry.registerSubcommentUpdater("Comment", "changeComment");//하위 댓글의 내용을 바꾸는 메서드를 등록한다
        registry.registerReactionAdder("Article", "addReaction");// 블로그 글에 리액션을 추가하는 메서드를 등록한다.
        registry.registerReactionRemover("Article", "subReaction");// 블로그 글로부터 리액션을 제거하는 메서드를 등록한다.
        registry.registerCommentUpvoter("Comment", "upVoteToComment");// 댓글을 추천하는 메서드를 등록한다.
        registry.registerCommentDownvoter("Comment", "downVoteToComment");// 댓글을 비추천하는 메서드를 등록한다.
        registry.registerCommentListGetter("Article", "getAllComment");// 블로그 글에 달린 댓글들을 가져오는 메서드를 등록한다.
        registry.registerSubcommentListGetter("Comment", "getSubComment");// 댓글에 달린 하위 댓글들을 가져오는 메서드를 등록한다.
        registry.registerSubcommentUpvoter("Comment", "upVoteToComment");// 하위 댓글을 추천하는 메서드를 등록한다.
        registry.registerSubcommentDownvoter("Comment", "downVoteToComment");// 하위 댓글을 비추천하는 메서드를 등록한다.

    }
}
