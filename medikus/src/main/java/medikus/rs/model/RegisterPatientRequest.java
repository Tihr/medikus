package medikus.rs.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-18T13:48:10.318236100+02:00[Europe/Rome]")public class RegisterPatientRequest   {
  
  private @Valid Patient patientData;

  /**
   **/
  public RegisterPatientRequest patientData(Patient patientData) {
    this.patientData = patientData;
    return this;
  }

  

  
  @JsonProperty("patientData")
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
    RegisterPatientRequest registerPatientRequest = (RegisterPatientRequest) o;
    return Objects.equals(this.patientData, registerPatientRequest.patientData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterPatientRequest {\n");
    
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

