package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String Text;
    private int Depth;
    private char BulletStyle;
    private ListItem Ancestor;
    private ArrayList<ListItem> mSubListItem = new ArrayList<>();

    public ListItem(String text) {
        Text = text;
        BulletStyle = '*';
        Depth = 0;
        Ancestor = null;
    }

    public ListItem(String text, char bulletStyle) {
        Text = text;
        BulletStyle = bulletStyle;
        Depth = 0;
        Ancestor = null;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public char getBulletStyle() {
        return BulletStyle;
    }

    public void setBulletStyle(char a) {
        BulletStyle = a;
    }

    public void removeSublistItem(int index) {
        mSubListItem.remove(index);
    }

    public void addSublistItem(ListItem subItem) {
        mSubListItem.add(subItem);
        subItem.Ancestor = this;

    }

    public ListItem getSublistItem(int index) {
        return mSubListItem.get(index);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("");
        int Depth = 1;
        ListItem check = this.Ancestor;
        while(true){
            if(check == null){
                break;
            }
            check = check.Ancestor;
            Depth++;
        }


        for (int i = 0; i < Depth; i++) {
            sb.append("    ");
        }
        sb.append(BulletStyle + " " + Text + System.lineSeparator());
        if (mSubListItem.size() != 0) {
            for (ListItem list : mSubListItem) {
                sb.append(list.toString());
            }
        }

        String answer = sb.toString();
        return answer;
    }


}

