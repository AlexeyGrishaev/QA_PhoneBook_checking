package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Setter
@Getter
public class ContactDTO {
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String description;
}
