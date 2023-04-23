package medikus.rs.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-23T09:58:40.755323600+02:00[Europe/Rome]")public class DeleteVisitResponse   {
  
  private @Valid CommonResultResponse result;

  /**
   **/
  public DeleteVisitResponse result(CommonResultResponse result) {
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
    DeleteVisitResponse deleteVisitResponse = (DeleteVisitResponse) o;
    return Objects.equals(this.result, deleteVisitResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteVisitResponse {\n");
    
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

