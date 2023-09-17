package br.com.tchefoods.model;

public class PaymentMethodModel {
    private int id;
    private String desc;

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
