package io.pivotal.cfapp.domain;

import java.time.Duration;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.davidmoten.guavamini.Optional;

import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "description", "from-datetime", "from-duration" })
@Getter
public class ServiceInstancePolicy {
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("from-datetime")
	private LocalDateTime fromDateTime;
	
	@JsonProperty("from-duration")
	private Duration fromDuration;

	@JsonCreator
	public ServiceInstancePolicy(@JsonProperty("description") String description, 
			@JsonProperty("from-datetime") LocalDateTime fromDateTime, 
			@JsonProperty("from-duration") Duration fromDuration) {
		this.description = description;
		this.fromDateTime = fromDateTime;
		this.fromDuration = fromDuration;
	}
	
	@JsonIgnore
	public boolean isInvalid() {
		return Optional.fromNullable(fromDateTime).isPresent() 
				&& Optional.fromNullable(fromDuration).isPresent();
	}
	
}