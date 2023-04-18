package medikus.rs.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-18T13:48:10.318236100+02:00[Europe/Rome]")public class UpdateVisitRequest   {
  
  private @Valid Long visitId;
  private @Valid Visit visitData;

  /**
   **/
  public UpdateVisitRequest visitId(Long visitId) {
    this.visitId = visitId;
    return this;
  }

  

  
  @JsonProperty("visitId")
  public Long getVisitId() {
    return visitId;
  }

  public void setVisitId(Long visitId) {
    this.visitId = visitId;
  }/**
   **/
  public UpdateVisitRequest visitData(Visit visitData) {
    this.visitData = visitData;
    return this;
  }

  

  
  @JsonProperty("visitData")
  public Visit getVisitData() {
    return visitData;
  }

  public void setVisitData(Visit visitData) {
    this.visitData = visitData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateVisitRequest updateVisitRequest = (UpdateVisitRequest) o;
    return Objects.equals(this.visitId, updateVisitRequest.visitId) &&
        Objects.equals(this.visitData, updateVisitRequest.visitData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitId, visitData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateVisitRequest {\n");
    
    sb.append("    visitId: ").append(toIndentedString(visitId)).append("\n");
    sb.append("    visitData: ").append(toIndentedString(visitData)).append("\n");
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

