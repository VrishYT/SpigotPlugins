package com.vrish.grapple;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {

    private static Plugin plugin = main.getPlugin(main.class);

    public static File dataFolder;
    public static File saveTo;
    public static FileWriter fw;
    public static PrintWriter pw;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy , HH:mm:ss");

    public static void logToFile(String message) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = sdf.format(timestamp);

        message = ("[" + time + "]" + message);

        try
        {
            dataFolder = plugin.getDataFolder();
            if(!dataFolder.exists())
            {
                dataFolder.mkdir();
            }

            saveTo = new File(dataFolder, "grapple.log");
            if (!saveTo.exists())
            {
                saveTo.createNewFile();
            }


            fw = new FileWriter(saveTo, true);

            pw = new PrintWriter(fw);

            pw.println(message);

            pw.flush();

            pw.close();

        } catch (IOException e)
        {

            e.printStackTrace();

        }

    }

}
