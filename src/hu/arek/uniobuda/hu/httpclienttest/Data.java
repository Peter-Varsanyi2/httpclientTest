package hu.arek.uniobuda.hu.httpclienttest;

public class Data {

    private String name;
    private Integer num;
    private Double balance;
    private boolean vip;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public Data(final String name, final Integer num, final Double balance, final boolean vip) {
        this.name = name;
        this.num = num;
        this.balance = balance;
        this.vip = vip;
    }

    public void setNum(final Integer num) {
        this.num = num;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(final Double balance) {
        this.balance = balance;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(final boolean vip) {
        this.vip = vip;
    }
}
