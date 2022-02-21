package project.modules;

public class Seats {
    private String id;
    private String temp;

    public Seats(int i) {
        i = i+1;
        if (i <= 10) temp = "A"+i;
        else if (i <= 20) temp = "B"+(i-10);
        else if (i <= 30) temp = "C"+(i-20);
        else if (i <= 40) temp = "D"+(i-30);
        else if (i <= 50) temp = "E"+(i-40);
        else if (i <= 60) temp = "F"+(i-50);
        else if (i <= 70) temp = "G"+(i-60);
        else if (i <= 80) temp = "H"+(i-70);
        else if (i <= 90) temp = "J"+(i-80);
        else if (i <= 100) temp = "K"+(i-90);
        else if (i <= 110) temp = "L"+(i-100);

        this.id = temp;
    }

    public String getID() {
        return this.id;
    }
}
