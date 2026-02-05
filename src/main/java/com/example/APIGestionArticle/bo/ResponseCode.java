package com.example.APIGestionArticle.bo;

public class ResponseCode<T> {
    public String Code;
    public String Message;
    public T Data;

    public ResponseCode(String Code, String Message, T Data) {
        this.Code = Code;
        this.Message = Message;
        this.Data = Data;
    }
}
