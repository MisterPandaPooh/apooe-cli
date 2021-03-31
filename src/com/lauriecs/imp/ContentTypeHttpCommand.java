package com.lauriecs.imp;

import com.lauriecs.exceptions.CommandException;
import com.lauriecs.exceptions.InvalidCmdException;
import com.lauriecs.utils.Validators;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class ContentTypeHttpCommand extends HttpCommand {
    private String contentTypeExcepted;

    public ContentTypeHttpCommand(String cmdString) throws InvalidCmdException, IOException {
        super(cmdString);

    }

    @Override
    protected void stringToCommand(String cmdString) throws InvalidCmdException, MalformedURLException {
        super.stringToCommand(cmdString);
        if(this.params.length > 0){
            int CONTENT_TYPE_PARAMS_INDEX = 0;
            this.contentTypeExcepted = this.params[CONTENT_TYPE_PARAMS_INDEX];
        }
    }

    @Override
    public Boolean exec() throws CommandException, IOException {
        // Return false on empty params
        if(Validators.isNullOrEmpty(this.contentTypeExcepted)) {
            return false;
        }

        HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        String contentType = connection.getContentType().toLowerCase();

        return contentType.contains(this.contentTypeExcepted.toLowerCase());
    }
}
