package br.com.thomasdacosta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ComicDate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-23T16:49:42.616568200-03:00[America/Sao_Paulo]")


public class ComicDate   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("date")
  private String date = null;

  public ComicDate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * A description of the date (e.g. onsale date, FOC date).
   * @return type
   **/
  @ApiModelProperty(value = "A description of the date (e.g. onsale date, FOC date).")
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ComicDate date(String date) {
    this.date = date;
    return this;
  }

  /**
   * The date.
   * @return date
   **/
  @ApiModelProperty(value = "The date.")
  
    public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComicDate comicDate = (ComicDate) o;
    return Objects.equals(this.type, comicDate.type) &&
        Objects.equals(this.date, comicDate.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComicDate {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
