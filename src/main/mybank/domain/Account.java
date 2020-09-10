package domain;

import lombok.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    String name;
    String accountType;
    double balance;
    String accountNumber;// Use first 2 letters of firstName + Acct. OpeningDate + SequenceNumber	// AV7OCT20191
    Set<String> accountOwners;
    Date joiningDate;
    boolean isActive;
}
