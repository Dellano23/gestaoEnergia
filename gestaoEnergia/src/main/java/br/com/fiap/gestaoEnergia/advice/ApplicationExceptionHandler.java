package br.com.fiap.gestaoEnergia.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice //faz tratamento de excecao
public class ApplicationExceptionHandler {


    //colocou um bagulho errado no body de criar gestao por ex
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //DataIntegrityViolationException
    @ExceptionHandler(DataIntegrityViolationException.class) //tipo q esse metodo vai tratar
    public Map<String, String> mansearArgumentosInvalidos(DataIntegrityViolationException erro){
        Map<String, String> mapaDeErro = new HashMap<>();

        mapaDeErro.put("erro", "Violação de integridade no banco de dados: " + erro.getMostSpecificCause().getMessage());

        return mapaDeErro;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", "Atributo de tipo incorreto inserido na requisicao");
        return errorMap;
    }


}
