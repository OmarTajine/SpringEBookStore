package com.bcc.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDtoAdd {

	public Long id;

	public String title;

	public String author;

	public double price;

	public String releaseDate;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRelease(String releaseDate) {
		this.releaseDate = releaseDate;
	}

}
