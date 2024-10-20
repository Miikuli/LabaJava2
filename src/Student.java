public class Student {
    private String name;
    private int[] marks;

    public Student(String name, int... marks) {
        this.name = name;
        this.marks = marks.length > 0 ? marks : new int[0];
    }

    public int[] getMarks() {
        return marks;
    }

    public double averageMark() {
        if (marks.length == 0) return 0;
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum/marks.length;
    }

    public boolean isExellent() {
        if (marks.length == 0) return false;
        for (int mark : marks) {
            if (mark != 5) return false;
        }
        return true;
    }

    public void changeMark(int n, int newMark) {
        this.marks[n-1] = newMark;
    }

    public void changeAllMarks(int[] newMarks) {
        for (int i = 0; i < newMarks.length; i++) {
            this.marks[i] = newMarks[i];
        }
    }

    @Override
    public String toString() {
        String array_out = "";
        for (int i = 0; i < marks.length; i++) {
            array_out = array_out + " " + marks[i];
        }
        return name + ":" + array_out;
    }
}
