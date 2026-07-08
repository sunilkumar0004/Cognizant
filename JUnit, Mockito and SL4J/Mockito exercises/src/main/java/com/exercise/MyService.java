package com.exercise;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String getRecord(int id) {
        return externalApi.getRecord(id);
    }

    public void saveData(String data) {
        externalApi.saveData(data);
    }

    public String fetchSecureData() {
        externalApi.authenticate();
        return externalApi.getData();
    }

    public void deleteData(String id) {
        externalApi.deleteData(id);
    }
}
