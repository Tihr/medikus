package medikus.rs.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-23T09:58:40.755323600+02:00[Europe/Rome]")public class RegisterVisitRequest   {
  
  private @Valid Visit visitData;

  /**
   **/
  public RegisterVisitRequest visitData(Visit visitData) {
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
    RegisterVisitRequest registerVisitRequest = (RegisterVisitRequest) o;
    return Objects.equals(this.visitData, registerVisitRequest.visitData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterVisitRequest {\n");
    
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

