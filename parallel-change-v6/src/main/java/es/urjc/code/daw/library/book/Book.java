package es.urjc.code.daw.library.book;

import javax.persistence.Column;
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

  private Integer price;

  @Column(name = "new_price")
  private Float newPrice;

  public Book() {
  }

  public Book(String nombre, String preface, Float newPrice) {
    super();
    this.title = nombre;
    this.preface = preface;
    this.newPrice = newPrice;
    this.price = (newPrice != null) ? Math.round(newPrice) : 0;
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

  public Float getNewPrice() {
    return this.newPrice != null ? this.newPrice : Float.valueOf(this.price);
  }

  public void setNewPrice(Float newPrice) {
    this.newPrice = newPrice;
    this.price = (newPrice != null) ? Math.round(newPrice) : 0;
  }

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", preface='" + preface + '\'' +
        ", price=" + newPrice +
        '}';
  }
}