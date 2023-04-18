package medikus.rs.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-18T13:48:10.318236100+02:00[Europe/Rome]")public class CommonResultResponse   {
  
  private @Valid String xRequestID;
  private @Valid String code;
  private @Valid Boolean result;
  private @Valid String message;

  /**
   **/
  public CommonResultResponse xRequestID(String xRequestID) {
    this.xRequestID = xRequestID;
    return this;
  }

  

  
  @JsonProperty("X-Request-ID")
  public String getxRequestID() {
    return xRequestID;
  }

  public void setxRequestID(String xRequestID) {
    this.xRequestID = xRequestID;
  }/**
   **/
  public CommonResultResponse code(String code) {
    this.code = code;
    return this;
  }

  

  
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }/**
   **/
  public CommonResultResponse result(Boolean result) {
    this.result = result;
    return this;
  }

  

  
  @JsonProperty("result")
  public Boolean getResult() {
    return result;
  }

  public void setResult(Boolean result) {
    this.result = result;
  }/**
   **/
  public CommonResultResponse message(String message) {
    this.message = message;
    return this;
  }

  

  
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonResultResponse commonResultResponse = (CommonResultResponse) o;
    return Objects.equals(this.xRequestID, commonResultResponse.xRequestID) &&
        Objects.equals(this.code, commonResultResponse.code) &&
        Objects.equals(this.result, commonResultResponse.result) &&
        Objects.equals(this.message, commonResultResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xRequestID, code, result, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonResultResponse {\n");
    
    sb.append("    xRequestID: ").append(toIndentedString(xRequestID)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

