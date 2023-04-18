package medikus.rs.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-18T13:48:10.318236100+02:00[Europe/Rome]")public class VisitResponse   {
  
  private @Valid Long visitId;
  private @Valid VisitResponse visit;

  /**
   **/
  public VisitResponse visitId(Long visitId) {
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
  public VisitResponse visit(VisitResponse visit) {
    this.visit = visit;
    return this;
  }

  

  
  @JsonProperty("visit")
  public VisitResponse getVisit() {
    return visit;
  }

  public void setVisit(VisitResponse visit) {
    this.visit = visit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VisitResponse visitResponse = (VisitResponse) o;
    return Objects.equals(this.visitId, visitResponse.visitId) &&
        Objects.equals(this.visit, visitResponse.visit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitId, visit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VisitResponse {\n");
    
    sb.append("    visitId: ").append(toIndentedString(visitId)).append("\n");
    sb.append("    visit: ").append(toIndentedString(visit)).append("\n");
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

