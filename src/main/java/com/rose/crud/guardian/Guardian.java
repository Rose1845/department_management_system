package com.rose.crud.guardian;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class Guardian {
    private String guardianFirstName;
    private String guardianLastName;
    private String phoneNumber;
    private String guardianEmail;

}
