package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Artist {
    Long id;
    String firstName;
    String lastName;
    String bio;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
