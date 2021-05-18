package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String mText;
    private int mDepth;
    private char mBulletStyle;
    private ArrayList<ListItem> mSubListItem = new ArrayList<>();

    public ListItem(String text) {
        mText = text;
        mBulletStyle = '*';
        mDepth = 0;
    }

    public ListItem(String text, char bulletStyle) {
        mText = text;
        mBulletStyle = bulletStyle;
        mDepth = 0;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public char getBulletStyle() {
        return mBulletStyle;
    }

    public void setBulletStyle(char a) {
        mBulletStyle = a;
    }

    public void removeSublistItem(int index) {
        mSubListItem.remove(index);
    }

    public void addSublistItem(ListItem subItem) {
        mSubListItem.add(subItem);

    }

    public ListItem getSublistItem(int index) {
        return mSubListItem.get(index);
    }

    public String toString() {
        mDepth = 0;
        StringBuilder sb_1 = new StringBuilder("");
        sb_1.append(mBulletStyle + " " + mText + System.lineSeparator());

        if (mSubListItem.size() != 0) {
            for (ListItem list : mSubListItem) {
                sb_1.append(list.toString(mDepth + 1));
            }
        }

        String answer = sb_1.toString();
        return answer;
    }

    public String toString(int a) {
        mDepth += a;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < mDepth; i++) {
            sb.append("    ");
        }
        sb.append(mBulletStyle + " " + mText + System.lineSeparator());
        if (mSubListItem.size() != 0) {
            for (ListItem list : mSubListItem) {
                sb.append(list.toString(mDepth + 1));
            }
        }

        String answer = sb.toString();
        return answer;
    }


}

