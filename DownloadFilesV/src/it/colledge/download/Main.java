package it.colledge.download;

/*Программа параллельно скачивает изображение и mp3-файл.
 * После скачивания mp3-файл воспроизводится программным способом.*/

import java.util.Scanner;

public class Main {

    private static boolean musicDownloaded = false;
    private static final String ERROR_MESSAGE = "При запуске появлялась ошибка";

    public static void main(String[] args) throws InterruptedException {
        @ThisIsThread(isThread = true) DownloadMusic downloadMusic = new DownloadMusic();
        @ThisIsThread(isThread = true) DownloadPicture downloadPicture = new DownloadPicture();
        downloadMusic.start();
        downloadPicture.start();
        while (!isMusicDownloaded()) {
            Thread.sleep(1);
        }
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Запустить ли скачанную музыку? да|нет");
            String onOrOff = scanner.next();
            if (onOrOff.equals("да")){
                @ThisIsThread(isThread = true) MP3Player mp3Player = new MP3Player();
                mp3Player.start();
                break;
            }
            else if (onOrOff.equals("нет")){
                break;
            }
            else {
                System.out.println("Ты ввёл что-то не то");
            }
        }
    }

    public static void setMusicDownloaded(boolean music) {
        musicDownloaded = music;
        System.out.println("Скачивание музыки завершилось");
    }

    public static boolean isMusicDownloaded() {
        return musicDownloaded;
    }
    public static void errorMessage(){
        System.out.println(ERROR_MESSAGE);
    }
}
