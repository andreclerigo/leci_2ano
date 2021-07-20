package aula7;

public class Hour implements Comparable<Hour>{
    private int hour, minutes;
    private final int totalMinutes;

    public Hour(String s) {
        String[] hours = s.split(":");
        hour = Integer.parseInt(hours[0].trim());
        minutes = Integer.parseInt(hours[1].trim());
        totalMinutes = hour * 60 + minutes;
    }

    public Hour(int total) {
        hour = total/60;
        minutes = total%60;
        totalMinutes = hour * 60 + minutes;
    }

    public Hour() {
        hour = 0;
        minutes = 0;
        totalMinutes = hour * 60 + minutes;
    }

    public int getHour() {
        return totalMinutes/60;
    }

    public int getMinutes() {
        return totalMinutes%60;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public static Hour estimatedHour(String h1, String h2) {
        Hour hour1 = new Hour(h1);
        Hour hour2 = new Hour(h2);
        int horaPrevistaMinutes = hour1.totalMinutes + hour2.totalMinutes;
        Hour horaPrevista = new Hour(horaPrevistaMinutes);
        return horaPrevista;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", getHour(), getMinutes());
    }
    
    @Override
    public int compareTo(Hour h) {
        return this.getTotalMinutes() - h.getTotalMinutes();
    }
}