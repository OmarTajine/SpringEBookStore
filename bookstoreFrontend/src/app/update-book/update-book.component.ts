import { BookService } from './../Services/book.service';
import { FormBuilder, Validators } from '@angular/forms';
import { Book } from './../Models/book';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  id: number;
  data:Book;
  booksForm = this.fb.group({
    id:[''],
    author:['',Validators.required],
    price:['', Validators.required],
    releaseDate:['',Validators.required],
    title:['',Validators.required]
  });

  constructor(  public activatedRoute: ActivatedRoute,
    public router: Router,
    public BookService: BookService,
    private fb: FormBuilder) {
      this.data=new Book();
  }
  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params["id"];
    //get item details using id
    this.BookService.getBookById(this.id).subscribe(response =>{
      console.log(response);
      this.data= response;
      this.booksForm.patchValue(this.data);
    })
  }

  update(){
    //update item by taking id and updated data object
    const  book = this.booksForm.value;
    console.log(this.booksForm.value)
    this.BookService.updateBook(this.id, book).subscribe(
      response => {
        console.log(response)
        this.booksForm.reset();
        this.router.navigate(['/books'])
      }
    )
  }

}
