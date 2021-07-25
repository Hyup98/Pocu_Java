package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class Canvas {
    private int width;
    private int height;
    private ArrayList<Ascii> asciis = new ArrayList<>();

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

    public char getPil(int x, int y) {
        for(int i = 0 ; i < asciis.size() ; i++ ) {
            if(asciis.get(i).isThere(x,y)) {
                return asciis.get(i).getAscii();
            }
        }
        return ' ';
    }

    public void drawPixel(int x, int y, char ascii) {
        Ascii tem = new Ascii(x,y,ascii);
        asciis.add(tem);
    }

    public boolean increasePixel(int x, int y) {
        for(int i = 0; i < asciis.size(); i++) {
            if(asciis.get(i).isThere(x,y)) {
                return asciis.get(i).increasAscii();
            }
        }
        return false;
    }

    public boolean decreasePixel(int x , int y) {
        for(int i = 0 ; i < asciis.size();i++ ) {
            if(asciis.get(i).isThere(x,y)) {
                return asciis.get(i).decreasePixel();
            }
        }
        return false;
    }

    public void toUpper(int x, int y) {
        for(int i = 0 ; i<asciis.size(); i++) {
            if(asciis.get(i).isThere(x,y)) {
                asciis.get(i).toUpper();
                return;
            }
        }
    }

    public void toLower(int x, int y) {
        for(int i = 0; i < asciis.size(); i++) {
            if(asciis.get(i).isThere(x,y)) {
                asciis.get(i).toLower();
                return;
            }
        }
    }

    public void fillHorizontalLine(int y, char ascii) {
        for(int i = 0; i <width; i++ ) {
            Ascii tem = new Ascii(-width/2+i,y,ascii);
            asciis.add(tem);
        }
    }

    public void fillVerticalLine(int x, char ascii) {
        for(int i = 0; i <height; i++ ) {
            Ascii tem = new Ascii(-height/2+i,x,ascii);
            asciis.add(tem);
        }
    }

    public void clear() {
        asciis.clear();
    }

    public String getDrawing() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height+2 ; i ++) {
            for(int j = 0 ; j < width+2; j++) {
                if( i == 0 || i ==height + 1) {
                    if(j == 0 || j == width+1) {
                        sb.append('+');
                        continue;
                    }
                    sb.append('-');
                    continue;
                }
                if(j == 0 || j == width + 1) {
                    sb.append('|');
                    continue;
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        String result = sb.toString();
        return result;
    }



}
