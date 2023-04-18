package medikus.rs.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-18T13:48:10.318236100+02:00[Europe/Rome]")public class Patient   {
  
  private @Valid String name;
  private @Valid String surname;
  private @Valid LocalDate birthdate;
  private @Valid String ssn;

  /**
   **/
  public Patient name(String name) {
    this.name = name;
    return this;
  }

  

  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }/**
   **/
  public Patient surname(String surname) {
    this.surname = surname;
    return this;
  }

  

  
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }/**
   **/
  public Patient birthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  

  
  @JsonProperty("birthdate")
  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }/**
   **/
  public Patient ssn(String ssn) {
    this.ssn = ssn;
    return this;
  }

  

  
  @JsonProperty("ssn")
  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Patient patient = (Patient) o;
    return Objects.equals(this.name, patient.name) &&
        Objects.equals(this.surname, patient.surname) &&
        Objects.equals(this.birthdate, patient.birthdate) &&
        Objects.equals(this.ssn, patient.ssn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, birthdate, ssn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    ssn: ").append(toIndentedString(ssn)).append("\n");
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

