package academy.pocu.comp2500.assignment4;

public class Ascii {
    private int x;
    private int y;
    private char ascii;

    public Ascii(int x, int y, char ascii) {
        this.x = x;
        this.y = y;
        this.ascii = ascii;
    }

    public char getAscii() {
        return ascii;
    }

    public boolean isThere(int x, int y) {
        if(this.x == x && this.y == y)
        {
            return true;
        }
        return false;
    }

    public boolean increasAscii() {
        if(ascii < 126) {
            ascii++;
            return true;
        }
        return false;
    }

    public boolean decreasePixel() {
        if(ascii > 32) {
            ascii--;
            return true;
        }
        return false;
    }

    public void toUpper() {
        if(ascii >= 97) {
            ascii -= 32;
        }
    }

    public void toLower() {
        if(ascii <= 90) {
            ascii += 32;
        }
    }
}
