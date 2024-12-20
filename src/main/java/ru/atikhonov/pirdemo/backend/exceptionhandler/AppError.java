package ru.atikhonov.pirdemo.backend.exceptionhandler;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AppError {
    private final int statusCode;
    private final String message;
}
