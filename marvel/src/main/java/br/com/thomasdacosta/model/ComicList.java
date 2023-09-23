package br.com.thomasdacosta.model;

import java.util.Objects;
import br.com.thomasdacosta.model.ComicSummary;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ComicList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-23T16:49:42.616568200-03:00[America/Sao_Paulo]")


public class ComicList   {
  @JsonProperty("available")
  private BigDecimal available = null;

  @JsonProperty("returned")
  private BigDecimal returned = null;

  @JsonProperty("collectionURI")
  private String collectionURI = null;

  @JsonProperty("items")
  @Valid
  private List<ComicSummary> items = null;

  public ComicList available(BigDecimal available) {
    this.available = available;
    return this;
  }

  /**
   * The number of total available issues in this list. Will always be greater than or equal to the \"returned\" value.
   * @return available
   **/
  @ApiModelProperty(value = "The number of total available issues in this list. Will always be greater than or equal to the \"returned\" value.")
  
    @Valid
    public BigDecimal getAvailable() {
    return available;
  }

  public void setAvailable(BigDecimal available) {
    this.available = available;
  }

  public ComicList returned(BigDecimal returned) {
    this.returned = returned;
    return this;
  }

  /**
   * The number of issues returned in this collection (up to 20).
   * @return returned
   **/
  @ApiModelProperty(value = "The number of issues returned in this collection (up to 20).")
  
    @Valid
    public BigDecimal getReturned() {
    return returned;
  }

  public void setReturned(BigDecimal returned) {
    this.returned = returned;
  }

  public ComicList collectionURI(String collectionURI) {
    this.collectionURI = collectionURI;
    return this;
  }

  /**
   * The path to the full list of issues in this collection.
   * @return collectionURI
   **/
  @ApiModelProperty(value = "The path to the full list of issues in this collection.")
  
    public String getCollectionURI() {
    return collectionURI;
  }

  public void setCollectionURI(String collectionURI) {
    this.collectionURI = collectionURI;
  }

  public ComicList items(List<ComicSummary> items) {
    this.items = items;
    return this;
  }

  public ComicList addItemsItem(ComicSummary itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<ComicSummary>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * The list of returned issues in this collection.
   * @return items
   **/
  @ApiModelProperty(value = "The list of returned issues in this collection.")
      @Valid
    public List<ComicSummary> getItems() {
    return items;
  }

  public void setItems(List<ComicSummary> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComicList comicList = (ComicList) o;
    return Objects.equals(this.available, comicList.available) &&
        Objects.equals(this.returned, comicList.returned) &&
        Objects.equals(this.collectionURI, comicList.collectionURI) &&
        Objects.equals(this.items, comicList.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(available, returned, collectionURI, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComicList {\n");
    
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    returned: ").append(toIndentedString(returned)).append("\n");
    sb.append("    collectionURI: ").append(toIndentedString(collectionURI)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
