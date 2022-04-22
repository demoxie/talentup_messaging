package talentup.messaging_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 40,unique = true)
    private String authId;

    @Column(length = 30,unique = true)
    private String username;



}
