package medikus.rs.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-23T09:58:40.755323600+02:00[Europe/Rome]")public class Visit   {
  
  private @Valid LocalDate appointment;

public enum TypeEnum {

    HOME(String.valueOf("HOME")), OFFICE(String.valueOf("OFFICE"));


    private String value;

    TypeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
        for (TypeEnum b : TypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

  private @Valid TypeEnum type;

public enum ReasonEnum {

    FIRST(String.valueOf("FIRST")), RECURRING(String.valueOf("RECURRING")), URGENT(String.valueOf("URGENT"));


    private String value;

    ReasonEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ReasonEnum fromValue(String value) {
        for (ReasonEnum b : ReasonEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

  private @Valid ReasonEnum reason;
  private @Valid String history;

  /**
   **/
  public Visit appointment(LocalDate appointment) {
    this.appointment = appointment;
    return this;
  }

  

  
  @JsonProperty("appointment")
  @NotNull
  public LocalDate getAppointment() {
    return appointment;
  }

  public void setAppointment(LocalDate appointment) {
    this.appointment = appointment;
  }/**
   **/
  public Visit type(TypeEnum type) {
    this.type = type;
    return this;
  }

  

  
  @JsonProperty("type")
  @NotNull
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }/**
   **/
  public Visit reason(ReasonEnum reason) {
    this.reason = reason;
    return this;
  }

  

  
  @JsonProperty("reason")
  @NotNull
  public ReasonEnum getReason() {
    return reason;
  }

  public void setReason(ReasonEnum reason) {
    this.reason = reason;
  }/**
   **/
  public Visit history(String history) {
    this.history = history;
    return this;
  }

  

  
  @JsonProperty("history")
  public String getHistory() {
    return history;
  }

  public void setHistory(String history) {
    this.history = history;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Visit visit = (Visit) o;
    return Objects.equals(this.appointment, visit.appointment) &&
        Objects.equals(this.type, visit.type) &&
        Objects.equals(this.reason, visit.reason) &&
        Objects.equals(this.history, visit.history);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appointment, type, reason, history);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Visit {\n");
    
    sb.append("    appointment: ").append(toIndentedString(appointment)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    history: ").append(toIndentedString(history)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

