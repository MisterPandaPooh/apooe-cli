package com.lauriecs.imp;

import com.lauriecs.exceptions.CommandException;
import com.lauriecs.exceptions.InvalidCmdException;
import com.lauriecs.interfaces.ICommand;
import com.lauriecs.utils.Validators;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class HttpCommand implements ICommand<Boolean> {
    protected String name;
    protected URL url;
    protected String[] params;
    protected static final String CMD_SEPARATOR = " ";
    protected static final int CMD_NAME_INDEX = 0;
    protected static final int CMD_URL_INDEX = 1;
    protected static final int CMD_PARAMS_START_INDEX = 2;

    public HttpCommand(String cmdString) throws InvalidCmdException, IOException {
        this.buildCommand(cmdString);
    }

    /**
     *
     * @param cmdString
     * @throws InvalidCmdException
     * @throws MalformedURLException
     */
    private void buildCommand(String cmdString) throws InvalidCmdException, MalformedURLException {
        this.stringToCommand(cmdString);
        if (!this.isValid()) {
            throw new InvalidCmdException("Invalid arguments");
        }
    }

    public boolean isValid() {
        return !Validators.isNullOrEmpty(this.name);
    }

    protected void stringToCommand(String cmdString) throws InvalidCmdException, MalformedURLException {
        String[] cmdArray = cmdString.split(CMD_SEPARATOR);

        // Check if the length of array prevent memory leak
        this.name = cmdArray[CMD_NAME_INDEX];
        this.url = new URL(cmdArray[CMD_URL_INDEX]);

        boolean notOutSideIndex = cmdArray.length - 1 >= CMD_PARAMS_START_INDEX;
        if(notOutSideIndex){
            this.params = Arrays.copyOfRange(cmdArray, CMD_PARAMS_START_INDEX, cmdArray.length);
        }
    }


    @Override
    public Boolean exec() throws CommandException, IOException {
        // Send request
        return false;
    }


    public String getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

    public String[] getParams() {
        return params;
    }
}
