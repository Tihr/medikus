package medikus.rs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-23T09:58:40.755323600+02:00[Europe/Rome]")public class RetrievePatientResponse   {
  
  private @Valid PatientResponse patientData;
  private @Valid List<VisitResponse> visits = new ArrayList<VisitResponse>();
  private @Valid CommonResultResponse result;

  /**
   **/
  public RetrievePatientResponse patientData(PatientResponse patientData) {
    this.patientData = patientData;
    return this;
  }

  

  
  @JsonProperty("patientData")
  public PatientResponse getPatientData() {
    return patientData;
  }

  public void setPatientData(PatientResponse patientData) {
    this.patientData = patientData;
  }/**
   **/
  public RetrievePatientResponse visits(List<VisitResponse> visits) {
    this.visits = visits;
    return this;
  }

  

  
  @JsonProperty("visits")
  public List<VisitResponse> getVisits() {
    return visits;
  }

  public void setVisits(List<VisitResponse> visits) {
    this.visits = visits;
  }/**
   **/
  public RetrievePatientResponse result(CommonResultResponse result) {
    this.result = result;
    return this;
  }

  

  
  @JsonProperty("result")
  public CommonResultResponse getResult() {
    return result;
  }

  public void setResult(CommonResultResponse result) {
    this.result = result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetrievePatientResponse retrievePatientResponse = (RetrievePatientResponse) o;
    return Objects.equals(this.patientData, retrievePatientResponse.patientData) &&
        Objects.equals(this.visits, retrievePatientResponse.visits) &&
        Objects.equals(this.result, retrievePatientResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientData, visits, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrievePatientResponse {\n");
    
    sb.append("    patientData: ").append(toIndentedString(patientData)).append("\n");
    sb.append("    visits: ").append(toIndentedString(visits)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

