package com.example.antalfarkas.hirplacc.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Article   {
  
  @SerializedName("_id")
  private String id = null;
  
  @SerializedName("description")
  private String description = null;
  
  @SerializedName("image_url")
  private String imageUrl = null;
  
  @SerializedName("title")
  private String title = null;
  
  @SerializedName("source_domain")
  private String sourceDomain = null;
  
  @SerializedName("text")
  private String text = null;
  
  @SerializedName("url")
  private String url = null;
  

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSourceDomain() {
    return sourceDomain;
  }
  public void setSourceDomain(String sourceDomain) {
    this.sourceDomain = sourceDomain;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return Objects.equals(id, article.id) &&
        Objects.equals(description, article.description) &&
        Objects.equals(imageUrl, article.imageUrl) &&
        Objects.equals(title, article.title) &&
        Objects.equals(sourceDomain, article.sourceDomain) &&
        Objects.equals(text, article.text) &&
        Objects.equals(url, article.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, imageUrl, title, sourceDomain, text, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Article {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    sourceDomain: ").append(toIndentedString(sourceDomain)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
