package uet.oop.bomberman;

import java.io.File;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
    private static AudioClip effect;
    private static Media media;
    private static MediaPlayer music;
    private static boolean effectOn = true;
    private static boolean musicOn = true;

    public static boolean isEffectOn() {
        return effectOn;
    }

    public static void setEffectOn(boolean effect) {
        effectOn = effect;
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public void setMusicOn(boolean music) {
        musicOn = music;
    }

    public static void playEffect(String effectFile) {
        effect = new AudioClip(new File("res/sound/" + effectFile + ".wav").toURI().toString());
        effect.play();
    }

    public static void playMusic(String musicFile) {

    }
}
