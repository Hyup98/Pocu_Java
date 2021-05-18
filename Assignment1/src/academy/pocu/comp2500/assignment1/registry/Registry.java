package src.academy.pocu.comp2500.assignment1.registry;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * DO NOT MODIFY. YOU DON'T HAVE TO!
 */
public class Registry {
    public static final String CREATE_BLOG = "CreateBlog";
    public static final String TAG_FILTER_SETTER = "TagFilterSetter";
    public static final String AUTHOR_FILTER_SETTER = "AuthorFilterSetter";
    public static final String POST_ORDER_SETTER = "PostOrderSetter";
    public static final String POST_LIST_GETTER = "PostListGetter";
    public static final String POST_ADDER = "PostAdder";
    public static final String POST_TITLE_UPDATER = "PostTitleUpdater";
    public static final String POST_BODY_UPDATER = "PostBodyUpdater";
    public static final String POST_TAG_ADDER = "PostTagAdder";
    public static final String COMMENT_ADDER = "CommentAdder";
    public static final String SUBCOMMENT_ADDER = "SubcommentAdder";
    public static final String COMMENT_UPDATER = "CommentUpdater";
    public static final String REACTION_ADDER = "ReactionAdder";
    public static final String REACTION_REMOVER = "ReactionRemover";
    public static final String COMMENT_UPVOTER = "CommentUpvoter";
    public static final String COMMENT_DOWNVOTER = "CommentDownvoter";
    public static final String COMMENT_LIST_GETTER = "CommentListGetter";
    public static final String SUBCOMMENT_LIST_GETTER = "SubcommentListGetter";
    public static final String SUBCOMMENT_UPDATER = "SubcommentUpdater";
    public static final String SUBCOMMENT_UPVOTER = "SubcommentUpvoter";
    public static final String SUBCOMMENT_DOWNVOTER = "SubcommentDownvoter";

    public static String ASSIGNMENT1_PACKAGE_NAME = "academy.pocu.comp2500.assignment1";
    protected static final int TOTAL_INTERFACES_COUNT = 21;

    protected HashMap<String, Interface> interfaces = new HashMap<>();

    public final HashMap<String, Interface> getInterfaces() {
        return this.interfaces;
    }

    public final void registerBlogCreator(final String className) {
        this.interfaces.put(CREATE_BLOG, new Interface(className));
    }

    public void registerTagFilterSetter(final String className, final String methodName) {
        this.interfaces.put(TAG_FILTER_SETTER, new Interface(className, methodName));
    }

    public final void registerAuthorFilterSetter(final String className, final String methodName) {
        this.interfaces.put(AUTHOR_FILTER_SETTER, new Interface(className, methodName));
    }

    public final void registerPostOrderSetter(final String className, final String methodName) {
        this.interfaces.put(POST_ORDER_SETTER, new Interface(className, methodName));
    }

    public final void registerPostListGetter(final String className, final String methodName) {
        this.interfaces.put(POST_LIST_GETTER, new Interface(className, methodName));
    }

    public final void registerPostAdder(final String className, final String methodName) {
        this.interfaces.put(POST_ADDER, new Interface(className, methodName));
    }

    public final void registerPostTitleUpdater(final String className, final String methodName) {
        this.interfaces.put(POST_TITLE_UPDATER, new Interface(className, methodName));
    }

    public final void registerPostBodyUpdater(final String className, final String methodName) {
        this.interfaces.put(POST_BODY_UPDATER, new Interface(className, methodName));
    }

    public final void registerPostTagAdder(final String className, final String methodName) {
        this.interfaces.put(POST_TAG_ADDER, new Interface(className, methodName));
    }

    public final void registerCommentAdder(final String className, final String methodName) {
        this.interfaces.put(COMMENT_ADDER, new Interface(className, methodName));
    }

    public final void registerSubcommentAdder(final String className, final String methodName) {
        this.interfaces.put(SUBCOMMENT_ADDER, new Interface(className, methodName));
    }

    public final void registerCommentUpdater(final String className, final String methodName) {
        this.interfaces.put(COMMENT_UPDATER, new Interface(className, methodName));
    }

    public final void registerSubcommentUpdater(final String className, final String methodName) {
        this.interfaces.put(SUBCOMMENT_UPDATER, new Interface(className, methodName));
    }

    public final void registerReactionAdder(final String className, final String methodName) {
        this.interfaces.put(REACTION_ADDER, new Interface(className, methodName));
    }

    public final void registerReactionRemover(final String className, final String methodName) {
        this.interfaces.put(REACTION_REMOVER, new Interface(className, methodName));
    }

    public final void registerCommentUpvoter(final String className, final String methodName) {
        this.interfaces.put(COMMENT_UPVOTER, new Interface(className, methodName));
    }

    public final void registerCommentDownvoter(final String className, final String methodName) {
        this.interfaces.put(COMMENT_DOWNVOTER, new Interface(className, methodName));
    }

    public final void registerCommentListGetter(final String className, final String methodName) {
        this.interfaces.put(COMMENT_LIST_GETTER, new Interface(className, methodName));
    }

    public final void registerSubcommentListGetter(final String className, final String methodName) {
        this.interfaces.put(SUBCOMMENT_LIST_GETTER, new Interface(className, methodName));
    }

    public final void registerSubcommentUpvoter(final String className, final String methodName) {
        this.interfaces.put(SUBCOMMENT_UPVOTER, new Interface(className, methodName));
    }

    public final void registerSubcommentDownvoter(final String className, final String methodName) {
        this.interfaces.put(SUBCOMMENT_DOWNVOTER, new Interface(className, methodName));
    }

    public void validate() {
        assertTrue(this.interfaces.size() >= TOTAL_INTERFACES_COUNT,
                "You did not register all required methods (%d / %d)",
                this.interfaces.size(),
                TOTAL_INTERFACES_COUNT);

        HashSet<String> visited = new HashSet<>();
        for (Map.Entry<String, Interface> entry : this.interfaces.entrySet()) {
            Interface aInterface = entry.getValue();
            String className = aInterface.getClassName();

            Class<?> aClass = getClassByNameOrNull(className);

            assertTrue(aClass != null, "Class %s is not found.", className);

            String methodName = aInterface.getMethodName();

            if (methodName != null) {
                ArrayList<Method> methods = getMethodsByName(aClass, methodName);

                assertTrue(methods.size() > 0,
                        "Method %s() not found in %s class.",
                        methodName,
                        className);
            }
        }
    }

    protected void assertTrue(boolean condition, String format, Object... args) {
        assert condition : String.format(format, args);
    }

    private final Class<?> getClassByNameOrNull(final String name) {
        try {
            String fullClassName = String.format("%s.%s", ASSIGNMENT1_PACKAGE_NAME, name);
            return Class.forName(fullClassName);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private final ArrayList<Method> getMethodsByName(final Class<?> aClass, final String methodName) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        ArrayList<Method> methods = new ArrayList<>();

        for (int i = 0; i < declaredMethods.length; ++i) {
            if (declaredMethods[i].getName().equals(methodName)) {
                methods.add(declaredMethods[i]);
            }
        }

        return methods;
    }
}
