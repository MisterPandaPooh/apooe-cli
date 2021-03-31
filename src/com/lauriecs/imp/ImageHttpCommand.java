package com.lauriecs.imp;
import com.lauriecs.exceptions.CommandException;
import com.lauriecs.exceptions.InvalidCmdException;
import com.lauriecs.utils.Validators;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;

public class ImageHttpCommand extends HttpCommand {

    public ImageHttpCommand(String cmdString) throws InvalidCmdException, IOException {
        super(cmdString);

    }

    public Boolean exec() throws CommandException, IOException {
        // Return false on empty params
        Document doc = Jsoup.connect(url.toString()).get();
        Elements imageElements = doc.select("img");
        return imageElements.size() > 0;

    }
}