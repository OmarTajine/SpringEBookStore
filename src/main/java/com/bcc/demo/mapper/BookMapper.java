package com.bcc.demo.mapper;


import com.bcc.demo.dao.entity.Book;
import com.bcc.demo.dto.BookDto;
import com.bcc.demo.dto.BookDtoAdd;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookMapper {

    @Autowired
    private  ModelMapper mapper;

    public  BookDto entityToDto(Book book){

     
       return mapper.map(book,BookDto.class);
    }
    public  List<BookDto> entityToDtoList(List<Book> booksEntity){

        return booksEntity.stream()
                .map(book -> entityToDto(book)).collect(Collectors.toList());

    }

    public  List<BookDto> entityToDtoList2(List<Book> booksEntity){

        return booksEntity.stream()
                .map(book -> entityToDto(book)).collect(Collectors.toList());
    }



    public  Book dtoToEntity(BookDtoAdd dto){
        Book book=new Book();
        book.setAuthor(dto.author);
		book.setPrice(dto.price);
		book.setRelease(dto.releaseDate);
		book.setTitle(dto.title);

        return book;
    }


}
