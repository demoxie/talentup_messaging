package talentup.messaging_service.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(schema = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty
    @JsonAlias("from")
    private String from;
    @JsonProperty
    @JsonAlias("to")
    private String to;
    @JsonProperty
    @JsonAlias("text")
    private String text;
}
