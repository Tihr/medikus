package medikus.rs.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-18T13:48:10.318236100+02:00[Europe/Rome]")public class PatientResponse   {
  
  private @Valid Patient patient;
  private @Valid Long patientId;

  /**
   **/
  public PatientResponse patient(Patient patient) {
    this.patient = patient;
    return this;
  }

  

  
  @JsonProperty("patient")
  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }/**
   **/
  public PatientResponse patientId(Long patientId) {
    this.patientId = patientId;
    return this;
  }

  

  
  @JsonProperty("patientId")
  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientResponse patientResponse = (PatientResponse) o;
    return Objects.equals(this.patient, patientResponse.patient) &&
        Objects.equals(this.patientId, patientResponse.patientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patient, patientId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientResponse {\n");
    
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("    patientId: ").append(toIndentedString(patientId)).append("\n");
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

