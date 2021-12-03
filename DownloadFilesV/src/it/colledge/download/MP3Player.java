package it.colledge.download;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.IOException;

/*Данный класс реализует запуск mp3-файла*/

public class MP3Player extends Thread{

    @Override
    public void run() {
        try (FileInputStream inputStream = new FileInputStream("downloads\\music0.mp3")) {
            try {
                System.out.println("Воспроизведение музыки...");
                Player player = new Player(inputStream);
                player.play();
                System.out.println("Ваша песенка спета");
            } catch (JavaLayerException e) {
                Main.errorMessage();
                e.printStackTrace();
            }
        } catch (IOException e) {
            Main.errorMessage();
            e.printStackTrace();
        }
    }
}
