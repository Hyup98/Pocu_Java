package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private int depth;
    private char bulletStyle;
    private ListItem ancestor;
    private ArrayList<ListItem> subListItem = new ArrayList<>();

    public ListItem(String text) {
        this.text = text;
        bulletStyle = '*';
        depth = 0;
        ancestor = null;
    }

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
        depth = 0;
        ancestor = null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return bulletStyle;
    }

    public void setBulletStyle(char a) {
        bulletStyle = a;
    }

    public void removeSublistItem(int index) {
        subListItem.remove(index);
    }

    public void addSublistItem(ListItem subItem) {
        subListItem.add(subItem);
        subItem.ancestor = this;

    }

    public ListItem getSublistItem(int index) {
        return subListItem.get(index);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("");
        int depth = 0;
        ListItem check = this.ancestor;
        while (true) {
            if (check == null) {
                break;
            }
            if (check.text.equals((""))) {
                break;
            }
            check = check.ancestor;
            depth++;
        }
        for (int i = 0; i < depth; i++) {
            sb.append("    ");
        }
        sb.append(bulletStyle + " " + text + System.lineSeparator());
        if (subListItem.size() != 0) {
            for (ListItem list : subListItem) {
                sb.append(list.toString());
            }
        }

        String answer = sb.toString();
        return answer;
    }


}

