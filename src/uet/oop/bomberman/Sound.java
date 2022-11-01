package uet.oop.bomberman;

import java.io.File;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
    private static AudioClip effect;
    private static MediaPlayer music;
    private static boolean effectOn = true;
    private static boolean musicOn = true;
    private static boolean isPlaying = false;

    public static boolean isPlaying() {
        return isPlaying;
    }

    public static void setPlaying(boolean isPlaying) {
        Sound.isPlaying = isPlaying;
    }

    public static boolean isEffectOn() {
        return effectOn;
    }

    public static void setEffectOn(boolean effect) {
        effectOn = effect;
    }

    public static boolean isMusicOn() {
        return musicOn;
    }

    public static void setMusicOn(boolean music) {
        musicOn = music;
    }

    public static void playEffect(String effectFile) {
        effect = new AudioClip(new File("res/sound/" + effectFile + ".wav").toURI().toString());
        effect.play();
    }

    public static void playMusic(String musicFile) {
        setPlaying(true);
        music = new MediaPlayer(new Media(new File("res/sound/" + musicFile + ".wav").toURI().toString()));
        music.play();
    }

    public static void stopMusic() {
        music.stop();
        setPlaying(false);
    }
}
