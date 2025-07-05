package com.crude.RestCRUD.exception;

public class CustomExceptionMessage {
    int status;


    String message;
    long timeStamp;

   CustomExceptionMessage()
   {

   }
    CustomExceptionMessage(String message,long time)
    {
        this.message = message;
        this.timeStamp = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return timeStamp;
    }

    public void setTimeStamp(long time) {
        this.timeStamp = time;
    }

    @Override
    public String toString() {
        return "CustomExceptionMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", time=" + timeStamp +
                '}';
    }
}
