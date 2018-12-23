package Judgments.Objects;

import java.util.List;
import java.util.Objects;

public class Judge {
    public String name;
    public String function;
    public List<SpecialRole> specialRoles;
    public Integer amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Judge judge = (Judge) o;
        return Objects.equals(name, judge.name) &&
                Objects.equals(function, judge.function) &&
                Objects.equals(specialRoles, judge.specialRoles) &&
                Objects.equals(amount, judge.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, function, specialRoles, amount);
    }
}
