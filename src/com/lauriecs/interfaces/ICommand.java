package com.lauriecs.interfaces;

import com.lauriecs.exceptions.CommandException;

import java.io.IOException;

public interface ICommand<T> {
    public T exec() throws CommandException, IOException;
}
