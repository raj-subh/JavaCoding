package JavaOOPs;

class MusicApp {
    int songNo;
    String songName;

    // method overloading is defined
    public void playSong(int songNo, String songName) {
        this.songNo = songNo;
        this.songName = songName;
        System.out.println("Song No: " + songNo + " and Song Name is: " + songName + " is playing now.");
    }

    // order of arguments may differ
    public void playSong(String songName, int songNo) {
        this.songNo = songNo;
        this.songName = songName;
        System.out.println("Song No: " + songNo + " and Song Name is: " + songName + " is playing now.");
    }
}

public class Overloading {
    public static void main(String[] args) {

        MusicApp musicApp = new MusicApp();

        musicApp.playSong(1, "Raanjhan");
        musicApp.playSong("Nayan", 2);
    }
}
