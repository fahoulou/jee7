package com.fab.chapter4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b"),
	@NamedQuery(name = "findBookH2G2", query = "SELECT b FROM Book b WHERE b.title ='H2G2'")
})
public class Book {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String title;
	private Float price;
	@Size(min = 10, max = 2000)
	private String description;
	private String isbn;
	private Integer nbOfPage;
	private Boolean illustrations;
	/**
	 * a
	 */
	public Book() {
	}
	/**
	 * @param title
	 * @param price
	 * @param description
	 * @param isbn
	 * @param nbOfPage
	 * @param illustrations
	 */
	public Book(String title, Float price, String description, String isbn, Integer nbOfPage,
			Boolean illustrations) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the nbOfPage
	 */
	public Integer getNbOfPage() {
		return nbOfPage;
	}
	/**
	 * @param nbOfPage the nbOfPage to set
	 */
	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}
	/**
	 * @return the illustrations
	 */
	public Boolean getIllustrations() {
		return illustrations;
	}
	/**
	 * @param illustrations the illustrations to set
	 */
	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((illustrations == null) ? 0 : illustrations.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((nbOfPage == null) ? 0 : nbOfPage.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (illustrations == null) {
			if (other.illustrations != null)
				return false;
		} else if (!illustrations.equals(other.illustrations))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (nbOfPage == null) {
			if (other.nbOfPage != null)
				return false;
		} else if (!nbOfPage.equals(other.nbOfPage))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=").append(id).append(", title=").append(title).append(", price=").append(price)
				.append(", description=").append(description).append(", isbn=").append(isbn).append(", nbOfPage=")
				.append(nbOfPage).append(", illustrations=").append(illustrations).append("]");
		return builder.toString();
	}
	
	
}
