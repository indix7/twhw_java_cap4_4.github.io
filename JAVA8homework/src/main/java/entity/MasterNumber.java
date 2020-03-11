package entity;

import java.util.Objects;

public class MasterNumber {

    private String number;

    public MasterNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterNumber that = (MasterNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "MasterNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}