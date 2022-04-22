package talentup.messaging_service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("sms")
public class Sms {
    @JsonIgnore
    @Null
    private UUID id;

    @JsonProperty
    @Max(16) @Min(6)
    private String from;

    @JsonProperty
    @Max(16) @Min(6)
    private String to;

    @JsonProperty
    @Max(120) @Min(1)
    private String text;
    private LocalDateTime dateTime;
}
