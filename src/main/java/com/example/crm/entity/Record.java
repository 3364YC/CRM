package com.example.crm.entity;

public class Record {
    private int recordId;
    private  int customerId;
    private  String source;
    private  String note;
    private int state;

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", customerId=" + customerId +
                ", source='" + source + '\'' +
                ", note='" + note + '\'' +
                ", state=" + state +
                ", recordDate='" + recordDate + '\'' +
                '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    private  String recordDate;

}
