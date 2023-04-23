package medikus.rs.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-23T09:58:40.755323600+02:00[Europe/Rome]")public class UpdatePatientRequest   {
  
  private @Valid Long patientId;
  private @Valid Patient patientData;

  /**
   **/
  public UpdatePatientRequest patientId(Long patientId) {
    this.patientId = patientId;
    return this;
  }

  

  
  @JsonProperty("patientId")
  @NotNull
  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }/**
   **/
  public UpdatePatientRequest patientData(Patient patientData) {
    this.patientData = patientData;
    return this;
  }

  

  
  @JsonProperty("patientData")
  @NotNull
  public Patient getPatientData() {
    return patientData;
  }

  public void setPatientData(Patient patientData) {
    this.patientData = patientData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatePatientRequest updatePatientRequest = (UpdatePatientRequest) o;
    return Objects.equals(this.patientId, updatePatientRequest.patientId) &&
        Objects.equals(this.patientData, updatePatientRequest.patientData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, patientData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePatientRequest {\n");
    
    sb.append("    patientId: ").append(toIndentedString(patientId)).append("\n");
    sb.append("    patientData: ").append(toIndentedString(patientData)).append("\n");
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

