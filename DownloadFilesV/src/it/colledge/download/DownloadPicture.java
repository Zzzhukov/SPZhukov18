package it.colledge.download;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*Класс реализует скачивание картинки по ссылке из интернета*/

public class DownloadPicture extends Thread{

    private static final String IN_FILE_TXT = "inFile.txt";
    private static final String OUT_FILE_TXT = "downloads\\outFilePicture.txt";
    private static String PathToPicture;

    @Override
    public void run() {
        System.out.println("Запуск скачивания картинки");
        readingFile();
        download();
    }

    private void readingFile(){
        //InFile содержит две строки:
        //[ССЫЛКА_НА_ФАЙЛ][ПРОБЕЛ][ПУТЬ_ДЛЯ_СОХРАНЕНИЯ]
        //в первой строке ссылка на изображение, во второй строке ссылка на mp3-файл.
        //DownloadPicture помещает считанные из файла строки в ArrayList<String>
        //И забирает из него условленную строку
        ArrayList<String> textInFile = new ArrayList<>();
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(OUT_FILE_TXT));
             BufferedReader inFile = new BufferedReader(new FileReader(IN_FILE_TXT))) {
            String line = " ";
            while (line != null) {
                line = inFile.readLine();
                textInFile.add(line);
            }
            //Здесь происходит разделение строки на ссылку и путь
            URL url = new URL(textInFile.get(0).substring(0, textInFile.get(0).indexOf(" ")));
            PathToPicture = textInFile.get(0).substring(textInFile.get(0).indexOf(" ")+1);
            String result;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                result = bufferedReader.lines().collect(Collectors.joining("\n"));
            }
            Pattern email_pattern = Pattern.compile("(?<=data-src ?= ?\")https?://\\S+(?:jpg|jpeg|png)");
            Matcher matcher = email_pattern.matcher(result);
            int i = 0;
            while (matcher.find() && i < 1) {
                outFile.write(matcher.group() + "\r");
                i++;
            }

        } catch (IOException e) {
            Main.errorMessage();
            e.printStackTrace();
        }
    }

    private void download(){
        try (BufferedReader musicFile = new BufferedReader(new FileReader(OUT_FILE_TXT))) {
            String music;
            int count = 0;
            try {
                while ((music = musicFile.readLine()) != null) {
                    downloadUsingNIO(music, PathToPicture + count + ".jpeg");
                    count++;
                }
            } catch (IOException e) {
                Main.errorMessage();
                e.printStackTrace();
            }
        } catch (IOException e) {
            Main.errorMessage();
            e.printStackTrace();
        }
    }
    protected static void downloadUsingNIO(String strUrl, String file) throws IOException {
        URL url = new URL(strUrl);
        ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
        FileOutputStream stream = new FileOutputStream(file);
        stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        stream.close();
        byteChannel.close();
    }
}
