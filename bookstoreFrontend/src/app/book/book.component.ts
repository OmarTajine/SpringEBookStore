import { AddCartComponent } from './../add-cart/add-cart.component';
import { MatDialog } from '@angular/material/dialog';
import { BookService } from './../Services/book.service';
import { Component, OnInit } from '@angular/core';
import { Book } from '../Models/book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  quantite: string;
  name: string;
  books: any;
  book:any;
  constructor(private bookService: BookService, public dialog: MatDialog) { }

  openDialog(book){
    const dialogRef = this.dialog.open(AddCartComponent, {
      width: '800px',
      data: book
    });
    console.log(book);

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.quantite = result;
    });
  }
  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllBooks(){
    this.bookService.getAllBooks().subscribe(res => {
      this.books= res;
      console.log(res);
    })
  }

  delete(id){
    //delete item in student data
    this.bookService.deleteBook(id).subscribe(Response=>{
      //update list after delete in successful
      this.getAllBooks();
    })
  }


}
