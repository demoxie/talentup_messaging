package talentup.messaging_service.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 40)
    private String number;

    private Integer account_id;
}
