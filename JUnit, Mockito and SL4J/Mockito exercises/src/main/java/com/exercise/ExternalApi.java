package com.exercise;

public interface ExternalApi {
    String getData();
    String getRecord(int id);
    void saveData(String data);
    void authenticate();
    void deleteData(String id);
}
