package com.lauriecs.imp;

import com.lauriecs.exceptions.CommandException;
import com.lauriecs.exceptions.InvalidCmdException;
import com.lauriecs.interfaces.HttpCommandType;

import java.io.IOException;

public class HttpCommandFactory {
    public static final int CMD_NAME_INDEX = 0;

    public static HttpCommand getCommand(String cmdString) throws CommandException, IOException {
        char cmdName = cmdString.charAt(CMD_NAME_INDEX);
        switch (cmdName) {
            case HttpCommandType.CHECK_CONTENT_TYPE:
                return new ContentTypeHttpCommand(cmdString);
            case HttpCommandType.CHECK_IMG:
                return new ImageHttpCommand(cmdString);

            default:
                throw new InvalidCmdException("Command type not found");
        }
    }
}
