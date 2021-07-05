package es.urjc.code.daw.library.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;

  private String title;

  private String preface;

  private Float newPrice;
  private Float price;

  public Book() {
  }

  public Book(String nombre, String preface, Float price) {
    super();
    this.title = nombre;
    this.preface = preface;
    this.price = price;
    this.newPrice = newPrice;

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPreface() {
    return this.preface;
  }

  public void setPreface(String preface) {
    this.preface = preface;
  }

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Float getPrice() {
    return this.price != null ? this.price : this.newPrice;
  }

  public void setPrice(Float price) {
    this.price = price;
    this.newPrice = price;
  }

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", preface='" + preface + '\'' +
        ", price=" + price +
        '}';
  }
}