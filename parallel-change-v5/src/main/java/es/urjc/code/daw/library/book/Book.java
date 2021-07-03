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

  private Integer price;

  public Book() {
  }

  public Book(String nombre, String preface, Integer price) {
    super();
    this.title = nombre;
    this.preface = preface;
    this.price = price;
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

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
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