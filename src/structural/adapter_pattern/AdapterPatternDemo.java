// Below example is taken from tutorialpoints.com

interface MediaPlayer {
    void play(String audioType , String fileName ) ;
}

interface AdvancedMediaPlayer {
    void play(String fileName );
}

class VlcPlayer implements AdvancedMediaPlayer {
    public void play(String fileName ) {
        System.out.println("Playing vlc  file : " + fileName);
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    public void play (String fileName ) {
        System.out.println("Playing mp4 file :" + fileName);
    }
}
 
class MediaAdapter implements AdvancedMediaPlayer {
    protected AdvancedMediaPlayer advancedMediaPlayer ;
    
    public MediaAdapter (String audioType ) {
       if (audioType.equalsIgnoreCase ("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase ("mp4")) {
            advancedMediaPlayer  = new Mp4Player();
        }
    }

    @Override 
    public void play ( String fileName ) {
            advancedMediaPlayer.play(fileName);
    }
}

class AudioPlayer implements MediaPlayer {
    protected MediaAdapter mediaAdapter ;

     public void play(String audioType, String fileName ) {
        if (audioType.equalsIgnoreCase ("mp3")) {
           System.out.println("Playing mp3 file... " + fileName);
       } else if (audioType.equalsIgnoreCase ("vlc") || audioType.equalsIgnoreCase("mp4")) {
           new MediaAdapter(audioType).play(fileName); 
        }          
    }
}
           


public class AdapterPatternDemo {
    public static void main (String [] args) {

        AudioPlayer audioPlayer = new AudioPlayer ();
        audioPlayer.play("mp3", "song1");
        audioPlayer.play("vlc", "song2");
        audioPlayer.play("mp4", "song3");
    
    }
}





